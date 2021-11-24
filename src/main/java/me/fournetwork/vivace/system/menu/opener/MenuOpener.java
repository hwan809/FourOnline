package me.fournetwork.vivace.system.menu.opener;

import me.fournetwork.vivace.system.menu.Inventories;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class MenuOpener implements Listener {
    @EventHandler
    public void openMenu(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();

        if (!player.isSneaking()) {
            return;
        }

        Inventories.MENU_INVENTORY.open(player);
    }
}
