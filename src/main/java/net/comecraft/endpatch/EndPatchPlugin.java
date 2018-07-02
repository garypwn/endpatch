package net.comecraft.endpatch;

import org.bukkit.plugin.java.JavaPlugin;

public class EndPatchPlugin extends JavaPlugin {

	private DragonEggPatch eggPatch;
	private EndGatewayPatch gatewayPatch;
	
	@Override
	public void onEnable() {

		saveDefaultConfig();
		
		// Register event handlers
		eggPatch = new DragonEggPatch(getConfig());
		getServer().getPluginManager().registerEvents(eggPatch, this);
		
		gatewayPatch = new EndGatewayPatch(getConfig());
		getServer().getPluginManager().registerEvents(gatewayPatch, this);
	}
}
