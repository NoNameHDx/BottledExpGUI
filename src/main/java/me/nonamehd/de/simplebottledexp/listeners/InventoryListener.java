package me.nonamehd.de.simplebottledexp.listeners;

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

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null)return;
        if(event.getView().getTitle().equals("§1Experience§7To§6Bottle")){
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if(Objects.requireNonNull(event.getCurrentItem().getItemMeta()).hasLocalizedName()){
               switch(event.getCurrentItem().getItemMeta().getLocalizedName()){
                   case "customexperience":
                    CustomExperienceGUI.definedXPvalue = 0;
                    CustomExperienceGUI.CustomExperienceGUIOpened(Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()));


                       break;
                   case "maxexperience":
                       if(player.getLevel() > 1){

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
                           maxBottleLore.add("Experience:" + ChatColor.LIGHT_PURPLE + ExperienceCalc.getExp(player));
                           maxBottleLore.add("Level:" + ChatColor.LIGHT_PURPLE + player.getLevel());
                           maxBottleLore.add("§2==========================");
                           maxBottleLore.add("");
                           maxBottleLore.add("§6§lCreated by "+ ChatColor.GOLD + player.getName());
                           maxBottleMeta.setLore(maxBottleLore);
                           maxBottle.setItemMeta(maxBottleMeta);
                           player.setLevel(0);
                           player.setExp(0);
                           player.getInventory().addItem(maxBottle);
                           player.closeInventory();
                           BottleCommand.setInventory(player);


                       }else {

                           player.sendMessage("§f[§aSimpleBottledExp§f]§7: §4You don't have enough experience!");
                       }

                       break;
                   case "customlevel":
                    CustomLevelGUI.CustomLevelGUIOpened(player);
                    CustomLevelGUI.definedXPvalue = 0;


                       break;
               }

            }
        }

    }
}

