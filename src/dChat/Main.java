package dChat;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dChat.cmds.ChatCmd;

public class Main extends JavaPlugin {
	
	public static Main inst;
	 
	public void onEnable() {
		inst = this;
		System.out.println("Uruchamianie...");
		
		registerCommands();
		registerEvents();
	}
	public void onDisable() {
		System.out.println("Wylaczanie...");
	}
	
	private void registerCommands() {
		getCommand("chat").setExecutor(new ChatCmd());
	}
	
	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new ChatCmd(), this);
	}
	
	public static Main getInst() {
		return inst;
	}

}
