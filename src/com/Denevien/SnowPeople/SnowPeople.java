package com.Denevien.SnowPeople;

import static org.bukkit.Bukkit.getServer;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SnowPeople extends JavaPlugin{
    public final HandleSpawn handleSpawn = new HandleSpawn(this);
    
    public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(handleSpawn, this);
        TargetingRunnable tr = new TargetingRunnable(this);
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this, tr, 100L, 100L);
	}
}
