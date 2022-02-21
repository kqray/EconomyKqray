package de.kqray.economykqray;

import de.kqray.economykqray.commands.*;
import de.kqray.economykqray.events.JoinEvent;
import de.kqray.economykqray.events.QuitEvent;
import de.kqray.economykqray.manager.CommandManager;
import de.kqray.economykqray.util.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;


public final class EconomyKqray extends JavaPlugin {
    public static EconomyKqray plugin;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY +"--------------------");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY +"--------------------");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN +"Plugin: EconomyKqray Enabled");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY +"--------------------");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY +"--------------------");
        ConfigHandler c = new ConfigHandler();
        plugin = this;
        commandRegister();
        eventRegister();
        loadConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadConfig() {
        saveDefaultConfig();
        saveConfig();
        CommandManager cm = new CommandManager();

    }

    public void eventRegister() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinEvent(), this);
        manager.registerEvents(new QuitEvent(), this);
    }

    private void commandRegister() {
        getCommand("money").setExecutor(new getMoney());
        getCommand("addmoney").setExecutor(new addMoney());
        getCommand("setmoney").setExecutor(new setMoney());
        getCommand("removemoney").setExecutor(new removeMoney());
        getCommand("pay").setExecutor(new payMoney());
    }
}
