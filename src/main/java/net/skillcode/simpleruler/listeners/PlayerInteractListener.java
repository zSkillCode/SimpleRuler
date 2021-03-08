package net.skillcode.simpleruler.listeners;

import net.skillcode.simpleruler.constants.Constants;
import net.skillcode.simpleruler.utils.RulerUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerInteractListener implements Listener {

    private final RulerUtils rulerUtils;

    public PlayerInteractListener(final RulerUtils rulerUtils) {
        this.rulerUtils = rulerUtils;
    }

    @EventHandler
    public void onInteract(@NotNull final PlayerInteractEvent event) {
        final Player player = event.getPlayer();

        if (player.getItemInHand() != null
                && player.getItemInHand().getItemMeta() != null
                && player.getItemInHand().getItemMeta().getDisplayName() != null
                && player.getItemInHand().getItemMeta().getDisplayName().equals(Constants.RULER_ITEM_NAME)
                && event.getClickedBlock() != null
                && !event.getClickedBlock().getType().equals(Material.AIR)) {

            if (!player.hasPermission(Constants.USE_PERMISSION)) {
                player.sendMessage(Constants.NO_PERMISSION);
                return;
            }

            rulerUtils.handle(player, event.getClickedBlock().getLocation());

        }
    }

}
