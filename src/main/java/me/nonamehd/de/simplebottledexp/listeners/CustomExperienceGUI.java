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

public class CustomExperienceGUI {

    public static Integer definedXPvalue = 0;
    public static Inventory customExpGUI;

    public static void CustomExperienceGUIOpened(Player player){


         customExpGUI = Bukkit.createInventory((InventoryHolder) player, 3 * 9, "§1Custom§7XP§6Bottle");

        customExpGUI.setItem(0, new ItemBuilder(Material.BARRIER).setDisplayname("§4§lBACK").setLocalizedName("CustomExpGUIBack").build());
        customExpGUI.setItem(1, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(2, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(3, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(4, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(5, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(6, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(7, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());

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
        customExpGUI.setItem(8, playerInfo);

        customExpGUI.setItem(9, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(9, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());

        customExpGUI.setItem(11,new ItemBuilder(Material.LIME_CONCRETE).setDisplayname("§a+1000 §7XP").setLocalizedName("add1000").build());
        customExpGUI.setItem(12,new ItemBuilder(Material.WHITE_CONCRETE).setDisplayname("§a+100 §7XP").setLocalizedName("add100").build());
        customExpGUI.setItem(15,new ItemBuilder(Material.ORANGE_CONCRETE).setDisplayname("§4-1000 §7XP").setLocalizedName("remove1000").build());
        customExpGUI.setItem(14,new ItemBuilder(Material.YELLOW_CONCRETE).setDisplayname("§4-100 §7XP").setLocalizedName("remove100").build());

        customExpGUI.setItem(17, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(18, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(19, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(20, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(21, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(22, new ItemBuilder(Material.LIME_DYE).setDisplayname("§a§lCONFIRM").setLocalizedName("confirm").build());
        customExpGUI.setItem(23, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(24, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(25, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
        customExpGUI.setItem(26, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());

        //+10000
        ItemStack is1 = new ItemStack(Material.GREEN_CONCRETE);
        ItemMeta im1 = is1.getItemMeta();
        assert im1 != null;
        im1.setLocalizedName("add10000");
        im1.setDisplayName("§a+10000 §7XP");
        is1.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        im1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is1.setItemMeta(im1);
        customExpGUI.setItem(10, is1);

        //-10000
        ItemStack is3 = new ItemStack(Material.RED_CONCRETE);
        ItemMeta im3 = is3.getItemMeta();
        assert im3 != null;
        im3.setLocalizedName("remove10000");
        im3.setDisplayName("§4-10000 §7XP");
        is3.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        im3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is3.setItemMeta(im3);
        customExpGUI.setItem(16, is3);

        //MiddleBottle

        ItemStack is2 = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta im2 = is2.getItemMeta();
        assert im2 != null;
        im2.setDisplayName("§a§lSTORED§7:");
        is2.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        ArrayList<String> middleBottleLore = new ArrayList<>();
        middleBottleLore.add("§aExperience§7: " + definedXPvalue);
        middleBottleLore.add("§6Level§7: " + Math.round(ExperienceCalc.getLevelFromExp(definedXPvalue)));
        im2.setLore(middleBottleLore);
        im2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is2.setItemMeta(im2);
        customExpGUI.setItem(13, is2);

        player.openInventory(customExpGUI);

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
        customExpGUI.setItem(8, playerInfo);
    }

}
