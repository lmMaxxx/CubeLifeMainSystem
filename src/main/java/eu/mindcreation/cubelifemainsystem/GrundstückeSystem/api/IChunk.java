package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api;

import javax.annotation.Nonnull;

public interface IChunk extends ILoader {

    @Nonnull
    GS getMainGS();

    int getChunkX();

    int getChunkZ();

}
