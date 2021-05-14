package xyz.sweepingloutus.masssay;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

public class MessageSender {
    public MessageSender(String[] args) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.hasPermission("masssay.exempt")) {
                if(!isVanished(player)){
                    String message = String.join(" ", args[1]);
                    player.chat(message);
                }

            }
        }
    }

    private boolean isVanished(Player player) {
        for (MetadataValue meta : player.getMetadata("vanished")) {
            if (meta.asBoolean()) return true;
        }
        return false;
    }
}
