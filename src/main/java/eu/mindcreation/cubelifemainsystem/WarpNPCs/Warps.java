package eu.mindcreation.cubelifemainsystem.WarpNPCs;

import eu.mindcreation.cubelifemainsystem.CubeLifeMainSystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class Warps implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Location jamatai = Bukkit.getWorld("cubelife").getBlockAt(-98, 64, 465).getLocation().add(0.5, 0.5, 0.5);
        jamatai.setYaw(-190);
        jamatai.setPitch(-2);

        Location altaria = Bukkit.getWorld("cubelife").getBlockAt(479, 77, 188).getLocation().add(0.5, 0, 0.5);
        altaria.setYaw(134);
        altaria.setPitch(2);

        Location domtoris = Bukkit.getWorld("cubelife").getBlockAt(-980, 77, 668).getLocation().add(0.5, 0, 0.5);
        domtoris.setYaw(-134);
        domtoris.setPitch(2);

        Location fitensia = Bukkit.getWorld("cubelife").getBlockAt(-1035, 73, -731).getLocation().add(0.5, 0, 0.5);
        fitensia.setYaw(-136);
        fitensia.setPitch(3);

        Location noski = Bukkit.getWorld("cubelife").getBlockAt(182, 69, 1050).getLocation().add(0.5, 0, 0.5);
        noski.setYaw(135);
        noski.setPitch(1);

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if (event.getView().getTitle().contains("Reiseführer")){
            event.setCancelled(true);

            if (item.getItemMeta().getDisplayName().equals("§bJamatai")){
                player.sendMessage("§b§lMindCreation §7| Teleportiere...");
                player.playSound(player, Sound.ENTITY_ENDER_PEARL_THROW, 100, 0);
                player.closeInventory();
                jamatai.getChunk().load();

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.teleport(jamatai);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
                        player.sendMessage("§b§lMindCreation §7| Du wurdest nach §bJamatai §7gebracht!");
                    }
                }.runTaskLater(CubeLifeMainSystem.getPlugin(CubeLifeMainSystem.class), 60);
            }

            if (item.getItemMeta().getDisplayName().equals("§bAltaria")){
                player.sendMessage("§b§lMindCreation §7| Teleportiere...");
                player.playSound(player, Sound.ENTITY_ENDER_PEARL_THROW, 100, 0);
                player.closeInventory();
                altaria.getChunk().load();

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.teleport(altaria);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
                        player.sendMessage("§b§lMindCreation §7| Du wurdest nach §bAltaria §7gebracht!");
                    }
                }.runTaskLater(CubeLifeMainSystem.getPlugin(CubeLifeMainSystem.class), 60);
            }

            if (item.getItemMeta().getDisplayName().equals("§bDomtoris")){
                player.sendMessage("§b§lMindCreation §7| Teleportiere...");
                player.playSound(player, Sound.ENTITY_ENDER_PEARL_THROW, 100, 0);
                player.closeInventory();
                domtoris.getChunk().load();

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.teleport(domtoris);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
                        player.sendMessage("§b§lMindCreation §7| Du wurdest nach §bDomtoris §7gebracht!");
                    }
                }.runTaskLater(CubeLifeMainSystem.getPlugin(CubeLifeMainSystem.class), 60);
            }

            if (item.getItemMeta().getDisplayName().equals("§bFitensia")){
                player.sendMessage("§b§lMindCreation §7| Teleportiere...");
                player.playSound(player, Sound.ENTITY_ENDER_PEARL_THROW, 100, 0);
                player.closeInventory();
                fitensia.getChunk().load();

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.teleport(fitensia);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
                        player.sendMessage("§b§lMindCreation §7| Du wurdest nach §bFintensia §7gebracht!");
                    }
                }.runTaskLater(CubeLifeMainSystem.getPlugin(CubeLifeMainSystem.class), 60);
            }

            if (item.getItemMeta().getDisplayName().equals("§bNoski")){
                player.sendMessage("§b§lMindCreation §7| Teleportiere...");
                player.playSound(player, Sound.ENTITY_ENDER_PEARL_THROW, 100, 0);
                player.closeInventory();
                noski.getChunk().load();

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.teleport(noski);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
                        player.sendMessage("§b§lMindCreation §7| Du wurdest nach §bNoski §7gebracht!");
                    }
                }.runTaskLater(CubeLifeMainSystem.getPlugin(CubeLifeMainSystem.class), 60);
            }
        }
    }
}
