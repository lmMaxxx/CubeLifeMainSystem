package eu.mindcreation.cubelifemainsystem.GrundstückeSystem.commands;

import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.Direction;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.GSMain;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.api.GS;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GSSet implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("cubelife.setchunk")) {
                if(args.length == 0) {
                    player.sendMessage("§cBitte benutzte: /setchunk <Costs>");
                    return false;
                }


                if(!isInt(args[0])) {
                    player.sendMessage("§cBitte gebe einen Richtigen Wert ein!");
                    return false;
                }

                int costs = 0;
                Direction direction = Direction.getDirectionByYaw(player.getLocation().getYaw());
                Chunk chunk = player.getLocation().getChunk();

                if(direction == Direction.UNKNOWN) {
                    player.sendMessage("§cBitte schaue ihn eine Richtige Richtung!");
                    return false;
                }

                if(!GSMain.getPlayerManager().isClaimed(chunk)) {
                    GS gs = GSMain.getPlayerManager().createChunk(chunk, costs, direction);
                    if(gs == null) {
                        player.sendMessage("§cEtwas ist schiefgelaufen...");
                        return false;
                    }



                } else {
                    player.sendMessage("§cDieser Chunk ist schon geclaimt!");
                }
            } else {
                player.sendMessage("§cDu hast dazu keine Rechte!");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("§cDieser Command kann nur ein Spieler ausfuahren!");
        }
        return true;
    }

    public static boolean isInt(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
