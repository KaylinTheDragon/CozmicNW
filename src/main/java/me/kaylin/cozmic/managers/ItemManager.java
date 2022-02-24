package me.kaylin.cozmic.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.kaylin.cozmic.utils.ChatAid;

public class ItemManager {

	public ItemStack whiteChatColor;
	public ItemStack redChatColor;
	public ItemStack blueChatColor;
	public ItemStack greenChatColor;
	
	public void init() {
		buildWhiteChat();
		buildRedChat();
		buildBlueChat();
		buildGreenChat();
	}
	
	private void buildWhiteChat() {
		ItemStack item = new ItemStack(Material.WHITE_WOOL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();		

		meta.setDisplayName(ChatAid.color("&f&lWhite"));
		
		lore.add("&7&lLeft-Click Me to set your Chat Color &f&lWhite");
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		whiteChatColor = item;
	}
	
	private void buildRedChat() {
		ItemStack item = new ItemStack(Material.RED_WOOL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();		

		meta.setDisplayName(ChatAid.color("&c&lRed"));
		
		lore.add("&7&lLeft-Click Me to set your Chat Color &c&lRed");
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		redChatColor = item;
	}
	
	private void buildBlueChat() {
		ItemStack item = new ItemStack(Material.BLUE_WOOL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();		

		meta.setDisplayName(ChatAid.color("&9&lBlue"));
		
		lore.add("&7&lLeft-Click Me to set your Chat Color &9&lBlue");
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		blueChatColor = item;
	}
	
	private void buildGreenChat() {
		ItemStack item = new ItemStack(Material.GREEN_WOOL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();		

		meta.setDisplayName(ChatAid.color("&a&lGreen"));
		
		lore.add("&7&lLeft-Click Me to set your Chat Color &a&lGreen");
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		greenChatColor = item;
	}
	
}
