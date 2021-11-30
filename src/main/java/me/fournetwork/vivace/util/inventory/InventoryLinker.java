package me.fournetwork.vivace.util.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public interface InventoryLinker {
    public void init();
    public String getName();
    public Inventory getInventory();
}
