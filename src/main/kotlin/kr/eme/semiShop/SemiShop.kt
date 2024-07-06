package kr.eme.semiShop

import org.bukkit.plugin.java.JavaPlugin

class SemiShop : JavaPlugin() {

    companion object {
        lateinit var instance: SemiShop
            private set
    }

    override fun onEnable() {
        instance = this
        logger.info("SemiShop is enabled!")
    }
    override fun onDisable() {
        logger.info("SemiShop is disabled!")
    }
}