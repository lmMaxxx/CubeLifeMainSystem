package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.management;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GS;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.IChunk;

import javax.annotation.Nonnull;

public class ExternalChunk implements IChunk {

    private final GS mainGS;
    private final int chunkX;
    private final int chunkZ;

    public ExternalChunk(GS mainGS, int chunkX, int chunkZ) {
        this.mainGS = mainGS;
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    @Nonnull
    @Override
    public GS getMainGS() {
        return mainGS;
    }

    @Override
    public int getChunkX() {
        return chunkX;
    }

    @Override
    public int getChunkZ() {
        return chunkZ;
    }
}
