package de.kqray.economykqray.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CommandManager {
    private final File f = new File("plugins/EconomyKqray", "CommandsManagement.yml");
    private final FileConfiguration cm = YamlConfiguration.loadConfiguration(f);

    public FileConfiguration getCm() {
        return cm;
    }
    public void save() throws IOException {
        cm.save(f);
    }
}
