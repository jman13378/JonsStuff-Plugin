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
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FarmTimeEnabled", false)) {
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
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + " &cThat Is Not A Valid Entity"));
						}

					} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + " &c/farmtime <mob> <amount>"));
			
				}
				}
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.FarmTimeDisabled")));

			} else {
				if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FarmTimeEnabled", false)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell" + "jonsstuff.command.farmtime")));
				}
				if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FarmTimeEnabled", true)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + JonsStuff.getInstance().getConfig().getString("Perms.FarmTimeEnabled.perm")));
				}
			}
			if (player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.FarmTimeEnabled.perm"))) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Farmtime", true)) {
				if (args.length >= 2) {
					try {
						EntityType entity = EntityType.valueOf(args[0].toUpperCase());
						int amount = Integer.parseInt(args[1]);
						for (int i = 0; i < amount; i++) {
							player.getWorld().spawnEntity(player.getLocation(), entity);
						}
					} catch (IllegalArgumentException e) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + " &cThat Is Not A Valid Entity"));
					}

				} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + " &c/farmtime <mob> <amount>"));
		
			}
			}
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.FarmTime-Disabled")));

		} else {
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FarmTimeEnabled", false)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell" + "jonsstuff.command.farmtime")));
			}
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FarmTimeEnabled", true)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + JonsStuff.getInstance().getConfig().getString("Perms.FarmTimeEnabled.perm")));
			}
		}
			}
		}
		return true;
	}
}

