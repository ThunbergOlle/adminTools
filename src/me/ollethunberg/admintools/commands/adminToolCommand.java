package me.ollethunberg.admintools.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ollethunberg.admintools.Main;
import me.ollethunberg.admintools.utils.utils;
import me.ollethunberg.admintools.ui.ui;

public class adminToolCommand implements CommandExecutor{
	
	// BASIC SETUP
	private Main plugin;
	public adminToolCommand(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("tools").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(utils.chat("&cNo No No, You can only call this function from the client."));
			return true;
		}
		
		//Setup variabel for the player
		Player player = (Player) sender;
		if(player.hasPermission("admintools.gui")) {
			player.openInventory(ui.GUI(player));
		}
		return false;
	}
	
}
