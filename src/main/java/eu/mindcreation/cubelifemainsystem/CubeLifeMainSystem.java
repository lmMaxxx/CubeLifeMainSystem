package eu.mindcreation.cubelifemainsystem;

import eu.mindcreation.cubelifemainsystem.Commands.SpawnCommand;
import eu.mindcreation.cubelifemainsystem.Listeners.FirstJoin.SpawnEvent;
import eu.mindcreation.cubelifemainsystem.WarpNPCs.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CubeLifeMainSystem extends JavaPlugin {

    @Override
    public void onEnable() {

        //Listeners

        //SpawnEvent
        Bukkit.getPluginManager().registerEvents(new SpawnEvent(), this);

        //WarpNPCs
        Bukkit.getPluginManager().registerEvents(new AltariaIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new DomtoriIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new FitensiaIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new MainIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new NoskiIslandNPC(), this);
        Bukkit.getPluginManager().registerEvents(new Warps(), this);

        //Commands
        this.getCommand("spawn").setExecutor(new SpawnCommand());

    }

    @Override
    public void onDisable() {
    }
}
