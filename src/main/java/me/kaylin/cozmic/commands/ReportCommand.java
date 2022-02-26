package me.kaylin.cozmic.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kaylin.cozmic.utils.DiscordMessages;

public class ReportCommand implements CommandExecutor {

	private static final String reportChannel = "947014610903527444";
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {return false;}
		
		Player player = (Player) sender;
		Player argumentPlayer = player.getServer().getPlayerExact(args[0]);
		
		if(player.hasPermission("cozmic.report")) {
			if(!argumentPlayer.hasPermission("cozmic.report.bypass")) {
				if(args.length >= 1) {
					StringBuilder msg = new StringBuilder();
					
					for (String arg : args) {
						msg.append(arg + " ");
					}
					
					new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
				    Date date = new Date();  
					
					DiscordMessages.discordEmbeddedMessage(argumentPlayer.getDisplayName(), "Player was reported by " + player.getDisplayName() + " for '" + msg + "'.", "Date: " + date.toString(), null, null, Color.BLACK, reportChannel);
				}
			}
			
			player.sendMessage(label);
		}
		
		return false;
	}

}
