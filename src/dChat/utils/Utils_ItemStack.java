package dChat.utils;

import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

public class Utils_ItemStack {
	
	public static Wool createWool(int amount, String name, List<String> lore, DyeColor color) {
		Wool wool = new Wool(color);
		wool.toItemStack().setAmount(amount);
		ItemMeta im = wool.toItemStack().getItemMeta();
		im.setDisplayName(name);
		im.setLore(lore);
		wool.toItemStack().setItemMeta(im);
		return wool;
	}
	public static ItemStack createBlankIS(short data) {
		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, data);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(" ");
		i.setItemMeta(im);
		return i;
	}

}
