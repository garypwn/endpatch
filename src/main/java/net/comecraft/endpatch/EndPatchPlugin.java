package net.comecraft.endpatch;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class EndPatchPlugin extends JavaPlugin {

	private DragonEggPatch eggPatch;
	private EndGatewayPatch gatewayPatch;
	
	@Override
	public void onEnable() {

		setDefaults();

		// Register event handlers
		eggPatch = new DragonEggPatch(getConfig());
		getServer().getPluginManager().registerEvents(eggPatch, this);
		
		gatewayPatch = new EndGatewayPatch(getConfig());
		getServer().getPluginManager().registerEvents(gatewayPatch, this);
	}

	// Gets default config values from a file and adds them to the fileconfig
	private void setDefaults() {

		// Get default config from resources folder
		InputStream defaults = getResource("configDefault.yml");
		Reader defaultReader = new InputStreamReader(defaults);
		Configuration defaultConfig = YamlConfiguration.loadConfiguration(defaultReader);

		// Set default config
		this.getConfig().setDefaults(defaultConfig);

		try {
			defaultReader.close();
		} catch (IOException e) {
			// Log the error
			Bukkit.getLogger().warning("[endpatch] error reading default configuration.");
		}
	}
}
