package cf.garconia.jonsstuff.commands;

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
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FeedEnabled", false)) {
				if (player.hasPermission("jonsstuff.command.feed")) {
					if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Feed", true)) {
						player.setFoodLevel(20);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + " &eHunder Filled"));
					}
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.FeedDisabled")));
			} else {
				if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FeedEnabled", false)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell" + "jonsstuff.command.feed")));
				}
				if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FeedEnabled", true)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + JonsStuff.getInstance().getConfig().getString("Perms.FeedEnabled.perm")));
				}
		}
		}
			if (player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.FeedEnabled.perm"))) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Feed", true)) {
				player.setFoodLevel(20);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + " &eHunder Filled"));
			}
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.Feed-Disabled")));
	} else {
		if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FeedEnabled", false)) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell" + "jonsstuff.command.feed")));
		}
		if (JonsStuff.getInstance().getConfig().getBoolean("Perms.FeedEnabled", true)) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + JonsStuff.getInstance().getConfig().getString("Perms.FeedEnabled.perm")));
		}
	}
		}
	return true;
	}
}