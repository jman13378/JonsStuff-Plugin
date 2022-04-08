package cf.garconia.jonsstuff.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import cf.garconia.jonsstuff.JonsStuff;

public class Reload implements CommandExecutor {
	FileConfiguration config = JonsStuff.getInstance().getConfig();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (!(sender instanceof Player)) {
			JonsStuff.getInstance().getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Reloading");
			JonsStuff.getInstance().reloadConfig();
			JonsStuff.getInstance().getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "Reload Complete!" );
		}
		else if (cmd.getName().equalsIgnoreCase("rld")) {
			if (player.hasPermission("jonsstuff.reload")) {
				player.sendMessage(ChatColor.GREEN + "Reloading");
				JonsStuff.getInstance().reloadConfig();
				player.sendMessage(ChatColor.DARK_GREEN + "Reload Complete!");
				JonsStuff.getInstance().getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "Reload Completed by " + player.getName());
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cMissing Permission"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cPermission: jonsstuff.reload"));
			}
		}
		return true;
	}
}
