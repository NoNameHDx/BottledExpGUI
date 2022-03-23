package me.nonamehd.de.simplebottledexp.commands;

import me.nonamehd.de.simplebottledexp.SimpleBottledExp;
import me.nonamehd.de.simplebottledexp.listeners.CustomExperienceGUI;
import me.nonamehd.de.simplebottledexp.listeners.CustomLevelGUI;
import me.nonamehd.de.simplebottledexp.util.ExperienceCalc;
import me.nonamehd.de.simplebottledexp.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class BottleCommand implements CommandExecutor {
    public static Inventory bottlegui;



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if(SimpleBottledExp.PermissionsEnabled){
                if(SimpleBottledExp.GUIPermissionsEnabled){
                        if (sender.hasPermission("custombottledexp.gui")) {
                                setInventory((Player) sender);
                        }else {
                                sender.sendMessage("§f[§aSimpleBottledExp§f]§7: §4You don't have the permission custombottledexp.gui");
                        }
                }

            }else{
                    setInventory((Player) sender);
            }




        return false;
    }
    public static void setInventory(Player player) {

            bottlegui = Bukkit.createInventory((InventoryHolder) player, 3 * 9, "§1Experience§7To§6Bottle");
            CustomLevelGUI.definedXPvalue = 0;
            CustomExperienceGUI.definedXPvalue = 0;
            bottlegui.setItem(1, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(2, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(3, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(4, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(5, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(6, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(7, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(8, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(9, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(10, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(12, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(14, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(16, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(17, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(18, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(19, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(20, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(21, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(22, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(23, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(24, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(25, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());
            bottlegui.setItem(26, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayname("").build());

            //PlayerInfo
            ItemStack playerInfo = new ItemStack(Material.WRITABLE_BOOK);
            ItemMeta playerInfoMeta = playerInfo.getItemMeta();
            assert playerInfoMeta != null;
            playerInfoMeta.setLocalizedName("playerinfo");
            playerInfoMeta.setDisplayName("§aPlayer§6Info");
            ArrayList<String> playerInfoLore = new ArrayList<>();
            playerInfoLore.add("§fName:" + ChatColor.GRAY + ((Player) player).getName());
            playerInfoLore.add("§aExperience:" + ChatColor.GRAY + ExperienceCalc.getExp(Objects.requireNonNull(((Player) player).getPlayer())));
            playerInfoLore.add("§6Level:" + ChatColor.GRAY + ((Player) player).getLevel());
            playerInfoMeta.setLore(playerInfoLore);
            playerInfoMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
            playerInfoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            playerInfo.setItemMeta(playerInfoMeta);
            bottlegui.setItem(0, playerInfo);
            //customExperienceAmount
            ItemStack customBottleExp = new ItemStack(Material.GLASS_BOTTLE);
            ItemMeta customBottleExpMeta = customBottleExp.getItemMeta();
            assert customBottleExpMeta != null;
            customBottleExpMeta.setDisplayName("§aCustomExperienceAmmount");
            ArrayList<String> customBottleExpLore = new ArrayList<>();
            customBottleExpLore.add("§7This will fill a custom amount of experience into a bottle");
            customBottleExpMeta.setLore(customBottleExpLore);
            customBottleExpMeta.setLocalizedName("customexperience");
            customBottleExpMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
            customBottleExpMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            customBottleExp.setItemMeta(customBottleExpMeta);
            bottlegui.setItem(11, customBottleExp);
            //maxExperienceToBottle
            ItemStack maxBottleExp = new ItemStack(Material.EXPERIENCE_BOTTLE);
            ItemMeta maxBottleExpMeta = maxBottleExp.getItemMeta();
            assert maxBottleExpMeta != null;
            maxBottleExpMeta.setDisplayName("§aMaxExperience");
            ArrayList<String> maxBottleExpLore = new ArrayList<>();
            maxBottleExpLore.add("§7This will fill all of your experience into a bottle");
            maxBottleExpMeta.setLore(maxBottleExpLore);
            maxBottleExpMeta.setLocalizedName("maxexperience");
            maxBottleExpMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
            maxBottleExpMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            maxBottleExp.setItemMeta(maxBottleExpMeta);
            bottlegui.setItem(13, maxBottleExp);
            //customLevelAmount
            ItemStack maxBottleLevel = new ItemStack(Material.HONEY_BOTTLE);
            ItemMeta maxBottleLevelMeta = maxBottleLevel.getItemMeta();
            assert maxBottleLevelMeta != null;
            maxBottleLevelMeta.setDisplayName("§aCustomLevelAmount");
            ArrayList<String> maxBottleLevelLore = new ArrayList<>();
            maxBottleLevelLore.add("§7This will fill a custom amount of Level into a bottle");
            maxBottleLevelMeta.setLore(maxBottleLevelLore);
            maxBottleLevelMeta.setLocalizedName("customlevel");
            maxBottleLevelMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
            maxBottleLevelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            maxBottleLevel.setItemMeta(maxBottleLevelMeta);
            bottlegui.setItem(15, maxBottleLevel);

            player.openInventory(bottlegui);


    }
}
