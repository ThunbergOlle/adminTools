package me.ollethunberg.admintools.commands;

import org.bukkit.entity.Player;

import me.ollethunberg.admintools.utils.utils;

public class barCommand {

	public static void Heal (Player player) {
		if(player.hasPermission("admintools.gui")) {
			player.setHealth(20);
			player.setFoodLevel(20);
		}
	}
}
