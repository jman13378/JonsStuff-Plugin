package cf.garconia.jonsstuff.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import cf.garconia.jonsstuff.items.itemManager;

public class Commands implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) { 
			sender.sendMessage(ChatColor.RED + "Only Players Can execute This Command");
			return true; 
		}
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("heal")) {
			double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
			player.setHealth(maxHealth);
			player.sendMessage("§e§l(!) §eHealth Filled");
		}
		else if (cmd.getName().equalsIgnoreCase("feed")) {
			player.setFoodLevel(20);
			player.sendMessage("§e§l(!) §eHunder Filled");
		}
		else if (cmd.getName().equalsIgnoreCase("farmtime")) {
			if (args.length >= 2) {
				try {
					EntityType entity = EntityType.valueOf(args[0].toUpperCase());
					int amount = Integer.parseInt(args[1]);
					for (int i = 0; i < amount; i++) {
						player.getWorld().spawnEntity(player.getLocation(), entity);
					}
				} catch (IllegalArgumentException e) {
					player.sendMessage("§c§l(!) §cThat Is Not A Valid Entity");
				
				}
			} else {
				player.sendMessage("§c§l(!) §c/farmtime <mob> <amount>");
			}
		}
		else if (cmd.getName().equalsIgnoreCase("givewand")) {
			player.getInventory().addItem(itemManager.wand);
			player.sendMessage("§e§l(!) §eGiven Wand");
		}
		return true;
	}
}
