package me.ollethunberg.admintools;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.command.CommandExecutor;
import me.ollethunberg.admintools.listener.inventoryClickListener;
import me.ollethunberg.admintools.commands.adminToolCommand;
import me.ollethunberg.admintools.commands.toggleTimeCommand;
import me.ollethunberg.admintools.ui.ui;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		new adminToolCommand(this);
		new inventoryClickListener(this);
		ui.initialize();
		System.out.println("Starting Admintools");
		
	}
	public void onDisable() {
		System.out.println("Stopping Admintools");
	}
}
