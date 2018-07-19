package me.ollethunberg.admintools.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class toggleTimeCommand{
	public static void day(Player player) {
		if(player.hasPermission("admintools.gui")) {
			World world = Bukkit.getServer().getWorld("world");
			world.setTime(0);
		}
	}
	public static void night(Player player) {
		if(player.hasPermission("admintools.gui")) {
			World world = Bukkit.getServer().getWorld("world");
			world.setTime(14000);
		}
	}
	
}
