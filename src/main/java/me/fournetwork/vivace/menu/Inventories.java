package me.fournetwork.vivace.menu;

import fr.minuskube.inv.SmartInventory;
import me.fournetwork.vivace.menu.providers.MenuProvider;
import org.bukkit.ChatColor;

public class Inventories {

    public final static String MENU_ID = "menu_inventory";

    public final static String GARBAGE_ID = "garbage_inventory";

    public static SmartInventory MENU_INVENTORY = SmartInventory.builder()
            .id(MENU_ID).provider(new MenuProvider()).size(3, 9).title(ChatColor.GOLD + "[ THE NETWORK ]").build();

    public static SmartInventory GARBAGE_INVENTORY = SmartInventory.builder()
            .id(GARBAGE_ID).provider(new MenuProvider()).size(1, 9).title(ChatColor.RED + "[ 쓰레기통 ]").build();
}
