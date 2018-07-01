package net.comecraft.endpatch;

import org.bukkit.Bukkit;
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
public class EndGatewayPatch implements Listener {

	/**
	 * Intercepts teleport events from outer island return gateways.
	 * 
	 * @param event
	 *            The event fired by a player teleporting through a return gateway
	 *            from the end outer islands.
	 */
	@EventHandler
	public void onPlayerTpEvent(PlayerTeleportEvent event) {
		if (event.getCause().equals(TeleportCause.END_GATEWAY)) {

			Player player = event.getPlayer();

			// Do nothing if the player is on the centre island
			// TODO put distance in config
			if (player.getLocation().distance(player.getWorld().getSpawnLocation()) < 800) return;

			event.setCancelled(true);

			// Teleport the player
			// TODO put destination in config
			Core multiverse = (Core) Bukkit.getPluginManager().getPlugin("Multiverse-Core");
			String dest = player.getWorld().getName();
			MVDestination mvDest = multiverse.getDestFactory().getDestination(dest);
			multiverse.getSafeTTeleporter().teleport(Bukkit.getConsoleSender(), player, mvDest);
		}
	}
}
