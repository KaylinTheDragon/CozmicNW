package me.kaylin.cozmic.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.kaylin.cozmic.Main;
import net.luckperms.api.model.user.User;

public class LP {
	
	public static User getUser(String name) {
		return Main.api.getPlayerAdapter(Player.class).getUser(Bukkit.getPlayer(name));
	}
	
	public static User getUser(Player player) {
		return Main.api.getPlayerAdapter(Player.class).getUser(player);
	}
	
	public static String getPrefix(User user) {
		return user.getCachedData().getMetaData().getPrefix();
	}

	
	public static String getSuffix(User user) {
		return user.getCachedData().getMetaData().getSuffix();
	}
}
