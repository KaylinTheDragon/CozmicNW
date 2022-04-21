package me.kaylin.cozmic.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.kaylin.cozmic.utils.LP;
import net.luckperms.api.model.user.User;

public class BasicPlayerEvents implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		
		User user = LP.getUser(player);
		String prefix = LP.getPrefix(user) != null ? LP.getPrefix(user) : "";
		String suffix = LP.getSuffix(user) != null ? LP.getSuffix(user) : "";
		
		if(message.startsWith("#")) {
			if(player.hasPermission("cozmic.staffchat")) {
				message.replace("#", " ");
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(all.hasPermission("cozmic.staffchat")) {
						all.sendMessage("&7&l[&3&lSC&7&l] &r" + prefix + player.getDisplayName() + suffix + ": " + message);
					}
				}
			}
		} else {
			event.setFormat(prefix + player.getDisplayName() + suffix + "&7: &r" + message);
		}
	}

}
