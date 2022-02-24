package eu.mindcreation.cubelifemainsystem.Listeners.FirstJoin;

import eu.mindcreation.cubelifemainsystem.CubeLifeMainSystem;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location spawn = Bukkit.getWorld("cubelife").getSpawnLocation().add(0.5,0,0.5);
        World spawnworld = Bukkit.getWorld("cubelife");
        event.setJoinMessage(null);

        if (!player.hasPlayedBefore()){
            player.teleport(spawn);
            player.sendMessage("§b§lMindCreation §7| Herzlich Willkommen auf CubeLife §b" + player.getName() + "§7!");
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);

            new BukkitRunnable() {
                public void run() {
                    if (player.getWorld() != spawnworld){
                        player.teleport(spawn);
                    }
                }
            }.runTaskLater(CubeLifeMainSystem.getPlugin(CubeLifeMainSystem.class), 20);
        } else {
            player.sendMessage("§b§lMindCreation §7| Herzlich Willkommen zurück auf CubeLife §b" + player.getName() + "§7!");
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
        }
    }
}
