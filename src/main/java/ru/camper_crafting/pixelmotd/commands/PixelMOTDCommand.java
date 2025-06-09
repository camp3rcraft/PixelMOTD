package ru.camper_crafting.pixelmotd.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.forestcore.utils.ColorUtils;
import ru.camper_crafting.pixelmotd.PixelMOTD;

public class PixelMOTDCommand implements CommandExecutor {
    private final PixelMOTD plugin;

    public PixelMOTDCommand(PixelMOTD plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ColorUtils.colorize("&#F2C6DEP&#EFC7E0i&#ECC8E3x&#E9C9E5e&#E7CAE7l&#E4CAE9M&#E1CBECO&#DECCEET&#DBCDF0D &7- Plugin for configuring MOTD server."));
            sender.sendMessage(ColorUtils.colorize("&7Use &f&n/pixelmotd reload &7to reload the configuration"));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("pixelmotd.reload")) {
                sender.sendMessage(ColorUtils.colorize("&#FF0000You do not have permission to use this command!"));
                return true;
            }

            plugin.reloadConfig();
            plugin.loadConfig();
            sender.sendMessage(ColorUtils.colorize("&#00FF00Configuration successfully reloaded!"));
            return true;
        }

        sender.sendMessage(ColorUtils.colorize("&#FF0000Unknown command! &fUse &f&n/pixelmotd &7for help."));
        return true;
    }
} 