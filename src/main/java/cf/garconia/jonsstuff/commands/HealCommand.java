package cf.garconia.jonsstuff.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cf.garconia.jonsstuff.JonsStuff;

public class HealCommand implements CommandExecutor {


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only Players Can execute This Command");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("heal")) {
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.Heal.enabled", false)) {
				if (player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.Heal.perm")) {
					if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Heal", true)) {
						double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
						player.setHealth(maxHealth);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + " &eHealth Filled"));
						
						
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.Heal-Disabled")));
					}
				} else {
					if (!JonsStuff.getInstance().getConfig().getBoolean("Perms.Heal.enabled")) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell" + "jonsstuff.command.heal")));
					}
					else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + JonsStuff.getInstance().getConfig().getString("Perms.HealEnabled.perm")));
					}
				}
			}
			if (player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.Heal.enabled"))) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Heal", true)) {
				double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
				player.setHealth(maxHealth);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + " &eHealth Filled"));
				
				
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.Heal-Disabled")));
			}
		} else {
			if (!JonsStuff.getInstance().getConfig().getBoolean("Perms.Heal.enabled")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell" + "jonsstuff.command.heal")));
			}
			else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefix") + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + JonsStuff.getInstance().getConfig().getString("Perms.HealEnabled.perm")));
				
			}
		}
		}
		return true;
	}
}
