package kr.eme.semiShop.objects

import kr.eme.semiShop.enums.GUIMode
import kr.eme.semiShop.utils.ItemStackBuilder
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.ItemStack

class ShopSetupGUI (
    player: Player,
    val shop: Shop
) : GUI (
    player,
    "상점 설정",
    shop.row
){

    companion object {
        private const val SETUP_BUY_PRICE_SLOT: Int = 0
        private const val SETUP_SELL_PRICE_SLOT: Int = 1
    }

    private lateinit var guiMode : GUIMode
    private lateinit var selectShopItem : ShopItem

    private fun setSetupItemGUI(shopItem: ShopItem) {
        guiMode = GUIMode.SHOP_ITEM
        selectShopItem = shopItem
        clear()
        setItem(SETUP_BUY_PRICE_SLOT, getSetupBuyPriceIcon(shopItem.buyPrice))
        setItem(SETUP_SELL_PRICE_SLOT, getSetupSellPriceIcon(shopItem.sellPrice))
    }
    private fun getSetupBuyPriceIcon(buyPrice: Int?): ItemStack {
        return ItemStackBuilder.build(Material.DIAMOND) { item, meta ->
            meta.displayName(Component.text("구매 가격", NamedTextColor.GOLD))
            meta.lore(listOf(
                Component.text("현재 가격 : ${buyPrice ?: "구매 불가 (미설정)"}", if (buyPrice != null) NamedTextColor.GREEN else NamedTextColor.RED),
                Component.text("클릭 : 수정", NamedTextColor.YELLOW)
            ))
        }
    }
    private fun getSetupSellPriceIcon(sellPrice: Int?): ItemStack {
        return ItemStackBuilder.build(Material.GOLD_INGOT) { item, meta ->
            meta.displayName(Component.text("판매 가격", NamedTextColor.GOLD))
            meta.lore(listOf(
                Component.text("현재 가격 : ${sellPrice ?: "판매 불가 (미설정)"}", if (sellPrice != null) NamedTextColor.GREEN else NamedTextColor.RED),
                Component.text("클릭 : 수정", NamedTextColor.YELLOW)
            ))
        }
    }
    private fun openSetBuyPricePanel() {
        close()
    }

    override fun setFirstGUI() {
        TODO("Not yet implemented")
    }

    override fun InventoryClickEvent.clickEvent() {
        TODO("Not yet implemented")
    }

    override fun InventoryDragEvent.dragEvent() {
        TODO("Not yet implemented")
    }

    override fun InventoryCloseEvent.closeEvent() {
        TODO("Not yet implemented")
    }
}