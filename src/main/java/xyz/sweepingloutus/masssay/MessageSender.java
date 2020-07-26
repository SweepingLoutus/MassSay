package xyz.sweepingloutus.masssay;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageSender {
    public MessageSender(String[] args) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.hasPermission("masssay.exempt")) {
                String message = String.join(" ", args[1]);
                player.chat(message);
            }
        }
    }
}
