package dChat.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dChat.utils.Utils;

public class ChatCmd implements CommandExecutor, Listener {
	
	public boolean chat;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("chat")) {
			if(!(sender instanceof Player)) sender.sendMessage(Utils.prefix + " " + Utils.tylko_gracz);
			else {
				Player p = (Player)sender;
				if(args.length == 0) p.sendMessage(Utils.prefix + " " + Utils.chat_uzycie);
				else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("on")) {
						if(p.hasPermission("dchat.*") || p.hasPermission("dchat.on")) {
							chat = true;
							Bukkit.broadcastMessage(Utils.prefix + " " + Utils.chat_wlaczono + p.getName());
						}
						else p.sendMessage(Utils.prefix + " " + Utils.brak_perm);
					}
					else if(args[0].equalsIgnoreCase("off")) {
						if(p.hasPermission("dchat.*") || p.hasPermission("dchat.off")) {
							chat = false;
							Bukkit.broadcastMessage(Utils.prefix + " " + Utils.chat_wylaczono + p.getName());
						}
						else p.sendMessage(Utils.prefix + " " + Utils.brak_perm);
					}
					else if(args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("clear")) {
						if(p.hasPermission("dchat.*") || p.hasPermission("dchat.clear")) {
							for(int i = 0; i < 150; i++) Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(Utils.prefix + " " + Utils.chat_wyczyszczono + p.getName());
						}
						else p.sendMessage(Utils.prefix + " " + Utils.brak_perm);
					}
					else p.sendMessage(Utils.prefix + " " + Utils.chat_uzycie);
				}
				else {
					p.sendMessage(Utils.prefix + " " + Utils.chat_uzycie);
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(chat == false) {
			if(!p.hasPermission("dchat.bypass")) {
				p.sendMessage(Utils.prefix + " " + Utils.chat_wylaczony);
				e.setCancelled(true);
			}
		}
	}

}
