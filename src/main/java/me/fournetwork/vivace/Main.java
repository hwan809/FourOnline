package me.fournetwork.vivace;

import me.fournetwork.vivace.system.SystemManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    private SystemManager systemManager;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initSystemManager() {
        systemManager = new SystemManager();
        Menu
        systemManager.setup();
    }
}
