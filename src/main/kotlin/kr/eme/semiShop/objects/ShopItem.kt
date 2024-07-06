package kr.eme.semiShop.objects

import org.bukkit.inventory.ItemStack

class ShopItem(
    val itemStack: ItemStack,
    buyPrice: Int? = null,
    sellPrice: Int? = null,
) {
    var buyPrice: Int? = buyPrice
        private set
    var sellPrice: Int? = sellPrice
        private set

    fun setBuyPrice(amount: Int?) { buyPrice = amount }
    fun setSellPrice(amount: Int?) { sellPrice = amount }

    fun getIcon(): ItemStack {
        val item: ItemStack = itemStack.clone()
        val meta = item.itemMeta
        val lore = if(meta.hasLore()) meta.lore!! else ArrayList()
        lore.add("")
        lore.add("§e구매 가격 : ${buyPrice ?: "§c구매 불가"}")
        lore.add("§e판매 가격 : ${sellPrice ?: "§c판매 불가"}")
        meta.lore = lore
        item.itemMeta = meta
        return item
    }

    fun getSetupIcon(): ItemStack {
        val item: ItemStack = itemStack.clone()
        val meta = item.itemMeta
        val lore = if(meta.hasLore()) meta.lore!! else ArrayList()
        lore.add("")
        lore.add("§e구매 가격 : ${buyPrice ?: "§c구매 불가"}")
        lore.add("§e판매 가격 : ${sellPrice ?: "§c판매 불가"}")
        lore.add("")
        lore.add("§a클릭 : 수정")
        meta.lore = lore
        item.itemMeta = meta
        return item
    }
}
