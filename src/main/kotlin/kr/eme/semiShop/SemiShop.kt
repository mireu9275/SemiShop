package kr.eme.semiShop

import org.bukkit.plugin.java.JavaPlugin

class SemiShop : JavaPlugin() {
    override fun onEnable() {
        logger.info("SemiShop is enabled!")
    }
    override fun onDisable() {
        logger.info("SemiShop is disabled!")
    }
}