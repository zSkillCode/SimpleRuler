package net.skillcode.simpleruler;

import net.skillcode.simpleruler.commands.RulerCommand;
import net.skillcode.simpleruler.listeners.PlayerInteractListener;
import net.skillcode.simpleruler.listeners.PlayerQuitListener;
import net.skillcode.simpleruler.utils.ItemUtils;
import net.skillcode.simpleruler.utils.RulerUtils;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleRuler extends JavaPlugin {

    private ItemUtils itemUtils;
    private RulerUtils rulerUtils;

    @Override
    public void onEnable() {
        itemUtils = new ItemUtils().init();
        rulerUtils = new RulerUtils();

        registerListeners();
        registerCommands();
    }

    private void registerListeners() {
        final PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerInteractListener(rulerUtils), this);
        pluginManager.registerEvents(new PlayerQuitListener(rulerUtils), this);
    }

    private void registerCommands() {
        getCommand("ruler").setExecutor(new RulerCommand(this, itemUtils));
    }
}
