package xyz.sweepingloutus.masssay;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.logging.Logger;

public class MassSayCommand implements CommandExecutor {

    private Plugin main;

    public MassSayCommand(Plugin mainArg) {
        main = mainArg;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration config = main.getConfig();
        Logger logger = main.getLogger();
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            if (p.hasPermission("masssay.use")) {
                if (args.length == 0) {
                    p.sendMessage("Please add a message to say!");
                    return false;
                } else {
                    new MessageSender(args);
                    return true;
                }
            } else {
                p.sendMessage("Invalid Permission!");
                return true;
            }
        } else {
            if(config.getBoolean("console-use")){
                new MessageSender(args);
            }else{
                logger.info("Console use is disabled you can enable it in the config!");
            }
        }
        return true;
    }
}