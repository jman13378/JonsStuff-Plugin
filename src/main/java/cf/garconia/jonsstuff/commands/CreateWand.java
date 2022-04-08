package cf.garconia.jonsstuff.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cf.garconia.jonsstuff.JonsStuff;
import cf.garconia.jonsstuff.items.itemManager;

public class CreateWand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only Players Can execute This Command");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("givewand")) {
			if (player.hasPermission("jonsstuff.command.givewand")) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Givewand", true)) {
					player.getInventory().addItem(itemManager.createWand());
			
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &eGiven Wand"));
				}
				} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cMissing Permission"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cPermission: jonsstuff.command.givewand"));
				}
		}
		return true;
	}
}
