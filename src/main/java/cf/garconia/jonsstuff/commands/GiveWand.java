package cf.garconia.jonsstuff.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cf.garconia.jonsstuff.JonsStuff;
import cf.garconia.jonsstuff.items.itemManager;

public class GiveWand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only Players Can execute This Command");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("givewand")) {
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.GiveWandEnabled", false)) {
			if (player.hasPermission("jonsstuff.command.givewand")) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Givewand", true)) {
					player.getInventory().addItem(itemManager.createWand());
			
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + "&eGiven Wand"));
				}
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.GiveWandDisabled")));

			} else {
				if (JonsStuff.getInstance().getConfig().getBoolean("Perms.GiveWandEnabled", false)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell" + "jonsstuff.command.givewand")));
				}
				if (JonsStuff.getInstance().getConfig().getBoolean("Perms.GiveWandEnabled", true)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + JonsStuff.getInstance().getConfig().getString("Perms.GiveWandEnabled.perm")));
				}
			}
			if (player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.GiveWandEnabled.perm"))) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Givewand", true)) {
					player.getInventory().addItem(itemManager.createWand());
			
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + "&eGiven Wand"));
				}
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.GiveWandDisabled")));

			} else {
				if (JonsStuff.getInstance().getConfig().getBoolean("Perms.GiveWandEnabled", false)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell" + "jonsstuff.command.givewand")));
				}
				if (JonsStuff.getInstance().getConfig().getBoolean("Perms.GiveWandEnabled", true)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + JonsStuff.getInstance().getConfig().getString("Perms.GiveWandEnabled.perm")));
				}
			}
			}
		}
		return true;
	}
}
