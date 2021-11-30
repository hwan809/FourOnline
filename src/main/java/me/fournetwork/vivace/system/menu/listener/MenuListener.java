package me.fournetwork.vivace.system.menu.listener;

import me.fournetwork.vivace.Main;
import me.fournetwork.vivace.system.menu.MenuSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class MenuListener implements Listener {
    @EventHandler
    public void openMenu(PlayerSwapHandItemsEvent event) {
        MenuSystem system = Main.getInstance().getSystemManager().getSystem(MenuSystem.class);

        Player player = event.getPlayer();

        if (!player.isSneaking()) {
            return;
        }

        system.openMenuInventory(player);
        event.setCancelled(true);
    }
}
