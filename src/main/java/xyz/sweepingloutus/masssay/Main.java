package xyz.sweepingloutus.masssay;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("masssay").setExecutor(new MassSayCommand(this));
        getCommand("masssayreload").setExecutor(new ReloadCommand(this));

        int pluginId = 10512;
        Metrics metrics = new Metrics(this, pluginId);

    }

    @Override
    public void onDisable() {

    }
}
