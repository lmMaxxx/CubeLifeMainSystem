package eu.mindcreation.cubelifemainsystem.WarpNPCs;

import eu.mindcreation.cubelifemainsystem.CubeLifeMainSystem;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class MainIslandNPC implements Listener {

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
        Player player = event.getClicker();
        NPC npc = event.getNPC();

        if (npc.getName().contains("§bJamatais")){

            //InvBuild
            Inventory inv = Bukkit.createInventory(null, 3 * 9, "§bJamatais Reiseführer");

            //Items Build

            ItemStack item1 = new ItemStack(Material.SNOWBALL, 1);
            ItemMeta meta1 = item1.getItemMeta();
            meta1.setDisplayName("§bAltaria");
            meta1.setLore(Arrays.asList("§b§oRechtsklick = Teleport zum Hafen Altarias"));
            item1.setItemMeta(meta1);

            ItemStack item2 = new ItemStack(Material.SLIME_BALL, 1);
            ItemMeta meta2 = item2.getItemMeta();
            meta2.setDisplayName("§bNoski");
            meta2.setLore(Arrays.asList("§b§oRechtsklick = Teleport zum Hafen Noskis"));
            item2.setItemMeta(meta2);

            ItemStack item3 = new ItemStack(Material.GLOWSTONE_DUST, 1);
            ItemMeta meta3 = item3.getItemMeta();
            meta3.setDisplayName("§bDomtoris");
            meta3.setLore(Arrays.asList("§b§oRechtsklick = Teleport zum Hafen Domtoris"));
            item3.setItemMeta(meta3);

            ItemStack item4 = new ItemStack(Material.SUNFLOWER, 1);
            ItemMeta meta4 = item4.getItemMeta();
            meta4.setDisplayName("§bFitensia");
            meta4.setLore(Arrays.asList("§b§oRechtsklick = Teleport zum Hafen Fitensia"));
            item4.setItemMeta(meta4);

            ItemStack item5 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemMeta meta5 = item5.getItemMeta();
            meta5.setDisplayName(" ");
            item5.setItemMeta(meta5);

            //ItemsSet
            InvFüller2(inv, item5, 1);
            InvFüller2(inv, item5, 2);
            InvFüller2(inv, item5, 3);

            inv.setItem(10, item1);
            inv.setItem(12, item3);
            inv.setItem(14, item4);
            inv.setItem(16, item2);

            //InvOpen
            player.openInventory(inv);

        }
    }

    public static Inventory InvFüller2(Inventory inv, ItemStack item, int Reihe) {
        for (int j = 0; j < 9; j++) {
            int a = (Reihe - 1) * 9 + j;
            if(inv.getItem(a) == null)
                inv.setItem(a, item);
        }

        return inv;
    }

}
