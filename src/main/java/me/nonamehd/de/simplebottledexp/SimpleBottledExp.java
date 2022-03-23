package me.nonamehd.de.simplebottledexp;

import me.nonamehd.de.simplebottledexp.commands.BottleCommand;
import me.nonamehd.de.simplebottledexp.listeners.CustomExperienceGUIListener;
import me.nonamehd.de.simplebottledexp.listeners.ExperienceBottleListener;
import me.nonamehd.de.simplebottledexp.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SimpleBottledExp extends JavaPlugin {

public static boolean PermissionsEnabled;
public static boolean BottlePermissionsEnabled;
public static boolean GUIPermissionsEnabled;

FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        saveDefaultConfig();


        if(getConfig().getBoolean("permissionsneeded"))
        {
            PermissionsEnabled = true;

            if(getConfig().getBoolean("bottleusepermissionenabled")){
                BottlePermissionsEnabled = true;
            }else{
                getLogger().info("BottleUsePermissionEnabled:" + getConfig().getString("bottleusepermissionenabled"));
                BottlePermissionsEnabled = false;
            }
            if(getConfig().getBoolean("bottledexpguipermissionenabled")){
                GUIPermissionsEnabled = true;
            }else{
                GUIPermissionsEnabled = false;
                getLogger().info("GuiUsePermission enabled:" + getConfig().getString("bottledexpguipermissionenabled"));
            }
            getLogger().info(getConfig().getString("Permissions enabled:"+"permissionsneeded"));
        }else {
            getLogger().info(getConfig().getString("Permissions enabled:"+"permissionsneeded"));
            PermissionsEnabled = false;
        }






        System.out.println("[SimpledBottledExp] has been started");
        Objects.requireNonNull(getCommand("expbottle")).setExecutor(new BottleCommand());

        Bukkit.getPluginManager().registerEvents(new InventoryListener(),this);
        Bukkit.getPluginManager().registerEvents(new CustomExperienceGUIListener(),this);
        Bukkit.getPluginManager().registerEvents(new ExperienceBottleListener(),this);
    }

    @Override
    public void onDisable() {
        System.out.println("[SimpledBottledExp] has been stopped");
    }
}
