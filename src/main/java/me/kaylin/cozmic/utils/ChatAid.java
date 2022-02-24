package me.kaylin.cozmic.utils;

import net.md_5.bungee.api.ChatColor;

public class ChatAid {

	/**
	 * Allows string to use Chat Color Codes
	 * 
	 * @param String Message to be colored
	 */
	
	public static String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
}
