package me.ollethunberg.admintools;

import org.bukkit.plugin.java.JavaPlugin;

import me.ollethunberg.admintools.commands.adminToolCommand;
import me.ollethunberg.admintools.commands.itemBookCommand;
import me.ollethunberg.admintools.listener.inventoryClickListener;
import me.ollethunberg.admintools.listener.openListener;
import me.ollethunberg.admintools.ui.ui;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		new adminToolCommand(this);
		new inventoryClickListener(this);
		new openListener(this);
		new itemBookCommand(this);
		ui.initialize();
		System.out.println("Starting Admintools");
		
	}
	public void onDisable() {
		System.out.println("Stopping Admintools");
	}
}
