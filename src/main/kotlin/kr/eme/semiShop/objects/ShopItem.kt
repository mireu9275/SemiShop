package kr.eme.semiShop.objects

import org.bukkit.Material

data class ShopItem(
    val material: Material,
    var basePrice: Int,     //원가
    var currentPrice: Int   //현재가(변경가)
)
