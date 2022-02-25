package me.kaylin.cozmic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.kaylin.cozmic.commands.ColorCommand;
import me.kaylin.cozmic.managers.DataManager;
import me.kaylin.cozmic.managers.InventoryManager;
import me.kaylin.cozmic.managers.ItemManager;
import net.luckperms.api.LuckPerms;

public class Main extends JavaPlugin {

	public static LuckPerms api;
	public DataManager data = new DataManager(this);
	public static ItemManager itemManager = new ItemManager();
	public static InventoryManager invManager = new InventoryManager();
	
	public void onEnable() {
		//Registers Luckperms API
		RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
		if (provider != null) { api = provider.getProvider(); }
		
		//Reload Data File
		DataManager.reloadConfig();
		this.data = new DataManager(this);
		
		//Initilise Managers
		itemManager.init();
		invManager.init();
		
		//Initilise Commands
		getCommand("color").setExecutor(new ColorCommand());
		
		//Initilise Events
		getServer().getPluginManager().registerEvents(new ColorCommand(), this);
		
	}
	
	public void onDisable() {
		DataManager.saveDefaultConfig();
	}
	
}
