package net.comecraft.endpatch;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class DragonEggPatch implements Listener {

	@EventHandler
	public void onDragonEggTp(BlockFromToEvent event) {
		if (event.getBlock().getType().equals(Material.DRAGON_EGG)) {
			event.setCancelled(true);
		}
	}
}
