package eu.mindcreation.cubelifemainsystem.GrundstückeSystem;


import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.ChunkConfig;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GSPlayerManager;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.management.ChunkLoaderManagement;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.management.SimpleGSManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

public class GSMain {

    public static World mainWorld;

    private static ChunkConfig config;
    private static GSPlayerManager playerManager;

    public static void onEnable(Plugin plugin) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            mainWorld = Bukkit.getWorld("");

            playerManager = new SimpleGSManager();
            config = new ChunkLoaderManagement();
        });
    }

    public static ChunkConfig getConfig() {
        return config;
    }

    public static GSPlayerManager getPlayerManager() {
        return playerManager;
    }
}