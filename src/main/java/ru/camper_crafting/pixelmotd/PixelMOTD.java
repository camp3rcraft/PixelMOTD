package ru.camper_crafting.pixelmotd;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.forestcore.ForestCore;
import ru.forestcore.models.ForestPlugin;
import ru.forestcore.utils.ColorUtils;
import ru.camper_crafting.pixelmotd.commands.PixelMOTDCommand;

import java.util.Arrays;

public class PixelMOTD extends JavaPlugin implements Listener {
    private static final String MIN_FORESTCORE_VERSION = "1.0-SNAPSHOT";
    private boolean customMotdEnabled;
    private boolean fakeMaxPlayersEnabled;
    private String motdLine1;
    private String motdLine2;
    private int fakeMaxPlayers;
    private ForestCore forestCore;

    @Override
    public void onEnable() {
        // Check ForestCore version
        if (!checkForestCoreVersion()) {
            getLogger().severe(ColorUtils.colorize("&#FF0000Requires ForestCore version " + MIN_FORESTCORE_VERSION + " or higher!"));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Save default config if it doesn't exist
        saveDefaultConfig();
        
        // Load configuration
        loadConfig();
        
        // Register events
        getServer().getPluginManager().registerEvents(this, this);
        
        // Register command
        getCommand("pixelmotd").setExecutor(new PixelMOTDCommand(this));
        
        // Register plugin in ForestCore
        registerForestCorePlugin();
        
        // Log plugin enable
        getLogger().info(ColorUtils.colorize("&#00FF00PixelMOTD has been enabled!"));
    }

    @Override
    public void onDisable() {
        getLogger().info(ColorUtils.colorize("&#FF0000PixelMOTD has been disabled!"));
    }

    private boolean checkForestCoreVersion() {
        Plugin forestCorePlugin = Bukkit.getPluginManager().getPlugin("ForestCore");
        if (forestCorePlugin == null) {
            getLogger().severe(ColorUtils.colorize("&#FF0000ForestCore not found!"));
            return false;
        }

        String version = forestCorePlugin.getDescription().getVersion();
        return compareVersions(version, MIN_FORESTCORE_VERSION) >= 0;
    }

    private int compareVersions(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i].replace("-SNAPSHOT", "")) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i].replace("-SNAPSHOT", "")) : 0;
            
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        
        // Если версии одинаковые, но одна из них SNAPSHOT, то SNAPSHOT считается новее
        if (version1.contains("-SNAPSHOT") && !version2.contains("-SNAPSHOT")) return 1;
        if (!version1.contains("-SNAPSHOT") && version2.contains("-SNAPSHOT")) return -1;
        
        return 0;
    }

    private void registerForestCorePlugin() {
        forestCore = (ForestCore) Bukkit.getPluginManager().getPlugin("ForestCore");
        if (forestCore != null) {
            ForestPlugin forestPlugin = new ForestPlugin(
                "PixelMOTD",                    // Plugin name
                getDescription().getVersion(),  // Version
                "pixelmotd",                    // Plugin ID
                "camper_crafting",              // Author
                "https://modrinth.com/plugin/pixel-motd", // Modrinth link
                "https://github.com/camp3rcraft/PixelMOTD", // GitHub link
                Arrays.asList(                  // Commands list
                    "/pixelmotd reload - Reload plugin configuration"
                )
            );
            forestCore.getPluginManager().registerPlugin("pixelmotd", forestPlugin);
        }
    }

    public void loadConfig() {
        reloadConfig();
        
        // Load feature toggles
        customMotdEnabled = getConfig().getBoolean("features.custom-motd", true);
        fakeMaxPlayersEnabled = getConfig().getBoolean("features.fake-max-players", true);
        
        // Load MOTD lines
        motdLine1 = getConfig().getString("motd.line1", 
            "&#F2C6DEp&#EFC7E0i&#ECC8E3x&#E9C9E5e&#E7CAE7l&#E4CAE9M&#E1CBECO&#DECCEET&#DBCDF0D" +
            "&7| &#5CFAF3Y&#5DEAF4o&#5DDBF5u &#5FBCF6c&#5FACF7a&#609CF8n &#617DF9c&#626DFAo&#625EFBn&#634EFBi&#643FFCg&#642FFDu&#651FFEr&#6510FEr&#6600FFe");
        motdLine2 = getConfig().getString("motd.line2", 
            "&#5CFAF3M&#5DEBF4O&#5DDDF4T&#5ECEF5D &#5FB0F7i&#60A2F7n &#6184F9c&#6176F9o&#6267FAn&#6258FBf&#634AFBi&#643BFCg&#642CFD.&#651DFEy&#650FFEm&#6600FFl");
        
        // Load fake max players
        fakeMaxPlayers = getConfig().getInt("fake-max-players.max-players", 77);
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        if (customMotdEnabled) {
            String motd = ColorUtils.colorize(motdLine1 + "\n" + motdLine2);
            event.setMotd(motd);
        }
        
        if (fakeMaxPlayersEnabled) {
            event.setMaxPlayers(fakeMaxPlayers);
        }
    }
} 