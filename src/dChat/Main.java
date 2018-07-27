package dChat;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main inst;
	 
	public void onEnable() {
		inst = this;
		System.out.println("Uruchamianie...");
		
		registerCommands();
		registerEvents();
		registerConfig();
	}
	public void onDisable() {
		System.out.println("Wylaczanie...");
	}
	
	private void registerCommands() {

	}
	
	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
	}
	
	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public static Main getInst() {
		return inst;
	}

}
