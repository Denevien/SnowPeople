package com.Denevien.SnowPeople;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SnowPeople extends JavaPlugin{
    public final HandleSpawn handleSpawn = new HandleSpawn(this);
    
    public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(handleSpawn, this);
	}
}
