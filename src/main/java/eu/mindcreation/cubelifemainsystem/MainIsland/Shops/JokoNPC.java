package eu.mindcreation.cubelifemainsystem.MainIsland.Shops;

import eu.mindcreation.cubelifemainsystem.CubeLifeMainSystem;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class JokoNPC implements Listener {
    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
        Player player = event.getClicker();
        NPC npc = event.getNPC();

        if (npc.getName().contains("Joko")){

            //InvBuild
            Inventory inv = Bukkit.createInventory(null, 3 * 9, "§bJokos Bar");

            //Items Build
            Potion pot1 = new Potion(PotionType.LUCK, 1);
            ItemStack item1 = pot1.toItemStack(1);
            ItemMeta meta1 = item1.getItemMeta();
            meta1.setDisplayName("§6Der Glückssäufer");
            meta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            item1.setItemMeta(meta1);

            ItemStack g = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemMeta gm = g.getItemMeta();
            gm.setDisplayName(" ");
            g.setItemMeta(gm);

            //Items Set
            InvFüller2(inv, g, 1);
            InvFüller2(inv, g, 2);
            InvFüller2(inv, g, 3);

            inv.setItem(13, item1);

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

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if (event.getView().getTitle().equals("§bJokos Bar")){
            event.setCancelled(true);

            if (item.getItemMeta().getDisplayName().equals("§6Der Glückssäufer")){
                if (CubeLifeMainSystem.econ.getBalance(player) > 149){

                    Potion pot1 = new Potion(PotionType.LUCK, 1);
                    ItemStack item1 = pot1.toItemStack(1);
                    ItemMeta meta1 = item1.getItemMeta();
                    meta1.setDisplayName("§6Der Glückssäufer");
                    meta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    item1.setItemMeta(meta1);

                    player.sendMessage("§b§lMindCreation §7| Du hast dir erfolgreich den §6Glückssäufer §7gekauft!");
                    player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
                    CubeLifeMainSystem.econ.withdrawPlayer(player, 150);
                    player.closeInventory();
                    player.getInventory().addItem(item1);
                } else {
                    player.sendMessage("§b§lMindCreation §7| Nicht genug Geld!");
                    player.playSound(player, Sound.ENTITY_VILLAGER_HURT, 100, 0);
                }
            }
        }
    }
}
