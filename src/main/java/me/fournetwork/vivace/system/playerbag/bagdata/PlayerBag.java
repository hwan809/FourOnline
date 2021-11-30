package me.fournetwork.vivace.system.playerbag.bagdata;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class PlayerBag {
    private OfflinePlayer bagPlayer;

    private ItemStack[] bagContents;
    private int bagSize = 27;

    public PlayerBag(OfflinePlayer player) {
        this.bagPlayer = player;
        this.bagContents = new ItemStack[27];

        Arrays.fill(bagContents, new ItemStack(Material.AIR));
    }

    public PlayerBag(OfflinePlayer player, int bagSize) {
        this.bagPlayer = player;
        this.bagSize = bagSize;
        this.bagContents = new ItemStack[27];

        Arrays.fill(bagContents, new ItemStack(Material.AIR));
    }

    public PlayerBag(OfflinePlayer player, int bagSize, ItemStack[] bagContents) {
        this.bagPlayer = player;
        this.bagSize = bagSize;
        this.bagContents = bagContents;
    }

    public void setItem(int i, ItemStack itemStack) {
        this.bagContents[i] = itemStack;
    }
}
