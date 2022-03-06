package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.commands;

import eu.mindcreation.cubelifemainsystem.CubeLifeMainSystem;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.GSMain;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GS;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GSClaim implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage("§cBitte benutzte: /claim confirm um ein GS zu claimen!");
                return false;
            }

            if(args[0].equalsIgnoreCase("confirm")) {
                Chunk chunk = player.getLocation().getChunk();

                if(GSMain.getConfig().isClaimed(chunk.getX(), chunk.getZ()) || GSMain.getConfig().isClaimedByPlayer(chunk.getX(), chunk.getZ())) {
                    player.sendMessage("§cDieser Chunk wurde schon geclaimt!");
                    return false;
                }

                GS<?> gs = GSMain.getConfig().loadChunk(chunk);
                if (CubeLifeMainSystem.econ.getBalance(player) > gs.getCosts()) {
                    CubeLifeMainSystem.econ.withdrawPlayer(player, gs.getCosts());

                    GSMain.getConfig().claimGS(gs, player);

                    player.sendMessage("§cDu hast dieses GS Geclaimt!");
                } else {
                    player.sendMessage("§cDu hast nicht genügend Geld um dieses GS zu kaufen!");
                }
            } else {
                player.sendMessage("§cBitte benutzte: /claim confirm um ein GS zu claimen!");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("§cDieser Command kann nur ein Spieler ausfuahren!");
        }
        return false;
    }
}