package com.Denevien.SnowPeople;

import com.mewin.WGCustomFlags.WGCustomFlagsPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.StateFlag;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SnowPeople extends JavaPlugin{
    public final HandleSpawn handleSpawn = new HandleSpawn(this);
    public StateFlag ANGRY_SNOWMEN;
    
    public void onEnable() {
        WGCustomFlagsPlugin wgCustomFlagsPlugin = getPlugin("WGCustomFlags", WGCustomFlagsPlugin.class, true);
        WorldGuardPlugin worldGuardPlugin = getPlugin("WorldGuard", WorldGuardPlugin.class, true);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(handleSpawn, this);
        
        ANGRY_SNOWMEN = new StateFlag("angry-snowmen", false);
        wgCustomFlagsPlugin.addCustomFlag(ANGRY_SNOWMEN);
        
        TargetingRunnable tr = new TargetingRunnable(this,worldGuardPlugin);
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this, tr, 100L, 100L);
	}
    
    private <T extends Plugin> T getPlugin(String name, Class<T> mainClass, boolean required) {
        Plugin plugin = getServer().getPluginManager().getPlugin(name);
        if (required && (plugin == null || !mainClass.isInstance(plugin))) {
            getLogger().warning("[" + getName() + "] " + name + " is required for this plugin to work; disabling.");
            getServer().getPluginManager().disablePlugin(this);
        }
        return mainClass.cast(plugin);
    }
}
