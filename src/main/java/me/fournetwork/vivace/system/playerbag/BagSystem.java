package me.fournetwork.vivace.system.playerbag;
import me.fournetwork.vivace.system.System;
import me.fournetwork.vivace.system.playerbag.bagdata.PlayerBag;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BagSystem implements System {

    public Map<OfflinePlayer, PlayerBag> playerBags = new HashMap<>();

    @Override
    public void init() {
        // 플레이어 가방 목록 가져오기
    }

    @Override
    public void load() {

    }

    @Override
    public void save() throws IOException {

    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }

    @Override
    public boolean isEnable() {
        return true;
    }

    @Override
    public String getName() {
        return "플레이어 아이템 저장 [ 가방 ]";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    public boolean isPlayerHavingBag(Player player) {
        for (OfflinePlayer bagPlayer : playerBags.keySet()) {
            if (player.getUniqueId().equals(bagPlayer.getUniqueId())) {
                return true;
            }
        }

        return false;
    }

    public PlayerBag getPlayerBag(Player player) {
        for (OfflinePlayer bagPlayer : playerBags.keySet()) {
            if (player.getUniqueId().equals(bagPlayer.getUniqueId())) {
                return playerBags.get(bagPlayer);
            }
        }
        return null;
    }
}
