package me.ollethunberg.admintools.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ollethunberg.admintools.Main;
import me.ollethunberg.admintools.commands.bookCommand;
import me.ollethunberg.admintools.ui.ui;
import me.ollethunberg.admintools.utils.utils;

public class inventoryClickListener implements Listener{
	
	private Main plugin;
	public inventoryClickListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
	}
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		String title = e.getInventory().getTitle();
		if(title.equals(ui.inventory_name)) {
			e.setCancelled(true); //MAKE SURE WE CANT PICKUP THE ITEM FROM THE INVENTORY;
			if(e.getCurrentItem() == null) {
				return;
			}
			if(title.equals(ui.inventory_name)) {
				ui.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
			}
		}
	}
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(player != null && player.getItemInHand().getItemMeta() != null) {
			if(player.getItemInHand().getItemMeta().hasLore() == true) {
				if(player.hasPermission("admintools.gui")) {
					player.openInventory(ui.GUI(player));
				}
			} else {
				return;
			}	
		}

			
	}
}
