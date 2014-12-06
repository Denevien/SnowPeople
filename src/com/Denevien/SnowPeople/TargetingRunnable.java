package com.Denevien.SnowPeople;

import com.mewin.WGCustomFlags.WGCustomFlagsPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;

public class TargetingRunnable implements Runnable{
    
    private final SnowPeople plugin;
    private final WorldGuardPlugin worldguard;
    
    public TargetingRunnable(SnowPeople plugin, WorldGuardPlugin worldGuardPlugin){
        this.plugin = plugin;
        this.worldguard = worldGuardPlugin;
    }
    
    @Override
    public void run(){
        Player[] onlinePlayers = plugin.getServer().getOnlinePlayers();
        for(Player player : onlinePlayers){
            ApplicableRegionSet setAtLocation = worldguard.getGlobalRegionManager().get(player.getLocation().getWorld()).getApplicableRegions(player.getLocation());
            if (setAtLocation.allows(plugin.ANGRY_SNOWMEN)) {
                List<Entity> mobs = player.getNearbyEntities(32, 32, 32);
                for(Entity mob : mobs){
                    if(mob instanceof Snowman){
                        Snowman snowman = (Snowman)mob;
                        snowman.setTarget(player);
                    }
                }
            }
        }        
    }
}
