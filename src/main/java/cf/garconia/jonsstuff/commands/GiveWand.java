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
			if (!(JonsStuff.getInstance().getConfig().getBoolean("Perms.GiveWand.enabled", true))) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.GiveWand", true)) {
					if (player.hasPermission("jonsstuff.command.givewand")) {
						player.getInventory().addItem(itemManager.createWand());
						
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixs.Normal") + " &eGiven Wand"));
						return true;
					} else if (!(player.hasPermission("jonsstuff.command.givewand"))) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixs.NoPermission") + " " + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + " " + "jonsstuff.command.givewand"));
						return true;
					}
				} else if (!(JonsStuff.getInstance().getConfig().getBoolean("Commands.GiveWand", true))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixs.Cmd-Disabled") + " " + JonsStuff.getInstance().getConfig().getString("Messages.GiveWand-Disabled")));
					return true;
				}
			}
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.GiveWand.enabled", true)) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.GiveWand", true)) {
					if (player.hasPermission((JonsStuff.getInstance().getConfig().getString("Perms.GiveWand.perm")))) {
						player.getInventory().addItem(itemManager.createWand());
						
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixs.Normal") + " &eGiven Wand"));
						return true;
					} else if (!(player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.GiveWand.perm")))) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixs.NoPermission") + " " + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + " " + JonsStuff.getInstance().getConfig().getString("Perms.GiveWand.perm")));
						return true;
					}
				} else if (!(JonsStuff.getInstance().getConfig().getBoolean("Commands.GiveWand", true))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixs.Cmd-Disabled") + " " + JonsStuff.getInstance().getConfig().getString("Messages.GiveWand-Disabled")));
					return true;
				}
			}
		}
		return true;
	}
}
