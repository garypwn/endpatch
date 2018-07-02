package net.comecraft.endpatch;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Container for all of endpatch's configurable options.
 */
public class Config {

	private FileConfiguration conf;

	/**
	 * Get an endpatch config from a FileConfiguration
	 * @param conf and endpatch configuration FileConfig
	 */
	public Config(FileConfiguration conf) {
		this.conf = conf;
		setDefaults();
	}

	// Gets default config values from a file and adds them to the fileconfig
	private void setDefaults() {
		
		// Get default config from resources folder
		InputStream defaults = Bukkit.getPluginManager().getPlugin("endpatch").getResource("configDefault.yml");
		Reader defaultReader = new InputStreamReader(defaults);
		Configuration defaultConfig = YamlConfiguration.loadConfiguration(defaultReader);
		
		this.conf.setDefaults(defaultConfig);
		
		try {
			defaultReader.close();
		} catch (IOException e) {
			// Log the error
			Bukkit.getLogger().warning("[endpatch] error getting default configuration.");
		}
	}
}
