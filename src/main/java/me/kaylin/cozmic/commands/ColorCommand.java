package me.kaylin.cozmic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kaylin.cozmic.Main;

public class ColorCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) { return false; }
		
		Player player = (Player) sender;
		
		if(player.hasPermission("cozmic.color")) {
			player.openInventory(Main.invManager.color);
		}
		
		return false;
	}

}
