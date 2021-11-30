package me.fournetwork.vivace.system.menu.inventories;

import me.fournetwork.vivace.util.ItemStackBuilder;
import me.fournetwork.vivace.util.PlayerHead;
import me.fournetwork.vivace.util.inventory.InventoryLinker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class PlayerInfo implements Listener, InventoryLinker {

    private final static String invName = ChatColor.RED + "[ 플레이어 정보 ]";

    @Override
    public void init() {

    }

    @Override
    public String getName() {
        return invName;
    }

    @Override
    public Inventory getInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, invName);

        ItemStackBuilder headBuilder = new ItemStackBuilder(PlayerHead.getPlayerHead(player.getName()));

        headBuilder.setName(ChatColor.GOLD + player.getName() + ChatColor.WHITE + " 님의 정보");
        headBuilder.addLore(" ")
                .addLore(ChatColor.RED + "[ 레벨 ] " + ChatColor.GOLD + player.getLevel())
                .addLore(ChatColor.RED + "[ 경험치 ] " + ChatColor.GOLD + player.getExp() +
                        ChatColor.RED + " / " + ChatColor.GOLD + player.getExpToLevel());

        inventory.setItem(4, headBuilder.build());

        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();
        ItemStack armor = player.getInventory().getItemInMainHand();

        ItemStack none = new ItemStackBuilder(Material.BARRIER).setName(ChatColor.RED + " ").build();

        inventory.setItem(10, helmet != null ? helmet : none);
        inventory.setItem(11, chestplate != null ? chestplate : none);
        inventory.setItem(12, leggings != null ? leggings : none);
        inventory.setItem(13, boots != null ? boots : none);

        inventory.setItem(14, armor != null ? armor : none);

        ItemStackBuilder playInfo = new ItemStackBuilder(Material.WATCH);

        Timestamp timeStamp = new Timestamp(player.getLastPlayed());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = sdf.format(timeStamp);

        long ticks = player.getStatistic(Statistic.PLAY_ONE_TICK);
        long secs = Math.floorDiv(ticks, 20);

        int hour = (int) (secs / (60 * 60));
        int minute = (int) (secs / 60 - (hour * 60));

        String is0nline = ChatColor.BOLD + (player.isOnline() ? ChatColor.GREEN + "온라인" : ChatColor.RED + "오프라인");

        playInfo.setName(ChatColor.GREEN + "▶" + ChatColor.GOLD + " PLAYTIME");
        playInfo.addLore(" ")
                .addLore(ChatColor.RED + "[ 마지막 접속 ] " + ChatColor.GOLD + time)
                .addLore(ChatColor.RED + "[ 플레이어 상태 ] " + is0nline)
                .addLore(ChatColor.RED + "[ 플레이 타임 ] " + ChatColor.GOLD + hour + " 시간 " + minute + "분");

        inventory.setItem(16, playInfo.build());

        return inventory;
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals(invName)) return;

        e.setCancelled(true);
    }
}
