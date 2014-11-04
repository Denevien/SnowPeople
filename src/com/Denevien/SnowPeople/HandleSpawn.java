package com.Denevien.SnowPeople;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class HandleSpawn implements Listener{
    public SnowPeople plugin;
    
    public HandleSpawn(SnowPeople instance) {
		this.plugin = instance;
	}
    
    @EventHandler(ignoreCancelled = true)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        Entity e = event.getEntity();
        if (e.getWorld() != Bukkit.getWorlds().get(0)) {
            return;
        }
        if (e instanceof HumanEntity) {
            return;
        }
        Location loc = event.getLocation();
        Entity man = loc.getWorld().spawnEntity(loc,EntityType.SNOWMAN);
        e.remove();
	}
}
