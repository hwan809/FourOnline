package me.fournetwork.vivace.system.menu.providers;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MenuProvider implements InventoryProvider {

    public static ItemStack LIGHT_GRAY_STAINED_GLASS_PANE = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);

    @Override
    public void init(Player player, InventoryContents contents) {
        for (int column : new int[]{0, 8}) {
            contents.fillColumn(column, ClickableItem.empty(LIGHT_GRAY_STAINED_GLASS_PANE));
        }

        //0. 쓰레기통 CAULDRON
        contents.set(1, 0, ClickableItem.of(new ItemStack(Material.CAULDRON), e -> {
            player.closeInventory();
        }));

        //1. 가방 CHEST
        contents.set(2, 0, ClickableItem.of(new ItemStack(Material.CHEST), e -> {
            player.closeInventory();
        }));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
