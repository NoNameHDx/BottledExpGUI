package me.nonamehd.de.simplebottledexp.listeners;

import me.nonamehd.de.simplebottledexp.SimpleBottledExp;
import me.nonamehd.de.simplebottledexp.util.ExperienceCalc;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.Objects;

public class ExperienceBottleListener implements Listener {


    @EventHandler
    public void onCustomExperienceBottleThrow(PlayerInteractEvent event) {

        if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.EXPERIENCE_BOTTLE && Objects.requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equalsIgnoreCase("§a§lEXPERIENCE CONTAINER")) {
            Player p = event.getPlayer();
            event.setCancelled(true);
            if (p.getInventory().getItemInMainHand().hasItemMeta()&& Objects.requireNonNull(p.getInventory().getItemInMainHand().getItemMeta()).hasLore()
                    && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {

        if (SimpleBottledExp.PermissionsEnabled) {
            if (SimpleBottledExp.BottlePermissionsEnabled) {
                if (event.getPlayer().hasPermission("custombottledexp.usebottle")) {
                    BottleThrowEvent(event);
                } else {
                    event.getPlayer().sendMessage("§f[§aSimpleBottledExp§f]§7: §4You don't have the permission custombottledexp.usebottle");

                }
            }else {
                BottleThrowEvent(event);
        }

        }else {
            BottleThrowEvent(event);
        }

            }
        }
    }

    private void BottleThrowEvent(PlayerInteractEvent event){
        Player p = event.getPlayer();

                for(String Line : Objects.requireNonNull((p.getInventory().getItemInMainHand().getItemMeta()).getLore())){


                    if(Line.contains("Experience:")){
                        String[] SplitText = Line.split(":");
                        if(Line.startsWith("Experience:")){
                            String level = Line.replace("Experience:", "");
                            level = ChatColor.stripColor(level);
                            p.sendMessage("§f[§aSimpleBottledExp§f]§7: " +ChatColor.GOLD + level  + "§aXP "+ "§7have been added!");
                            p.giveExp(Integer.parseInt(level));
                            if(p.getInventory().getItemInMainHand().getAmount() > 1){
                                p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() -1);
                            }else {
                                p.getInventory().getItemInMainHand().setAmount(0);
                            }

                        }
                    }
                }
            }

        }





