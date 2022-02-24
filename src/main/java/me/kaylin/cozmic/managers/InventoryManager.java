package me.kaylin.cozmic.managers;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import me.kaylin.cozmic.Main;
import me.kaylin.cozmic.utils.ChatAid;

public class InventoryManager {
	
	public Inventory color;
	
	public void init() {
		buildColorUI();	
	}
	
	private void buildColorUI() {
		Inventory inv = Bukkit.createInventory(null, 54, ChatAid.color("Please pick a Chat Color"));
		
		inv.setItem(1, Main.itemManager.whiteChatColor);
		inv.setItem(2, Main.itemManager.redChatColor);
		inv.setItem(3, Main.itemManager.blueChatColor);
		inv.setItem(4, Main.itemManager.greenChatColor);
		
		color = inv;
	}

}
