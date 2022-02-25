package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.Direction;

import java.util.ArrayList;
import java.util.UUID;

public interface GS extends ILoader {
    int getChunkX();

    int getChunkZ();

    int getCosts();

    ArrayList<IChunk> getExternalChunks();

    Direction getDirection();

    void setBought();

    boolean isBought();

    UUID getOwner();
}
