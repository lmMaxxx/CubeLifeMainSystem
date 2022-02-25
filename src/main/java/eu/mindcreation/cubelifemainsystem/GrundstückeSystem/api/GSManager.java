package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.Direction;
import org.bukkit.Chunk;

public interface GSManager {

//    void registerGS(GS gs);
//
//    void removeGS(GS gs);

    GS getGSByChunk(int chunkX, int chunkZ);

    GS createChunk(int chunkX, int chunkZ, int costs, Direction direction);

    default GS createChunk(Chunk chunk, int costs, Direction direction) {
        return createChunk(chunk.getX(), chunk.getZ(), costs, direction);
    }
}