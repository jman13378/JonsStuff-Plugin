package cf.garconia.jonsstuff.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import cf.garconia.jonsstuff.JonsStuff;

public class FarmTime implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only Players Can execute This Command");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("farmtime")) {
			if (player.hasPermission("jonsstuff.command.farmtime")) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Farmtime", true)) {
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
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &cSorry But this command has been disabled"));

				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &c/farmtime <mob> <amount>"));
			
				}
				}
		} else {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cMissing Permission"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cPermission: jonsstuff.command.farmtime"));
		}
		}
		return true;
	}
}
