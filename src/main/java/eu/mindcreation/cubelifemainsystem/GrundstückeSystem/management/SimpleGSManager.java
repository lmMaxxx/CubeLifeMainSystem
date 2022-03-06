package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.management;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.Direction;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.GSMain;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GS;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GSPlayerManager;
import org.bukkit.entity.Player;

import java.util.ArrayList;
//FÜR CACHE
public class SimpleGSManager implements GSPlayerManager {

    private final ArrayList<GS<?>> gsCache;

    public SimpleGSManager() {
        gsCache = new ArrayList<>();
    }

//    @Override
//    public void registerGS(GS gs) {
//
//    }
//
//    @Override
//    public void removeGS(GS gs) {
//
//    }

    @Override
    public GS<?> getGSByChunk(int chunkX, int chunkZ) {
        for (GS<?> gs : gsCache) {
            if(gs.getChunkX() == chunkX && gs.getChunkZ() == chunkZ) {
                return gs;
            }
        }
        return null;
    }

    @Override
    public GS<?> createChunk(int chunkX, int chunkZ, int costs, Direction direction) {
        if(isClaimed(chunkX, chunkZ)) return null;

        GS<?> gs = new SimpleGs(chunkX, chunkZ, costs, direction);
        gsCache.add(gs);

        return gs;
    }

    @Override
    public GS<?> getGSByPlayer(Player player) {
        if(player == null) return null;
        return GSMain.getConfig().getByPlayer(player);
    }

    @Override
    public void unregister(Player player) {
        GS<?> gs;
        if((gs = getGSByPlayer(player)) != null && gsCache.contains(gs)) {
            gsCache.remove(gs);
        }
    }

    @Override
    public boolean isClaimed(int chunkX, int chunkZ) {
        return GSMain.getConfig().isClaimed(chunkX, chunkZ);
    }
}