package eu.mindcreation.cubelifemainsystem.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Location spawn = Bukkit.getWorld("cubelife").getSpawnLocation().add(0.5,0,0.5);

        player.teleport(spawn);
        player.sendMessage("§b§lMindCreation §7| Du bist nun am §bSpawn§7!");
        player.playSound(spawn, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);

        return true;
    }
}
