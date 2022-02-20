package de.kqray.economykqray.util;

import de.kqray.economykqray.EconomyKqray;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigHandler {
    File f = new File("plugins/EconomyKqray", "config.yml");
    public FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);

    public void setStr(String path, String value){
        cfg.set(path, value);
    }

    public void setInt(String path, int value) {
        cfg.set(path, value);
    }

    public String getString(String path) {
        return cfg.getString(path);
    }

    public int getInt(String path) {
        return cfg.getInt(path);
    }

    public boolean getBoolean(String path) {
        return cfg.getBoolean(path);
    }

    public void createSec(String path) {
        cfg.createSection(path);
    }

    public void get(String path) {
        cfg.get(path);
    }

    public void save() throws IOException {
        cfg.save(f);
    }
}
