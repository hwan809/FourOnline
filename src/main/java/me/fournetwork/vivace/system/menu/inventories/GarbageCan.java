package me.fournetwork.vivace.system.menu.inventories;

import me.fournetwork.vivace.Main;
import me.fournetwork.vivace.util.inventory.InventoryLinker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class GarbageCan implements Listener, InventoryLinker {

    private final static String invName = ChatColor.RED + "[ 쓰레기통 ]";

    @Override
    public void init() {

    }

    @Override
    public String getName() {
        return invName;
    }

    @Override
    public Inventory getInventory(Player player) {
        return Bukkit.createInventory(null, 27, invName);
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals(invName)) {
            return;
        }
    }
}
