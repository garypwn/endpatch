package net.comecraft.endpatch;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public abstract class EndPatch {
	
	private Plugin plugin;

	/**
	 * Gets the config for this EndPatch
	 * @return this EndPatch's config
	 */
	public FileConfiguration getConfig() {
		return plugin.getConfig();
	}
	
	/**
	 * Checks whether this patch should be enabled.
	 * @return true if this patch should be enabled.
	 */
	public boolean enabled() {
		return getConfig().getBoolean(getClass().getSimpleName() + ".enabled");
	}

	/**
	 * Instantiate a new EndPatch
	 */
	public EndPatch(Plugin plugin) {
		this.plugin = plugin;
	}

}
