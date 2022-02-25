package me.kaylin.cozmic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.kaylin.cozmic.Main;
import me.kaylin.cozmic.managers.DataManager;

public class ColorCommand implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) { return false; }
		
		Player player = (Player) sender;
		
		if(player.hasPermission("cozmic.color")) {
			player.openInventory(Main.invManager.color);
		}
		
		return false;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		Inventory inv = event.getClickedInventory();
		
		if(inv == Main.invManager.color) {
			if(item.getItemMeta() == Main.itemManager.whiteChatColor) {
				DataManager.getConfig().set("playerdata." + player.getUniqueId() + ".chatColor", "&f");
			}
		}
	}

}
