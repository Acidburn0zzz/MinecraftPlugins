package com.ullarah.umagic;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.ullarah.umagic.database.SQLConnection;
import com.ullarah.umagic.function.PluginRegisters;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class MagicInit extends JavaPlugin {

    static private Plugin plugin;
    static private WorldGuardPlugin worldGuard;

    static Plugin getPlugin() {
        return plugin;
    }

    private void setPlugin(Plugin plugin) {
        MagicInit.plugin = plugin;
    }

    static WorldGuardPlugin getWorldGuard() {
        return worldGuard;
    }

    private void setWorldGuard(WorldGuardPlugin worldGuard) {
        MagicInit.worldGuard = worldGuard;
    }

    public void onEnable() {

        setPlugin(this);

        PluginManager pluginManager = getServer().getPluginManager();
        Plugin pluginWorldGuard = pluginManager.getPlugin("WorldGuard");

        getConfig().options().copyDefaults(true);
        saveConfig();

        if (pluginWorldGuard != null) {

            setWorldGuard((WorldGuardPlugin) pluginWorldGuard);

            getServer().addRecipe(new MagicRecipe().recipe());

            new PluginRegisters(getPlugin());

            getCommand("hoe").setExecutor(new MagicExecutor());

            new MagicFunctions(true);

            doSQL();

        } else {

            getPlugin().getLogger().log(Level.SEVERE, "WorldGuard plugin not found. Disabling uMagic.");
            pluginManager.disablePlugin(this);

        }

    }

    public void onDisable() {


    }

    private void doSQL() {

        SQLConnection sqlConnection = new SQLConnection(getPlugin(), "metadata", "metadata");

        System.out.println(sqlConnection.getSQLConnection());

        sqlConnection.runStatement("INSERT INTO");

    }

}
