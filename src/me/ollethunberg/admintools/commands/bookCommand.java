package me.ollethunberg.admintools.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ollethunberg.admintools.Main;
import me.ollethunberg.admintools.utils.utils;

public class bookCommand implements CommandExecutor{
	private Main plugin;
	public bookCommand(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("adminbook").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player)) {
			sender.sendMessage(utils.chat("You can't access this command."));
			return true;
		}
		
		Player player = (Player) sender;
		
		if(player.hasPermission("admintools.gui")) {
			giveItem(player);
		}
		return false;
	}
	public static void giveItem(Player player) {
		ItemStack itemStack = new ItemStack(Material.BOOK);
		ItemMeta meta = itemStack.getItemMeta();

		meta.setDisplayName(utils.chat("&3Admin book"));
		meta.setLore(Arrays.asList("I would say that this is important."));
        itemStack.setItemMeta(meta);
		player.getInventory().addItem(itemStack);
    }
	public static ItemMeta meta() {
		ItemStack itemStack = new ItemStack(Material.BOOK);
		ItemMeta meta = itemStack.getItemMeta();

		meta.setDisplayName(utils.chat("&3Admin book"));
		meta.setLore(Arrays.asList("I would say that this is important."));
        itemStack.setItemMeta(meta);
        return meta;
	}
	
}
