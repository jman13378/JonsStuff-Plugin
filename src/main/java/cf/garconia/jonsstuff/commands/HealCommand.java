package cf.garconia.jonsstuff.commands;

import org.bukkit.Bukkit;
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
			if (!(JonsStuff.getInstance().getConfig().getBoolean("Perms.Heal.enabled", true))) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Heal", true)) {
					if (player.hasPermission("jonsstuff.command.heal")) {	
						double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
						player.setHealth(maxHealth);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Normal") + " &eHealth Filled"));
						Bukkit.getLogger().info("healddd");
						
						return true;
					} else if (!(player.hasPermission("jonsstuff.command.heal"))) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.NoPermission") + " " + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + " " + "jonsstuff.command.heal"));
						Bukkit.getLogger().info("cus perm");
						return true;
						
					}
				} else if (!(JonsStuff.getInstance().getConfig().getBoolean("Commands.Heal", true))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Cmd-Disabled") + " " + JonsStuff.getInstance().getConfig().getString("Messages.Heal-Disabled")));
					Bukkit.getLogger().info("disabled");
					return true;
				}
			}
			if (JonsStuff.getInstance().getConfig().getBoolean("Perms.Heal.enabled", true)) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Heal", true)) {
					if (player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.Heal.perm"))) {
						double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
						player.setHealth(maxHealth);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Normal") + " &eHealth Filled"));
						Bukkit.getLogger().info("healed");
						
						return true;
					} else if (!(player.hasPermission(JonsStuff.getInstance().getConfig().getString("Perms.Heal.perm")))) {
						Bukkit.getLogger().info("no perm with custom perm");
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.NoPermission") + " " + JonsStuff.getInstance().getConfig().getString("Messages.NoPermission-Message") + "\n" + JonsStuff.getInstance().getConfig().getString("Messages.Permission-Tell") + " " + JonsStuff.getInstance().getConfig().getString("Perms.Heal.perm")));
						return true;
						
					}
				} else if (!(JonsStuff.getInstance().getConfig().getBoolean("Commands.Heal", true))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', JonsStuff.getInstance().getConfig().getString("Messages.Prefixes.Cmd-Disabled") + " " + JonsStuff.getInstance().getConfig().getString("Messages.Heal-Disabled")));
					Bukkit.getLogger().info("command is disabled");
					return true;
				}
			}
		}
		return true;
	}
}
