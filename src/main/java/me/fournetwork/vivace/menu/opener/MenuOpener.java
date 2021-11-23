package me.fournetwork.vivace.menu.opener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class MenuOpener implements Listener {
    @EventHandler
    public void openMenu(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();

        if (!player.isSneaking()) {
            return;
        }


    }
}
