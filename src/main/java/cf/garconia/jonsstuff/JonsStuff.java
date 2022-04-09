package cf.garconia.jonsstuff;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import cf.garconia.jonsstuff.commands.FarmTime;
import cf.garconia.jonsstuff.commands.FeedCommand;
import cf.garconia.jonsstuff.commands.GiveWand;
import cf.garconia.jonsstuff.commands.HealCommand;
import cf.garconia.jonsstuff.commands.Reload;
import cf.garconia.jonsstuff.events.Events;

public class JonsStuff extends JavaPlugin implements Listener {

	private static JonsStuff instance;
	private File customConfigFile;
    private FileConfiguration customConfig;

	@Override
	public void onLoad() {
		instance = this;
	}

	@Override
	public void onEnable() {
		createCustomConfig();
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new Events(), this);
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("rld").setExecutor(new Reload());
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("givewand").setExecutor(new GiveWand());
		getCommand("farmtime").setExecutor(new FarmTime());
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Jons-Stuff] Plugin Is Enabled!");
	}
	public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

	private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "Logs/Feed.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("Logs/Feed.yml", false);
         }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
	}
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Jons-Stuff] Plugin Is Disabled!");
	}

	public static JonsStuff getInstance() {
		return instance;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		if (getConfig().getBoolean("youAreAwesome")) {
			player.sendMessage("You are awesome!");

			getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[Jons-Stuff] Awsome!");
		} else {
			player.sendMessage("You are not awesome...");
		}
		
	}
}
