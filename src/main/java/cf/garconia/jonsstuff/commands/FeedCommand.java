package cf.garconia.jonsstuff.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cf.garconia.jonsstuff.JonsStuff;

public class FeedCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only Players Can execute This Command");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("feed")) {
			if (!(JonsStuff.getInstance().getConfig().getBoolean("Perms.Feed.enabled", true))) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Feed", true)) {
					if (player.hasPermission("jonsstuff.command.feed")) {
						player.setFoodLevel(20);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Normal") + " &eHunder Filled"));
						return true;
					} else if (!(player.hasPermission("jonsstuff.command.feed"))) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.NoPermission") + " " + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + " " + "jonsstuff.command.feed"));
						Bukkit.getLogger().info("cus perm");
						return true;
					
					}
				} else if (!(JonsStuff.getInstance().getConfig().getBoolean("Commands.Feed", true))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Cmd-Disabled") + " " + JonsStuff.getInstance().getConfig().getString("Messages.Feed-Disabled")));
					Bukkit.getLogger().info("disabled");
					return true;
				}
			}
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.Feed.enabled", true)) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Feed", true)) {
					if (player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.Feed.perm"))) {
						player.setFoodLevel(20);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Normal") + " &eHunder Filled"));
						return true;
						
					} else if (!(player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.Feed.perm")))) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.NoPermission") + " " + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + " " + JonsStuff.getInstance().getConfig().getString("Perms.Feed.perm")));
						Bukkit.getLogger().info("cus perm");
						return true;
					}
					
				} else if (!(JonsStuff.getInstance().getConfig().getBoolean("Commands.Feed", true))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Cmd-Disabled") + " " + JonsStuff.getInstance().getConfig().getString("Messages.Feed-Disabled")));
					Bukkit.getLogger().info("disabled");
					return true;
				}
			}
		}
		return true;
	}
}
