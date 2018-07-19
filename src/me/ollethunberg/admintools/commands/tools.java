package me.ollethunberg.admintools.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class tools {
	
	public static ItemStack book() {
		ItemStack book = new ItemStack(Material.BOOK, 1);
		ItemMeta itemMeta = book.getItemMeta();
		String z = "BOOK OF TOOLS";
		itemMeta.setDisplayName(z);
		itemMeta.setLore(Arrays.asList("This book is very important. Don't loose it."));
		book.setItemMeta(itemMeta);
		return book;
	}
}
