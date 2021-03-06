package net.comecraft.endpatch;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.plugin.Plugin;

/**
 * DragonEggPatch attempts to address broken behaviour with dragon eggs. It
 * stops dragon egg teleportation and disables dragon egg physics.
 */
public class DragonEggPatch extends EndPatch implements Listener {

	/**
	 * {@inheritDoc}
	 */
	public DragonEggPatch(Plugin plugin) {
		super(plugin);
	}

	/**
	 * Stop dragon egg teleportation.
	 * 
	 * @param event
	 *            The event fired by the dragon egg trying to teleport.
	 */
	@EventHandler
	public void onDragonEggTp(BlockFromToEvent event) {
		if (!this.enabled()) return;
		if (event.getBlock().getType().equals(Material.DRAGON_EGG)) {
			event.setCancelled(true);
		}
	}

	/**
	 * Stop dragon egg physics if you break the block below the dragon egg.
	 * 
	 * @param event
	 *            The event fired when breaking a block below a dragon egg.
	 */
	@EventHandler
	public void onDragonEggPhysics(BlockPhysicsEvent event) {
		if (!this.enabled()) return;
		if (event.getBlock().getType().equals(Material.DRAGON_EGG)) {
			event.setCancelled(true);
		}
	}
}
