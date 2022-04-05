package cf.garconia.jonsstuff;

import java.net.http.WebSocket.Listener;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import cf.garconia.jonsstuff.commands.Commands;
import cf.garconia.jonsstuff.events.Events;
import cf.garconia.jonsstuff.items.itemManager;

public class Main extends JavaPlugin implements Listener, org.bukkit.event.Listener {
	FileConfiguration config = getConfig();

	@Override
	public void onEnable() {
		Commands commands = new Commands();
		getServer().getPluginManager().registerEvents(new Events(), this);
		itemManager.init();
		config.addDefault("heal", true);
		config.addDefault("feed", true);
		config.addDefault("farmtime", true);
		config.addDefault("givewand", true);
        config.options().copyDefaults(true);
		if (config.getBoolean("heal")) {
			getCommand("heal").setExecutor(commands);
		}
		if (config.getBoolean("feed")) {
			getCommand("feed").setExecutor(commands);
		}
		if (config.getBoolean("farmtime")) {
			getCommand("heal").setExecutor(commands);
		}
		if (config.getBoolean("givewand")) {
			getCommand("givewand").setExecutor(commands);
		} 
		getCommand("RLD").setExecutor(commands);
        saveConfig();
     // Enable our class to check for new players using onPlayerJoin()
        getServer().getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Jons-Stuff] Plugin Is Enabled!");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Jons-Stuff] Plugin Is Disabled!");
	}
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (config.getBoolean("youAreAwesome")) {
            player.sendMessage("You are awesome!");
            
            getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[Jons-Stuff] Awsome!");
        } else {
            player.sendMessage("You are not awesome...");
        }
      
    }
    public void onReload(CommandSender player) {
		player.sendMessage("Reloading");
		player.sendMessage("Reloading.");
		player.sendMessage("Reloading..");
		player.sendMessage("Reloading...");
    	reloadConfig();
    	player.sendMessage("Reload Complete!");
    }
}
