package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api;

import org.bukkit.configuration.file.YamlConfiguration;

public interface ILoader {
    GS load(YamlConfiguration config, String path);

    void save(YamlConfiguration config, String path);
}