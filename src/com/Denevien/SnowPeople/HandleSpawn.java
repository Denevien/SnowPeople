package com.Denevien.SnowPeople;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class HandleSpawn implements Listener{
    public SnowPeople plugin;
    
    public HandleSpawn(SnowPeople instance) {
		this.plugin = instance;
	}
    
    @EventHandler(ignoreCancelled = true)
    public void onEntitySpawn(EntitySpawnEvent event) {
        Entity e = event.getEntity();
        Location loc = event.getLocation();
        if(loc.getChunk().getEntities().length > 5){
            Entity[] entities = loc.getChunk().getEntities();
            event.setCancelled(true);
            for(int i=30;i<entities.length;i++){
                entities[i].remove();
            }
        }else if(!(e instanceof Player || e instanceof Snowman)) {
            event.setCancelled(true);
            loc.getWorld().spawnEntity(loc,EntityType.SNOWMAN);
        }
	}
}
