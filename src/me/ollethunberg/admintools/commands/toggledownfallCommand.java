package me.ollethunberg.admintools.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class toggledownfallCommand extends JavaPlugin{
	public static void stopRain(Player player) {
		if(player.hasPermission("admintools.gui")) {
			Bukkit.dispatchCommand(player, "toggledownfall");
		}
	}
}
