package cf.garconia.jonsstuff.commands;

import org.bukkit.Bukkit;
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
			if (!(JonsStuff.getInstance().getConfig().getBoolean("Perms.FarmTime.enabled", true))) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Farmtime", true)) {
					if (player.hasPermission("jonsstuff.command.farmtime")) {
						if (args.length >= 2) {
							try {
								EntityType entity = EntityType.valueOf(args[0].toUpperCase());
								int amount = Integer.parseInt(args[1]);
								for (int i = 0; i < amount; i++) {
									player.getWorld().spawnEntity(player.getLocation(), entity);
								}
							} catch (IllegalArgumentException e) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Normal") + " &cThat Is Not A Valid Entity"));
							}
							
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Normal") + " &c/farmtime <mob> <amount>"));
							return true;
						}
					} else if (!(player.hasPermission("jonsstuff.command.farmtime"))) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.NoPermission") + " " + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + " " + "jonsstuff.command.farmtime"));

						return true;
						
					}
				} else if (!(JonsStuff.getInstance().getConfig().getBoolean("Commands.Farmtime", true))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Cmd-Disabled") + " " + JonsStuff.getInstance().getConfig().getString("Messages.FarmTime-Disabled")));

					return true;
				}
			}
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FarmTime.enabled", true)) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Farmtime", true)) {
					if (player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.FarmTime.perm"))) {
						if (args.length >= 2) {
							try {
								EntityType entity = EntityType.valueOf(args[0].toUpperCase());
								int amount = Integer.parseInt(args[1]);
								for (int i = 0; i < amount; i++) {
									player.getWorld().spawnEntity(player.getLocation(), entity);
								}
							} catch (IllegalArgumentException e) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Normal") + " &cThat Is Not A Valid Entity"));
							}
							
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Normal") + " &c/farmtime <mob> <amount>"));
							return true;
						}
					} else if (!(player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.FarmTime.perm")))) {

						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.NoPermission") + " " + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + " " + JonsStuff.getInstance().getConfig().getString("Perms.FarmTime.perm")));
						return true;
					}
				} else if (!(JonsStuff.getInstance().getConfig().getBoolean("Commands.Farmtime", true))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Cmd-Disabled") + " " + JonsStuff.getInstance().getConfig().getString("Messages.FarmTime-Disabled")));
					return true;
			}
			}
		}
	return true;
	}
}


