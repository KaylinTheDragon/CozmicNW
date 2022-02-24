package me.kaylin.cozmic.managers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.kaylin.cozmic.Main;

public class DataManager {
	
	private static Main main;
	private static FileConfiguration dataConfig = null;
	private static File configFile = null;

	
	public DataManager(Main plugin) {
		main = plugin;
		saveDefaultConfig();
	}
	
	public static void reloadConfig() {
		if(configFile == null) {
			configFile = new File(main.getDataFolder(), "data.yml");
		}
		dataConfig = YamlConfiguration.loadConfiguration(configFile);
		
		InputStream defaultStream = main.getResource("data.yml");
		if(defaultStream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
			dataConfig.setDefaults(defaultConfig);
		}
	}
	
	
	public static FileConfiguration getConfig() {
		if(dataConfig == null) {
			reloadConfig();
		}
		return dataConfig;
	}
	
	public static void saveConfig() {
		if(dataConfig == null || configFile == null) {
			return;
		}
		
		try {
			getConfig().save(configFile);
		} catch (IOException e) {
			main.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, e);
		}
	}
	
	public static void saveDefaultConfig() {
		if(configFile == null) {
			configFile = new File(main.getDataFolder(), "data.yml");
		}
		if(!configFile.exists()) {
			main.saveResource("data.yml", false);
		}
	}
}
