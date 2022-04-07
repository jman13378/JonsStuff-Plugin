package cf.garconia.jonsstuff.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import cf.garconia.jonsstuff.JonsStuff;
import cf.garconia.jonsstuff.items.itemManager;

public class Commands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only Players Can execute This Command");
			return true;
		}
		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("heal")) {
			if (player.hasPermission("jonsstuff.command.heal")) {
				double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
				player.setHealth(maxHealth);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &eHealth Filled"));
				return true;
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cMissing Permission"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cPermission: jonsstuff.command.heal"));
			}
		} else if (cmd.getName().equalsIgnoreCase("feed")) {
			if (player.hasPermission("jonsstuff.command.feed")) {
				player.setFoodLevel(20);
			}
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &eHunder Filled"));
		} else if (cmd.getName().equalsIgnoreCase("farmtime")) {
			if (player.hasPermission("jonsstuff.command.farmtime")) {
				if (args.length >= 2) {
					try {
						EntityType entity = EntityType.valueOf(args[0].toUpperCase());
						int amount = Integer.parseInt(args[1]);
						for (int i = 0; i < amount; i++) {
							player.getWorld().spawnEntity(player.getLocation(), entity);
						}
					} catch (IllegalArgumentException e) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cThat Is Not A Valid Entity"));
					
					}
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &c/farmtime <mob> <amount>"));
			}
		} else if (cmd.getName().equalsIgnoreCase("givewand")) {
			if (player.hasPermission("jonsstuff.command.givewand")) {
				player.getInventory().addItem(itemManager.createWand());
			
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &eGiven Wand"));
		} else if (cmd.getName().equalsIgnoreCase("rld")) {
			if (player.hasPermission("jonsstuff.command.reload")) {
				player.sendMessage(ChatColor.GREEN + "Reloading");
				player.sendMessage(ChatColor.GREEN + "Reloading.");
				player.sendMessage(ChatColor.GREEN + "Reloading..");
				player.sendMessage(ChatColor.GREEN + "Reloading...");
				JonsStuff.getInstance().reloadConfig();
				player.sendMessage(ChatColor.DARK_GREEN + "Reload Complete!");
			}
		}
		return true;
			}
		}
	}
}
