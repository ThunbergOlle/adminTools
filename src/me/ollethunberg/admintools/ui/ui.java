package me.ollethunberg.admintools.ui;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ollethunberg.admintools.commands.flyCommand;
import me.ollethunberg.admintools.commands.toggleTimeCommand;
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
		utils.createItem(inv, 276, 1, 3, "&cAdmin Sword", "&7Usefull for slaying noobs!");
		utils.createItem(inv, 288, 1, 9, "&cToggle Fly", "Press to toggle fly.");
		utils.createItem(inv, 388, 1, 18, "&cDaytime", "Press to change the time to day");

		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player player, int slot, ItemStack clicked, Inventory inv) {
		boolean day = false;
		//THIS LINE IS THE PROBLEMO.
		switch (clicked.getType()) {
		case DIAMOND_PICKAXE:
			clicked.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
			clicked.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			player.getInventory().addItem(clicked);
			closeInv(player);
		case DIAMOND_AXE:
			clicked.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
			clicked.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
			clicked.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
			clicked.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			player.getInventory().addItem(clicked);
			closeInv(player);	
		
		case DIAMOND_SWORD:
			clicked.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
			clicked.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			clicked.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
			clicked.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
			clicked.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
			player.getInventory().addItem(clicked);
			closeInv(player);
		
		case FEATHER:
			flyCommand.fly(player);
			closeInv(player);
		
		case EMERALD:
			toggleTimeCommand.day(player);
			closeInv(player);
		}
			
	}
	public static void closeInv(Player player) {
		player.closeInventory();
	}
}
