package me.fournetwork.vivace.util.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface InventoryLinker {
    public void init();
    public String getName();
    public Inventory getInventory(Player player);
}
