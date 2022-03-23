package me.nonamehd.de.simplebottledexp.listeners;


import me.nonamehd.de.simplebottledexp.util.ExperienceCalc;
import me.nonamehd.de.simplebottledexp.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;


public class CustomLevelGUI {

    public static Integer definedXPvalue = 0;
    public static Inventory customLevelGUI;

    public static void CustomLevelGUIOpened(Player player){


        customLevelGUI = Bukkit.createInventory((InventoryHolder) player, 3 * 9, "§1Custom§7Level§6Bottle");

        customLevelGUI.setItem(0, new ItemBuilder(Material.BARRIER).setDisplayname("§4§lBACK").setLocalizedName("CustomExpGUIBack").build());
        customLevelGUI.setItem(1, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(2, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(3, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(4, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(5, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(6, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(7, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());


        ItemStack playerInfo = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta playerInfoMeta = playerInfo.getItemMeta();
        assert playerInfoMeta != null;
        playerInfoMeta.setLocalizedName("playerinfo");
        playerInfoMeta.setDisplayName("§aPlayer§6Info");
        ArrayList<String> playerInfoLore = new ArrayList<>();
        playerInfoLore.add("§fName:" + ChatColor.GRAY + player.getName());
        playerInfoLore.add("§aExperience:" + ChatColor.GRAY + ExperienceCalc.getExp(Objects.requireNonNull(player.getPlayer())));
        playerInfoLore.add("§6Level:" + ChatColor.GRAY + player.getLevel());
        playerInfoMeta.setLore(playerInfoLore);
        playerInfoMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        playerInfoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        playerInfo.setItemMeta(playerInfoMeta);
        customLevelGUI.setItem(8, playerInfo);

        customLevelGUI.setItem(9, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(9, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());

        customLevelGUI.setItem(11,new ItemBuilder(Material.LIME_CONCRETE).setDisplayname("§a+10 §7Level").setLocalizedName("add10").build());
        customLevelGUI.setItem(12,new ItemBuilder(Material.WHITE_CONCRETE).setDisplayname("§a+1 §7Level").setLocalizedName("add1").build());
        customLevelGUI.setItem(15,new ItemBuilder(Material.ORANGE_CONCRETE).setDisplayname("§4-10 §7Level").setLocalizedName("remove10").build());
        customLevelGUI.setItem(14,new ItemBuilder(Material.YELLOW_CONCRETE).setDisplayname("§4-1 §7Level").setLocalizedName("remove1").build());

        customLevelGUI.setItem(17, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(18, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(19, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(20, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(21, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(22, new ItemBuilder(Material.LIME_DYE).setDisplayname("§a§lCONFIRM").setLocalizedName("confirm").build());
        customLevelGUI.setItem(23, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(24, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(25, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());
        customLevelGUI.setItem(26, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).build());

        //+10000
        ItemStack is1 = new ItemStack(Material.GREEN_CONCRETE);
        ItemMeta im1 = is1.getItemMeta();
        assert im1 != null;
        im1.setLocalizedName("add100");
        im1.setDisplayName("§a+100 §7Level");
        is1.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        im1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is1.setItemMeta(im1);
        customLevelGUI.setItem(10, is1);

        //-10000
        ItemStack is3 = new ItemStack(Material.RED_CONCRETE);
        ItemMeta im3 = is3.getItemMeta();
        assert im3 != null;
        im3.setLocalizedName("remove100");
        im3.setDisplayName("§4-100 §7Level");
        is3.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        im3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is3.setItemMeta(im3);
        customLevelGUI.setItem(16, is3);

        //MiddleBottle

        ItemStack is2 = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta im2 = is2.getItemMeta();
        assert im2 != null;
        im2.setDisplayName("§a§lSTORED§7:");
        is2.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        ArrayList<String> middleBottleLore = new ArrayList<>();
        middleBottleLore.add("§aExperience§7: " + ExperienceCalc.getExpFromLevel(definedXPvalue));
        middleBottleLore.add("§6Level§7: " + definedXPvalue);
        im2.setLore(middleBottleLore);
        im2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is2.setItemMeta(im2);
        customLevelGUI.setItem(13, is2);

        player.openInventory(customLevelGUI);

    }
    public static void PlayerStatsReload(Player player){
        ItemStack playerInfo = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta playerInfoMeta = playerInfo.getItemMeta();
        assert playerInfoMeta != null;
        playerInfoMeta.setLocalizedName("playerinfo");
        playerInfoMeta.setDisplayName("§aPlayer§6Info");
        ArrayList<String> playerInfoLore = new ArrayList<>();
        playerInfoLore.add("§fName:" + ChatColor.GRAY + player.getName());
        playerInfoLore.add("§aExperience:" + ChatColor.GRAY + ExperienceCalc.getExp(Objects.requireNonNull(player.getPlayer())));
        playerInfoLore.add("§6Level:" + ChatColor.GRAY + player.getLevel());
        playerInfoMeta.setLore(playerInfoLore);
        playerInfoMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        playerInfoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        playerInfo.setItemMeta(playerInfoMeta);
        customLevelGUI.setItem(8, playerInfo);
    }

}