package me.nonamehd.de.simplebottledexp.listeners;

import me.nonamehd.de.simplebottledexp.SimpleBottledExp;
import me.nonamehd.de.simplebottledexp.commands.BottleCommand;
import me.nonamehd.de.simplebottledexp.util.ExperienceCalc;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class CustomExperienceGUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        if(event.getCurrentItem() == null)return;
        if(event.getView().getTitle().equals("§1Custom§7XP§6Bottle")){
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if((Objects.requireNonNull(event.getCurrentItem().getItemMeta())).hasLocalizedName()){

                switch(event.getCurrentItem().getItemMeta().getLocalizedName()){
                    case "add100":

                        CustomExperienceGUI.definedXPvalue += 100;
                        CustomExperienceGUI.CustomExperienceGUIOpened(player);

                        break;

                    case "add1000":
                        CustomExperienceGUI.definedXPvalue += 1000;
                        CustomExperienceGUI.CustomExperienceGUIOpened(player);
                        break;

                    case "add10000":
                        CustomExperienceGUI.definedXPvalue += 10000;
                        CustomExperienceGUI.CustomExperienceGUIOpened(player);
                        break;

                    case "remove100":
                        if (CustomExperienceGUI.definedXPvalue - 100 > -1) {
                            CustomExperienceGUI.definedXPvalue -= 100;
                        }else{
                            CustomExperienceGUI.definedXPvalue = 0;
                        }
                        CustomExperienceGUI.CustomExperienceGUIOpened(player);
                        break;

                    case "remove1000":
                        if (CustomExperienceGUI.definedXPvalue-1000 > -1) {
                            CustomExperienceGUI.definedXPvalue -= 1000;
                        }else{
                            CustomExperienceGUI.definedXPvalue = 0;
                        }
                        CustomExperienceGUI.CustomExperienceGUIOpened(player);
                        break;

                    case "remove10000":
                        if (CustomExperienceGUI.definedXPvalue-10000 > -1) {
                            CustomExperienceGUI.definedXPvalue -= 10000;
                        }else{
                            CustomExperienceGUI.definedXPvalue = 0;
                        }
                        CustomExperienceGUI.CustomExperienceGUIOpened(player);
                        break;

                    case "CustomExpGUIBack":
                        player.closeInventory();
                        player.openInventory(BottleCommand.bottlegui);
                        break;


                    case "confirm":

                        if(CustomExperienceGUI.definedXPvalue > 99){

                        if(ExperienceCalc.getExp(player) >  CustomExperienceGUI.definedXPvalue - 1){

                        ItemStack maxBottle = new ItemStack(Material.EXPERIENCE_BOTTLE);
                        ItemMeta maxBottleMeta = maxBottle.getItemMeta();
                        assert maxBottleMeta != null;
                        maxBottleMeta.setDisplayName("§a§lEXPERIENCE CONTAINER");
                        maxBottle.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
                        maxBottleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        ArrayList<String> maxBottleLore = new ArrayList<>();
                        maxBottleLore.add("");
                        maxBottleLore.add("§2==========================");
                        maxBottleLore.add("§f§lSTORED:");
                        maxBottleLore.add("Experience:" + ChatColor.LIGHT_PURPLE + CustomExperienceGUI.definedXPvalue);
                        maxBottleLore.add("Level:" + ChatColor.LIGHT_PURPLE + Math.round(ExperienceCalc.getLevelFromExp(CustomExperienceGUI.definedXPvalue)));
                        maxBottleLore.add("§2==========================");
                        maxBottleLore.add("");
                        maxBottleLore.add("§6§lCreated by "+ ChatColor.GOLD + player.getName());
                        maxBottleMeta.setLore(maxBottleLore);
                        maxBottle.setItemMeta(maxBottleMeta);
                        ExperienceCalc.changeExp(player, -CustomExperienceGUI.definedXPvalue);
                        player.getInventory().addItem(maxBottle);
                        player.closeInventory();
                        player.openInventory(CustomExperienceGUI.customExpGUI);
                        CustomExperienceGUI.PlayerStatsReload(player);
                        break;

                    }}else{
                            player.sendMessage("§f[§aSimpleBottledExp§f]§7: §4You don't have enough experience!");
                        }

                }

            }
        }else if(event.getView().getTitle().equals("§1Custom§7Level§6Bottle")){

            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if((Objects.requireNonNull(event.getCurrentItem().getItemMeta())).hasLocalizedName()){

                switch(event.getCurrentItem().getItemMeta().getLocalizedName()){
                    case "add1":

                        CustomLevelGUI.definedXPvalue += 1;
                        CustomLevelGUI.CustomLevelGUIOpened(player);

                        break;

                    case "add10":
                        CustomLevelGUI.definedXPvalue += 10;
                        CustomLevelGUI.CustomLevelGUIOpened(player);
                        break;

                    case "add100":
                        CustomLevelGUI.definedXPvalue += 100;
                        CustomLevelGUI.CustomLevelGUIOpened(player);
                        break;

                    case "remove1":
                        if (CustomLevelGUI.definedXPvalue - 1 > -1) {
                            CustomLevelGUI.definedXPvalue -= 1;
                        }else{
                            CustomLevelGUI.definedXPvalue = 0;
                        }
                        CustomLevelGUI.CustomLevelGUIOpened(player);
                        break;

                    case "remove10":
                        if (CustomLevelGUI.definedXPvalue- 10 > -1) {
                            CustomLevelGUI.definedXPvalue -= 10;
                        }else{
                            CustomLevelGUI.definedXPvalue = 0;
                        }
                        CustomLevelGUI.CustomLevelGUIOpened(player);
                        break;

                    case "remove100":
                        if (CustomLevelGUI.definedXPvalue-100 > -1) {
                            CustomLevelGUI.definedXPvalue -= 100;
                        }else{
                            CustomLevelGUI.definedXPvalue = 0;
                        }
                        CustomLevelGUI.CustomLevelGUIOpened(player);
                        break;

                    case "CustomExpGUIBack":
                        player.openInventory(BottleCommand.bottlegui);
                        CustomExperienceGUI.definedXPvalue = 0;
                        CustomLevelGUI.definedXPvalue = 0;
                        break;


                    case "confirm":

                        if(CustomLevelGUI.definedXPvalue > 0){

                            if(ExperienceCalc.getLevelFromExp(ExperienceCalc.getExp(player)) >  CustomLevelGUI.definedXPvalue - 1){

                                ItemStack maxBottle = new ItemStack(Material.EXPERIENCE_BOTTLE);
                                ItemMeta maxBottleMeta = maxBottle.getItemMeta();
                                assert maxBottleMeta != null;
                                maxBottleMeta.setDisplayName("§a§lEXPERIENCE CONTAINER");
                                maxBottle.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
                                maxBottleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                                ArrayList<String> maxBottleLore = new ArrayList<>();
                                maxBottleLore.add("");
                                maxBottleLore.add("§2==========================");
                                maxBottleLore.add("§f§lSTORED:");
                                maxBottleLore.add("Experience:" + ChatColor.LIGHT_PURPLE + Math.round(ExperienceCalc.getExpFromLevel(CustomLevelGUI.definedXPvalue)));
                                maxBottleLore.add("Level:" + ChatColor.LIGHT_PURPLE + CustomLevelGUI.definedXPvalue);
                                maxBottleLore.add("§2==========================");
                                maxBottleLore.add("");
                                maxBottleLore.add("§6§lCreated by "+ ChatColor.GOLD + player.getName());
                                maxBottleMeta.setLore(maxBottleLore);
                                maxBottle.setItemMeta(maxBottleMeta);
                                ExperienceCalc.changeExp(player, - ExperienceCalc.getExpFromLevel(CustomLevelGUI.definedXPvalue));
                                CustomLevelGUI.PlayerStatsReload(player);
                                player.getInventory().addItem(maxBottle);
                                player.closeInventory();
                                player.openInventory(CustomLevelGUI.customLevelGUI);
                                break;



                            }
                        }else{
                            player.sendMessage("§f[§aSimpleBottledExp§f]§7: §4You don't have enough level!");
                        }
                    }
                }
            }
        }
    }


