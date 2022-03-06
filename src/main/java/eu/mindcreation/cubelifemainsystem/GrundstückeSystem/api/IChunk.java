package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api;

import javax.annotation.Nonnull;

public interface IChunk<T> extends ILoader<T> {

    @Nonnull
    GS<?> getMainGS();

    int getChunkX();

    int getChunkZ();
}
