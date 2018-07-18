package me.ollethunberg.admintools.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class utils {
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public static ItemStack createItem(Inventory inv, int materialId, int amount, int invSlot, String displayName, String... loreString) {
		ItemStack item;
		
		List<String> lore = new ArrayList<String>();
		
		item = new ItemStack(materialId, amount);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(utils.chat(displayName));
		
		for(String s : loreString) {
			lore.add(utils.chat(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(invSlot -1, item);
		return item;
	}
	public static ItemStack createItemByte(Inventory inv, int materialId, int byteId, int amount, int invSlot, String displayName, String... loreString) {
		ItemStack item;
		
		List<String> lore = new ArrayList();
		
		item = new ItemStack(materialId, amount, (short) byteId);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(utils.chat(displayName));
		
		for(String s : loreString) {
			lore.add(utils.chat(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(invSlot -1, item);
		return item;
	}
}
