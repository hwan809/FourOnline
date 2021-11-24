package me.fournetwork.vivace.util.page;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageInventory {

    public static class Settings {

        private final List<Integer> slots;
        private final Inventory base;

        public Settings(List<Integer> slots, Inventory base) {
            this.slots = slots;
            this.base = base;
        }

    }


    public static PageInventory createWithTheSameInventory(Player player, List<ItemStack> itemStacks, Settings settings) {
        PageInventory pageInventory = new PageInventory(player, itemStacks, settings);
        int page = 0;
        for (int i=0; i<itemStacks.size(); i += settings.slots.size()) {
            pageInventory.setSettingsOfPage(page++, settings);
        }
        return pageInventory;
    }

    private final List<ItemStack> itemStacks;
    private int currentPage;
    private final Map<Integer, Settings> slots = new HashMap<>();
    private final Player player;


    public PageInventory(Player player, List<ItemStack> itemStacks, Settings firstPageSettings) {
        this.itemStacks = itemStacks;
        this.slots.put(0, firstPageSettings);
        this.currentPage = 0;
        this.player = player;
    }

    public int getCurrentPage() {
        return currentPage + 1;
    }

    public boolean hasNext() {
        return slots.get(currentPage + 1) != null && slots.get(currentPage + 1).base != null && !slots.get(currentPage + 1).slots.isEmpty();
    }

    public boolean hasPrevious() {
        return currentPage > 1;
    }

    public PageInventory setSettingsOfPage(int page, Settings settings) {
        this.slots.put(page, settings);
        return this;
    }

    public PageInventory next() throws IllegalStateException {
        if (!hasNext()) throw new IllegalStateException("다음페이지가 없습니다!");
        currentPage++;
        return this;
    }

    public PageInventory previous() throws IllegalStateException {
        if (!hasPrevious()) throw new IllegalStateException("이전페이지가 없습니다!");
        currentPage--;
        return this;
    }

    public void open() {
        Inventory inventory = slots.get(currentPage).base;
        int startIndex = 0;
        for (int i=0; i<currentPage; i++) {
            startIndex += slots.get(i).slots.size();
        }
        for (int slot : slots.get(currentPage).slots) {
            if (startIndex >= itemStacks.size()) break;
            inventory.setItem(slot, itemStacks.get(startIndex++));
        }
        player.openInventory(inventory);
    }

    public int getIndex(int clicked) {
        int startIndex = 0;
        for (int i=0; i<currentPage; i++) {
            startIndex += slots.get(i).slots.size();
        }
        for (int i=0; i<slots.get(currentPage).slots.size(); i++) {
            if (clicked == slots.get(currentPage).slots.get(i)) return startIndex + i;
        }
        return -1;
    }
}
