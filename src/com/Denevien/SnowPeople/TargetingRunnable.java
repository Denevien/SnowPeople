package com.Denevien.SnowPeople;

import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;

public class TargetingRunnable implements Runnable{
    
    private final SnowPeople plugin;
    
    public TargetingRunnable(SnowPeople plugin){
        this.plugin = plugin;
    }
    
    public void run(){
        Player[] onlinePlayers = plugin.getServer().getOnlinePlayers();
        for(Player player : onlinePlayers){
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
