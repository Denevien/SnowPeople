package com.Denevien.SnowPeople;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
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
        if(e instanceof LivingEntity){
            if(loc.getChunk().getEntities().length > 5){
                int x = 0;
                for(Entity ent : loc.getChunk().getEntities()){
                    if(ent instanceof Snowman){
                        x++;
                    }
                    if(x==5){
                        event.setCancelled(true);
                        break;
                    }
                }
            }else if(!(e instanceof Player || e instanceof Snowman)) {
                event.setCancelled(true);
                loc.getWorld().spawnEntity(loc,EntityType.SNOWMAN);
            }
        }
	}
    
    @EventHandler(ignoreCancelled = true)
    public void onEntityBlockForm(EntityBlockFormEvent event){
        if(event.getEntity() instanceof Snowman){
            event.setCancelled(true);
        }
    }
}
