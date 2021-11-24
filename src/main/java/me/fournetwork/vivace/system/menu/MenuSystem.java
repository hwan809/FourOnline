package me.fournetwork.vivace.system.menu;

import fr.minuskube.inv.InventoryManager;
import fr.minuskube.inv.SmartInventory;
import me.fournetwork.vivace.Main;
import me.fournetwork.vivace.system.System;
import me.fournetwork.vivace.system.menu.providers.MenuProvider;
import org.bukkit.ChatColor;

import java.io.IOException;

public class MenuSystem implements System {

    public final static String MENU_ID = "menu_inventory";
    public static SmartInventory MENU_INVENTORY;

    private InventoryManager invManager;

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
