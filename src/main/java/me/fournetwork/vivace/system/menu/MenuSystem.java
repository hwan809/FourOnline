package me.fournetwork.vivace.system.menu;

import fr.minuskube.inv.InventoryManager;
import fr.minuskube.inv.SmartInventory;
import me.fournetwork.vivace.Main;
import me.fournetwork.vivace.system.System;
import me.fournetwork.vivace.system.menu.listener.MenuListener;
import me.fournetwork.vivace.system.menu.providers.MenuProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.IOException;

public class MenuSystem implements System {

    public final static String MENU_ID = "menu_inventory";
    public static SmartInventory MENU_INVENTORY;

    private InventoryManager invManager;

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
}
