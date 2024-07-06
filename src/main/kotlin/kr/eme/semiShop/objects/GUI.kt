package kr.eme.semiShop.objects

import kr.eme.semiShop.coroutine.sync
import kr.eme.semiShop.managers.GUIManager
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

abstract class GUI {
    val player: Player
    val size: Int
    private val inventory: Inventory

    constructor(player: Player, title: String, row: Int) {
        this.player = player
        this.size = row * 9
        inventory = Bukkit.createInventory(null, row * 9, Component.text(title))
    }
    constructor(player: Player, title: String, type: InventoryType) {
        this.player = player
        this.size = type.defaultSize
        inventory = Bukkit.createInventory(null, type, Component.text(title))
    }
    fun getItem(slot: Int): ItemStack? = inventory.getItem(slot)
    fun setItem(slot: Int, itemStack: ItemStack?) = inventory.setItem(slot, itemStack)
    fun clear() {
        for(slot in 0 until size) {
            setItem(slot, null)
        }
    }
    fun firstOpen() {
        setFirstGUI()
        GUIManager.setGUI(player.uniqueId, this@GUI)
        open()
    }
    fun open() {
        sync {
            player.closeInventory()
            player.openInventory(inventory)
        }
    }

    fun onClick(e: InventoryClickEvent) { e.clickEvent() }
    fun onDrag(e: InventoryDragEvent) { e.dragEvent() }
    fun onClose(e: InventoryCloseEvent) { GUIManager.removeGUI(player.uniqueId); e.closeEvent() }
    abstract fun setFirstGUI()
    abstract fun InventoryClickEvent.clickEvent()
    abstract fun InventoryDragEvent.dragEvent()
    abstract fun InventoryCloseEvent.closeEvent()
}