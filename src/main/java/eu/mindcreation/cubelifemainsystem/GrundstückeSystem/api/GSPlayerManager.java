package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

public interface GSPlayerManager extends GSManager {

    GS<?> getGSByPlayer(Player player);

    void unregister(Player player);

    boolean isClaimed(int chunkX, int chunkZ);

    default boolean isClaimed(Chunk chunk) {
        return isClaimed(chunk.getX(), chunk.getZ());
    }
}
