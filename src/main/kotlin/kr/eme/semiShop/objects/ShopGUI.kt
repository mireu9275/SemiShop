package kr.eme.semiShop.objects

import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.inventory.InventoryOpenEvent

class ShopGUI (
    player: Player,
    private val shop: Shop
) : GUI(
    player,
    "상점",
    shop.row
    )
{
    override fun setFirstGUI() {
        for(slot in 0 until size) {
            val item = shop.getItem(slot) ?: continue
            setItem(slot, item.getIcon())
        }
    }

    override fun InventoryClickEvent.clickEvent() {
        isCancelled = true
    }
    override fun InventoryCloseEvent.closeEvent(){

    }
    override fun InventoryDragEvent.dragEvent(){

    }
}