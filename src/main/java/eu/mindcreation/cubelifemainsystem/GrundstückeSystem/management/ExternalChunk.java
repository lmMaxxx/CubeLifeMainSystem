package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.management;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GS;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.IChunk;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nonnull;

public class ExternalChunk implements IChunk<ExternalChunk> {

    private final GS<?> mainGS;
    private int chunkX;
    private int chunkZ;

    public ExternalChunk(GS<?> mainGS, int chunkX, int chunkZ) {
        this.mainGS = mainGS;
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    @Nonnull
    @Override
    public GS<?> getMainGS() {
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

    @Override
    public ExternalChunk load(YamlConfiguration config, String path) {
        this.chunkX = config.getInt(path + ".x");
        this.chunkZ = config.getInt(path + ".z");

        return this;
    }

    @Override
    public void save(YamlConfiguration config, String path) {
        config.set(path + ".x", chunkX);
        config.set(path + ".z", chunkZ);
    }
}
