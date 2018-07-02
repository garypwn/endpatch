package net.comecraft.endpatch;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import com.onarandombox.MultiverseCore.api.Core;
import com.onarandombox.MultiverseCore.api.MVDestination;

/**
 * EndGatewayPatch provides a workaround for a bug in minecraft where return
 * gateways from the outer islands send players to unsafe locations.
 */
public class EndGatewayPatch extends EndPatch implements Listener {

	/**
	 * {@inheritDoc}
	 */
	public EndGatewayPatch(FileConfiguration config) {
		super(config);
	}

	/**
	 * Intercepts teleport events from outer island return gateways.
	 * 
	 * @param event
	 *            The event fired by a player teleporting through a return gateway
	 *            from the end outer islands.
	 */
	@EventHandler
	public void onPlayerTpEvent(PlayerTeleportEvent event) {
		if (!this.enabled()) return;
		if (event.getCause().equals(TeleportCause.END_GATEWAY)) {

			Player player = event.getPlayer();

			// Do nothing if the player is on the centre island
			int safeDistance = getConfig().getInt(this.getClass().getName() + ".safe-radius");
			if (player.getLocation().distance(player.getWorld().getSpawnLocation()) < 800) return;

			event.setCancelled(true);

			// Teleport the player
			Core multiverse = (Core) Bukkit.getPluginManager().getPlugin("Multiverse-Core");
			
			// Get the target destination from the config
			String dest = getConfig().getString(this.getClass().getName() + ".destination");
			
			// If the config is set to "spawn" use the current world's spawn
			if (dest.equals("spawn")) {
				dest = player.getWorld().getName();
			}
			MVDestination mvDest = multiverse.getDestFactory().getDestination(dest);
			
			// Teleport the player
			multiverse.getSafeTTeleporter().teleport(Bukkit.getConsoleSender(), player, mvDest);
		}
	}
}
