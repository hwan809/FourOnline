package me.fournetwork.vivace.system.menu.inventories;

import me.fournetwork.vivace.Main;
import me.fournetwork.vivace.system.playerbag.BagSystem;
import me.fournetwork.vivace.system.playerbag.bagdata.PlayerBag;
import me.fournetwork.vivace.util.inventory.InventoryLinker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BagGUI implements Listener, InventoryLinker {

    private final static String invName = ChatColor.GRAY + "[ 가방 ]";

    @Override
    public void init() {

    }

    @Override
    public String getName() {
        return invName;
    }

    @Override
    public Inventory getInventory(Player player) {
        BagSystem system = Main.getInstance().getSystemManager().getSystem(BagSystem.class);

        PlayerBag nowBag = system.getPlayerBag(player);
        Inventory inventory = Bukkit.createInventory(null, nowBag.getBagSize(), invName);

        for (int i = 0; i < nowBag.getBagSize(); i++) {
            inventory.setItem(i, nowBag.getBagContents()[i]);
        }

        return inventory;
    }

    @EventHandler
    public void saveBag(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();

        if (!e.getView().getTitle().equals(invName)) {
            return;
        }

        BagSystem system = Main.getInstance().getSystemManager().getSystem(BagSystem.class);

        PlayerBag nowBag = system.getPlayerBag(player);
        Inventory pBagInventory = e.getInventory();

        for (int i = 0; i < pBagInventory.getSize(); i++) {
            ItemStack refItem = pBagInventory.getItem(i);

            if (refItem != null) {
                nowBag.setItem(i, refItem);
                return;
            }

            nowBag.setItem(i, new ItemStack(Material.AIR));
        }
    }
}
