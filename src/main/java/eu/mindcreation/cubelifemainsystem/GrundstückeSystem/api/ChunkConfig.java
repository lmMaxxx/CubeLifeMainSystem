package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.Consumer;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

public interface ChunkConfig {
    GS loadChunk(int chunkX, int chunkZ);

    void saveChunk(GS gs);

    GS getByPlayer(Player player);

    default GS loadChunk(Chunk chunk) {
        return loadChunk(chunk.getX(), chunk.getZ());
    }

    boolean isClaimed(int chunkX, int chunkZ);
}