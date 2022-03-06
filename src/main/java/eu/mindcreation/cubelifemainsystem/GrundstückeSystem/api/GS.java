package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.Direction;

import java.util.ArrayList;
import java.util.UUID;

public interface GS<T> extends ILoader<T> {
    int getChunkX();

    int getChunkZ();

    int getCosts();

    ArrayList<IChunk<?>> getExternalChunks();

    Direction getDirection();

    void setBought();

    boolean isBought();

    UUID getOwner();

    void setOwner(UUID uuid);
}
