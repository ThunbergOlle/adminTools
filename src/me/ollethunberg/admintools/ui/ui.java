package me.ollethunberg.admintools.ui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ollethunberg.admintools.utils.utils;

public class ui {
	public static Inventory inv;
	public static String inventory_name;
	//amount of rows inside the ui
	public static int inv_boxes = 4;
	
	//MATHS
	public static int rows = inv_boxes * 9;
	
	//INITIALIZE
	public static void initialize() {
		inventory_name = utils.chat("&6&lAdmin Tools Beta");
		
		inv = Bukkit.createInventory(null, rows);
		
	}
	public static Inventory GUI (Player player) {
		Inventory toReturn = Bukkit.createInventory(null, rows, inventory_name);
		
		
		utils.createItem(inv, 278, 1, 1, "&cAdmin Pickaxe", "&7Usefull if you want to dig");
		utils.createItem(inv, 279, 1, 2, "&cAdmin Axe", "&7Usefull if you want to cut trees");
		utils.createItem(inv, 1, 3, 3, "&cAdmin Sword", "&7Usefull for slaying noobs!");

		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player player, int slot, ItemStack clicked, Inventory inv) {
		if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.chat("&cAdmin Pickaxe"))) {
			player.setDisplayName(utils.chat("&8You selected an admin item!"));
		}else {
			
		}
	}
}
