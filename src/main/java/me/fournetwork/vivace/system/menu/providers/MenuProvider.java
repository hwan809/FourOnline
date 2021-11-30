package me.fournetwork.vivace.system.menu.providers;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import me.fournetwork.vivace.Main;
import me.fournetwork.vivace.system.menu.MenuSystem;
import me.fournetwork.vivace.system.menu.inventories.BagGUI;
import me.fournetwork.vivace.system.menu.inventories.GarbageCan;
import me.fournetwork.vivace.system.playerbag.BagSystem;
import me.fournetwork.vivace.system.playerbag.bagdata.PlayerBag;
import me.fournetwork.vivace.util.PlayerHead;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
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
            openInventory(player, GarbageCan.class);
        }));

        contents.set(0, 2, ClickableItem.of(new ItemStack(Material.CHEST), e -> {
            e.setCancelled(true);
            BagSystem system = Main.getInstance().getSystemManager().getSystem(BagSystem.class);

            if (!system.isPlayerHavingBag(player)) {
                OfflinePlayer nowPlayer = Bukkit.getOfflinePlayer(player.getUniqueId());

                system.playerBags.put(nowPlayer, new PlayerBag(nowPlayer));
            }

            openInventory(player, BagGUI.class);
        }));

        contents.set(0, 4, ClickableItem.of(PlayerHead.getPlayerHead(player.getName()), e -> {

        }));

        contents.set(0, 6, ClickableItem.of(new ItemStack(Material.ENCHANTED_BOOK), e -> {

        }));

        contents.set(0, 7, ClickableItem.of(new ItemStack(Material.FLINT_AND_STEEL), e -> {

        }));

        contents.set(1, 4, ClickableItem.of(new ItemStack(Material.BEACON), e -> {

        }));

        contents.set(2, 1, ClickableItem.of(new ItemStack(Material.EXP_BOTTLE), e -> {

        }));

        contents.set(2, 2, ClickableItem.of(new ItemStack(Material.KNOWLEDGE_BOOK), e -> {

        }));

        contents.set(2, 3, ClickableItem.of(new ItemStack(Material.BOOK), e -> {

        }));

        contents.set(2, 4, ClickableItem.of(new ItemStack(Material.COMPASS), e -> {

        }));

        contents.set(2, 5, ClickableItem.of(new ItemStack(Material.EYE_OF_ENDER), e -> {

        }));

        contents.set(2, 6, ClickableItem.of(new ItemStack(Material.STORAGE_MINECART), e -> {

        }));

        contents.set(2, 7, ClickableItem.of(new ItemStack(Material.POWERED_MINECART), e -> {
            player.closeInventory();
        }));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }

    public void openInventory(Player p, Class c) {
        p.closeInventory();
        p.openInventory(MenuSystem.invLinkers.get(c.getName()).getInventory(p));
    }
}
