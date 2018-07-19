package me.ollethunberg.admintools.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ollethunberg.admintools.Main;

public class itemBookCommand implements CommandExecutor{
	private Main plugin;
	public itemBookCommand (Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("gettools").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return true;
		} 
		Player player = ((Player) sender).getPlayer();
		
		player.getInventory().addItem(tools.book());
		return false;
	}
	
}
