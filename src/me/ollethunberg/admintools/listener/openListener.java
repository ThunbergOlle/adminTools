package me.ollethunberg.admintools.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ollethunberg.admintools.Main;
import me.ollethunberg.admintools.commands.tools;
import me.ollethunberg.admintools.ui.ui;
import me.ollethunberg.admintools.utils.utils;

public class openListener implements Listener{
	private Main plugin;
	public openListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
	}
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(event.getPlayer().getInventory().getItemInHand().equals(tools.book())){
			player.sendMessage(utils.chat("&5Opened the magic book."));
			player.openInventory(ui.GUI(player));
		}
	}
}
