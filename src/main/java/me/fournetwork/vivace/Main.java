package me.fournetwork.vivace;

import lombok.Getter;
import me.fournetwork.vivace.system.SystemManager;
import me.fournetwork.vivace.system.menu.MenuSystem;
import me.fournetwork.vivace.system.playerbag.BagSystem;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    private SystemManager systemManager;

    @Override
    public void onEnable() {
        instance = this;
        initSystemManager();
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initSystemManager() {
        systemManager = new SystemManager();
        systemManager.setup(new MenuSystem());
        systemManager.setup(new BagSystem());
    }
}
