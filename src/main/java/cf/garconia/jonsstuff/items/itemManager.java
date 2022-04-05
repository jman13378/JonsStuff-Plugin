package cf.garconia.jonsstuff.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class itemManager {
	
	public static ItemStack wand;
	
	public static void init() {
		createWand();
		
	}
	
	private static void createWand() {
		ItemStack item = new ItemStack(Material.STICK, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Stick Of Truth");
		List<String> lore = new ArrayList<String>();
		lore.add("§e§l(!) §7This Powerful artifact is a relic of");
		lore.add("§7Minecraft's ancient history!");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.KNOCKBACK, 10, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		wand = item;
	}

}
