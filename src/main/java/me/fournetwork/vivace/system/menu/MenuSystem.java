package me.fournetwork.vivace.system.menu;

import fr.minuskube.inv.InventoryManager;
import fr.minuskube.inv.SmartInventory;
import me.fournetwork.vivace.Main;
import me.fournetwork.vivace.system.System;
import me.fournetwork.vivace.system.menu.inventories.BagGUI;
import me.fournetwork.vivace.system.menu.inventories.GarbageCan;
import me.fournetwork.vivace.system.menu.inventories.PlayerInfo;
import me.fournetwork.vivace.system.menu.listener.MenuListener;
import me.fournetwork.vivace.system.menu.providers.MenuProvider;
import me.fournetwork.vivace.util.inventory.InventoryLinker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuSystem implements System {

    public final static String MENU_ID = "menu_inventory";
    public static SmartInventory MENU_INVENTORY;

    private InventoryManager invManager;
    public static Map<String, InventoryLinker> invLinkers = new HashMap<>();

    public void openMenuInventory(Player player) {
        MENU_INVENTORY.open(player);
    }

    @Override
    public void init() {
        this.invManager = new InventoryManager(Main.getInstance());
        this.invManager.init();

        MENU_INVENTORY = SmartInventory.builder()
                        .id(MENU_ID)
                        .manager(invManager)
                        .provider(new MenuProvider())
                        .size(3, 9)
                        .title(ChatColor.GOLD + "[ THE NETWORK ]")
                        .build();

        Bukkit.getPluginManager().registerEvents(new MenuListener(), Main.getInstance());

        addLinkers();
    }

    @Override
    public void load() {

    }

    @Override
    public void save() throws IOException {

    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }

    @Override
    public boolean isEnable() {
        return true;
    }

    @Override
    public String getName() {
        return "메뉴 GUI";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    public void addLinkers() {
        invLinkers.put(GarbageCan.class.getName(), new GarbageCan());
        invLinkers.put(BagGUI.class.getName(), new BagGUI());
        invLinkers.put(PlayerInfo.class.getName(), new PlayerInfo());

        for (InventoryLinker linker : invLinkers.values()) {
            Main.getInstance().getServer().getPluginManager().registerEvents((Listener) linker, Main.getInstance());
            linker.init();
        }
    }
}
