package net.comecraft.endpatch;

import org.bukkit.configuration.file.FileConfiguration;

public abstract class EndPatch {
	
	private FileConfiguration config;

	public FileConfiguration getConfig() {
		return config;
	}

	public void setConfig(FileConfiguration config) {
		this.config = config;
	}

	public EndPatch(FileConfiguration config) {
		this.config = config;
	}

}
