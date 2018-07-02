package net.comecraft.endpatch;

import org.bukkit.configuration.file.FileConfiguration;

public abstract class EndPatch {
	
	private FileConfiguration config;

	/**
	 * Gets the config for this EndPatch
	 * @return this EndPatch's config
	 */
	public FileConfiguration getConfig() {
		return config;
	}

	/**
	 * Sets the config for this EndPatch
	 * @param config the new config
	 */
	public void setConfig(FileConfiguration config) {
		this.config = config;
	}
	
	/**
	 * Checks whether this patch should be enabled.
	 * @return true if this patch should be enabled.
	 */
	public boolean shouldEnable() {
		return config.getBoolean(this.getClass().getName() + ".enabled");
	}

	/**
	 * Instantiate a new EndPatch
	 */
	public EndPatch(FileConfiguration config) {
		this.config = config;
	}

}
