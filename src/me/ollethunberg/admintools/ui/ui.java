package me.ollethunberg.admintools.ui;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ollethunberg.admintools.commands.barCommand;
import me.ollethunberg.admintools.commands.flyCommand;
import me.ollethunberg.admintools.commands.toggleTimeCommand;
import me.ollethunberg.admintools.commands.toggledownfallCommand;
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
		
		
		utils.createItem(inv, 278, 1, 19, "&cAdmin Pickaxe", "&7Usefull if you want to dig");
		utils.createItem(inv, 279, 1, 10, "&cAdmin Axe", "&7Usefull if you want to cut trees");
		utils.createItem(inv, 276, 1, 1, "&cAdmin Sword", "&7Usefull for slaying noobs!");
		utils.createItem(inv, 288, 1, 9, "&6Toggle Fly", "Press to toggle fly.");
		utils.createItem(inv, 388, 1, 18, "&cDaytime", "Press to change the time to day");
		utils.createItem(inv, 263, 1, 27, "&cNightTime", "Press to change the time to night");
		utils.createItem(inv, 260, 1, 36, "&cHeal", "Press restore your life!");
		utils.createItem(inv, 22, 1, 28, "&cToggledownfall", "Toggle the downfall!");
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
			break;

		case DIAMOND_AXE:
			clicked.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
			clicked.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
			clicked.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
			clicked.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			player.getInventory().addItem(clicked);
			closeInv(player);	
			break;

		case DIAMOND_SWORD:
			clicked.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
			clicked.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			clicked.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
			clicked.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
			clicked.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
			player.getInventory().addItem(clicked);
			closeInv(player);
			break;

		case FEATHER:
			flyCommand.fly(player);
			break;

		case EMERALD:
			toggleTimeCommand.day(player);
			break;

		case COAL:
			toggleTimeCommand.night(player);
			break;
			
		case APPLE:
			barCommand.Heal(player);
			break;
			
		case LAPIS_BLOCK:
			toggledownfallCommand.stopRain(player);
			break;
			
		default:
			break;
		}
		
			
	}
	public static void closeInv(Player player) {
		player.closeInventory();
	}

}
