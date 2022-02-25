package me.kaylin.cozmic;

import me.kaylin.cozmic.discord.DiscordEvents;
import me.kaylin.cozmic.discord.Events;
import me.kaylin.cozmic.discord.SpigotEvents;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.kaylin.cozmic.commands.ColorCommand;
import me.kaylin.cozmic.managers.DataManager;
import me.kaylin.cozmic.managers.InventoryManager;
import me.kaylin.cozmic.managers.ItemManager;
import net.luckperms.api.LuckPerms;

import javax.security.auth.login.LoginException;

public class Main extends JavaPlugin {

	public static JDA jda;
	public static LuckPerms api;
	public DataManager data = new DataManager(this);
	public static ItemManager itemManager = new ItemManager();
	public static InventoryManager invManager = new InventoryManager();
	
	public void onEnable() {

		//Grabbing the bot token
		String bottoken = getConfig().getString("bot-token");

		//Attempting to try logging into the bot
		try {
			jda = JDABuilder.createDefault(bottoken)
					.build()
					.awaitReady(); // Stop execution of code until the bot/plugin is ready
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (LoginException e) {
			e.printStackTrace();
		}

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
		
		//Initilise Events Spigot
		getServer().getPluginManager().registerEvents(new ColorCommand(), this);
		getServer().getPluginManager().registerEvents(new SpigotEvents(), this);

		//Initilise JDA Events
		jda.addEventListener(new DiscordEvents());
		
	}
	
	public void onDisable() {
		//If JDA is connected it will shutdown the bot
		if (jda != null) {jda.shutdownNow();}
		DataManager.saveDefaultConfig();
	}
	
}
