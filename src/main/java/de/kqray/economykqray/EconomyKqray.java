package de.kqray.economykqray;

import de.kqray.economykqray.commands.*;
import de.kqray.economykqray.events.JoinEvent;
import de.kqray.economykqray.events.QuitEvent;
import de.kqray.economykqray.manager.CommandManager;
import de.kqray.economykqray.util.ConfigHandler;
import de.kqray.economykqray.util.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;


public final class EconomyKqray extends JavaPlugin {
    public static EconomyKqray plugin;
    public static Economy economy;
    @Override
    public void onEnable() {
        Economy ec = new Economy();

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
    public static Economy getEcon(){
        return economy;
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
        Objects.requireNonNull(getCommand("money")).setExecutor(new getMoney());
        Objects.requireNonNull(getCommand("addmoney")).setExecutor(new addMoney());
        Objects.requireNonNull(getCommand("setmoney")).setExecutor(new setMoney());
        Objects.requireNonNull(getCommand("removemoney")).setExecutor(new removeMoney());
        Objects.requireNonNull(getCommand("pay")).setExecutor(new payMoney());
    }
}
