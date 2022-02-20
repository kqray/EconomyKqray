package de.kqray.economykqray.util;

import de.kqray.economykqray.EconomyKqray;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler {
    public FileConfiguration getConfig() {
        return EconomyKqray.plugin.getConfig();
    }
    public void setStr(String path, String value){
        EconomyKqray.plugin.getConfig().set(path, value);
    }

    public void setInt(String path, int value) {
        EconomyKqray.plugin.getConfig().set(path, value);
    }

    public String getString(String path) {
        return EconomyKqray.plugin.getConfig().getString(path);
    }

    public int getInt(String path) {
        return EconomyKqray.plugin.getConfig().getInt(path);
    }

    public boolean getBoolean(String path) {
        return EconomyKqray.plugin.getConfig().getBoolean(path);
    }

    public void createSec(String path) {
        EconomyKqray.plugin.getConfig().createSection(path);
    }

    public void get(String path) {
        EconomyKqray.plugin.getConfig().get(path);
    }

    public void save() {
        EconomyKqray.plugin.saveConfig();
        EconomyKqray.plugin.saveDefaultConfig();
    }
}
