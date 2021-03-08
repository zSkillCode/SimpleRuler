package net.skillcode.simpleruler.commands;

import net.skillcode.simpleruler.constants.Constants;
import net.skillcode.simpleruler.utils.ItemUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RulerCommand implements CommandExecutor {

    private final JavaPlugin javaPlugin;
    private final ItemUtils itemUtils;

    public RulerCommand(final JavaPlugin javaPlugin, final ItemUtils itemUtils) {
        this.javaPlugin = javaPlugin;
        this.itemUtils = itemUtils;
    }

    @Override
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
        if (!(commandSender instanceof Player)) return true;

        final Player player = (Player) commandSender;

        if (!player.hasPermission(Constants.COMMAND_PERMISSION)) {
            player.sendMessage(javaPlugin.getServer().getPluginCommand("ban").getPermissionMessage());
            return true;
        }

        player.getInventory().addItem(itemUtils.getRuler());
        player.sendMessage(Constants.RULER_GIVEN);

        return false;
    }
}
