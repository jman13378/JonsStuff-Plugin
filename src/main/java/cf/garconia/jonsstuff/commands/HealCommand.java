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
			if (player.hasPermission("jonsstuff.command.heal")) {
				if (JonsStuff.getInstance().getConfig().getBoolean("Commands.Heal", true)) {
					double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
					player.setHealth(maxHealth);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &eHealth Filled"));
					return true;
				}
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l(!) &cSorry But this command has been disabled"));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cMissing Permission"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!) &cPermission: jonsstuff.command.heal"));
			}
		}
		return true;
	}
}