package me.ollethunberg.admintools.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ollethunberg.admintools.Main;
import me.ollethunberg.admintools.utils.utils;

public class flyCommand implements CommandExecutor{

		private Main plugin;
		public flyCommand(Main plugin) {
			this.plugin = plugin;
			
			plugin.getCommand("fly").setExecutor(this);
		}
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			// TODO Auto-generated method stub
			if(!(sender instanceof Player)) {
				sender.sendMessage(utils.chat("No No No, You can only call this function from the client."));
				return true;
			}
			
			Player player = (Player) sender;
			if(player.hasPermission("admintools.gui")) {
				if(player.isFlying()) {
					player.setAllowFlight(false);
					player.setFlying(false);
					player.sendMessage(utils.chat("Flying is now disabled."));
					return true;
				}else {
					player.setAllowFlight(true);
					player.setFlying(true);
					player.sendMessage(utils.chat("Flying is now enabled."));
				}
			}
			return false;
		}
		public static void fly(Player player) {
			if(player.hasPermission("admintools.gui")) {
				if(player.isFlying()) {
					player.setAllowFlight(false);
					player.setFlying(false);
					player.sendMessage(utils.chat("&8[&c*&8] &7Oh no! You have &cdisabled &7fly!"));
				}else {
					player.setAllowFlight(true);
					player.setFlying(true);
					player.sendMessage(utils.chat("&8[&a*&8] &7You have &aenabled &7fly, put on a helmet!"));
				}
			}
		}
}
