package me.fournetwork.vivace.system.menu.providers;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import me.fournetwork.vivace.util.PlayerHead;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MenuProvider implements InventoryProvider {

    public static ItemStack GRAY_STAINED_GLASS_PANE = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);

    @Override
    public void init(Player player, InventoryContents contents) {
        for (int column : new int[]{0, 8}) {
            contents.fillColumn(column, ClickableItem.empty(GRAY_STAINED_GLASS_PANE));
        }

        contents.set(0, 1, ClickableItem.of(new ItemStack(Material.CAULDRON_ITEM), e -> {
            player.closeInventory();
        }));

        contents.set(0, 2, ClickableItem.of(new ItemStack(Material.CHEST), e -> {
            player.closeInventory();
        }));

        contents.set(0, 4, ClickableItem.of(PlayerHead.getPlayerHead(player.getName()), e -> {
            player.closeInventory();
        }));

        contents.set(0, 6, ClickableItem.of(new ItemStack(Material.ENCHANTED_BOOK), e -> {
            player.closeInventory();
        }));

        contents.set(0, 7, ClickableItem.of(new ItemStack(Material.FLINT_AND_STEEL), e -> {
            player.closeInventory();
        }));

        contents.set(1, 4, ClickableItem.of(new ItemStack(Material.BEACON), e -> {
            player.closeInventory();
        }));

        contents.set(2, 1, ClickableItem.of(new ItemStack(Material.EXP_BOTTLE), e -> {
            player.closeInventory();
        }));

        contents.set(2, 2, ClickableItem.of(new ItemStack(Material.KNOWLEDGE_BOOK), e -> {
            player.closeInventory();
        }));

        contents.set(2, 3, ClickableItem.of(new ItemStack(Material.BOOK), e -> {
            player.closeInventory();
        }));

        contents.set(2, 4, ClickableItem.of(new ItemStack(Material.COMPASS), e -> {
            player.closeInventory();
        }));

        contents.set(2, 5, ClickableItem.of(new ItemStack(Material.EYE_OF_ENDER), e -> {
            player.closeInventory();
        }));

        contents.set(2, 6, ClickableItem.of(new ItemStack(Material.STORAGE_MINECART), e -> {
            player.closeInventory();
        }));

        contents.set(2, 7, ClickableItem.of(new ItemStack(Material.POWERED_MINECART), e -> {
            player.closeInventory();
        }));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
