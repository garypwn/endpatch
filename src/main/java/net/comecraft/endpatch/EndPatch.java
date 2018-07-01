package net.comecraft.endpatch;

import org.bukkit.plugin.java.JavaPlugin;

public class EndPatch extends JavaPlugin {

	@Override
	public void onEnable() {
		
		// Register event handlers
		getServer().getPluginManager().registerEvents(new DragonEggPatch(), this);
		getServer().getPluginManager().registerEvents(new EndGatewayPatch(), this);
	}
}
