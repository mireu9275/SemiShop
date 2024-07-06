package kr.eme.semiShop.objects

import org.bukkit.inventory.ItemStack

class Shop (
    val key: String,
    val row: Int,
    private val itemMap: HashMap<Int, ShopItem> = HashMap()
) {
    fun getItem(slot: Int): ShopItem? = itemMap[slot]
    fun setItem(slot: Int, itemStack: ItemStack) {
        itemMap[slot] = ShopItem(itemStack)
    }
}