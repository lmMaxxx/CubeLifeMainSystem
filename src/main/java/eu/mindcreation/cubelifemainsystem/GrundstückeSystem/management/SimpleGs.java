package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.management;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.Direction;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.GSMain;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GS;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.IChunk;
import org.bukkit.Chunk;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class SimpleGs implements GS {

    private final int chunkX;
    private final int chunkZ;

    private int costs;
    private Direction direction;

    private boolean bought;
    private UUID owner;

    private ArrayList<IChunk> externalChunks = new ArrayList<>(9);

    public SimpleGs(int chunkX, int chunkZ, int costs, Direction direction) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.costs = costs;
        this.direction = direction;

        setup();
    }

    public SimpleGs(Chunk chunk, int cots, Direction direction) {
        this(chunk.getX(), chunk.getZ(), cots, direction);
    }

    private void setup() {

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
    public int getCosts() {
        return costs;
    }

    @Override
    public ArrayList<IChunk> getExternalChunks() {
        return externalChunks;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setBought() {
        this.bought = true;
    }

    @Override
    public boolean isBought() {
        return bought;
    }

    @Override
    public UUID getOwner() {
        return owner;
    }

    @Override
    public GS load(YamlConfiguration config, String path) {
        costs = config.getInt(path + ".costs");
        direction = Direction.valueOf(config.getString(path + ".direction"));
        bought = config.getBoolean(path + ".bought");

        if(bought)
            owner = UUID.fromString(Objects.requireNonNull(config.getString(path + ".owner")));

        getExternalChunks().forEach(e -> e.load(config, path));

        setup();
        return this;
    }

    @Override
    public void save(YamlConfiguration config, String path) {
        String newPath = path + chunkX + ":" + chunkZ;
        config.set(newPath + ".costs", costs);
        config.set(newPath + ".direction", direction.name());
        config.set(newPath + ".bought", bought);

        if(bought)
            config.set(newPath + ".owner", owner.toString());

        getExternalChunks().forEach(e -> e.save(config, newPath));
    }
}