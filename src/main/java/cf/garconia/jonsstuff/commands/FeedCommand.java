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
			if (player.hasPermission("jonsstuff.command.feed")) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Feed", true)) {
					player.setFoodLevel(20);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &eHunder Filled"));
				}
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &cSorry But this command has been disabled"));
			
		} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cMissing Permission"));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cPermission: jonsstuff.command.feed"));
		}
		}
	return true;
	}
}