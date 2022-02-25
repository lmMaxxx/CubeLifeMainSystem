package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.management;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.ChunkConfig;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GS;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class ChunkLoaderManagment implements ChunkConfig {

    private final File file = new File("plugins/cubelife/chunks.yml");
    private final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    @Override
    public GS loadChunk(int chunkX, int chunkZ) {
        String path = chunkX + ":" + chunkZ;

        if(yamlConfiguration.get(path) != null) {
            GS gs = new SimpleGs(chunkX, chunkZ, -1, null);

            gs = gs.load(yamlConfiguration, path);
            return gs;
        }

        return null;
    }

    @Override
    public void saveChunk(GS gs) {
        gs.save(yamlConfiguration, "");

        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GS getByPlayer(Player player) {
        for(String x : yamlConfiguration.getKeys(false)) {
            ConfigurationSection conf = yamlConfiguration.getConfigurationSection(x);

            if(conf == null) continue;
            if(conf.get("bought") != null && conf.getBoolean("bought") && conf.getString("owner").equals(player.getUniqueId().toString())) {
                return loadChunk(x);
            }
        }
        return null;
    }

    @Override
    public boolean isClaimed(int chunkX, int chunkZ) {
        return yamlConfiguration.get(chunkX + ":" + chunkX) != null;
    }

    private GS loadChunk(String x) {
        String[] split = x.split(":");
        return loadChunk(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}