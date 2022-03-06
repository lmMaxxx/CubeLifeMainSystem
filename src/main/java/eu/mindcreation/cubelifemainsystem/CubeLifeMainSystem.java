package eu.mindcreation.cubelifemainsystem;

import eu.mindcreation.cubelifemainsystem.Commands.SpawnCommand;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.commands.GSClaim;
import eu.mindcreation.cubelifemainsystem.GrundstückeSystem.commands.GSSet;
import eu.mindcreation.cubelifemainsystem.Listeners.FirstJoin.SpawnEvent;
import eu.mindcreation.cubelifemainsystem.MainIsland.Shops.JokoNPC;
import eu.mindcreation.cubelifemainsystem.WarpNPCs.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class CubeLifeMainSystem extends JavaPlugin {

    public static Economy econ = null;

    @Override
    public void onEnable() {

        if (!setupEconomy() ) {
            System.err.println(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        //Config GS


        //Listeners


        //SpawnEvent
        Bukkit.getPluginManager().registerEvents(new SpawnEvent(), this);


        //Shops MainIsland
        Bukkit.getPluginManager().registerEvents(new JokoNPC(), this);



        //WarpNPCs
        Bukkit.getPluginManager().registerEvents(new AltariaIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new DomtoriIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new FitensiaIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new MainIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new NoskiIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new Warps(), this);


        //Commands
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setgs").setExecutor(new GSSet());
        getCommand("gsclaim").setExecutor(new GSClaim());
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    @Override
    public void onDisable() {
    }


}
