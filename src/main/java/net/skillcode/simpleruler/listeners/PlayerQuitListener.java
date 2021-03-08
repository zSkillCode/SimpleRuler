package net.skillcode.simpleruler.listeners;

import net.skillcode.simpleruler.utils.RulerUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerQuitListener implements Listener {

    private final RulerUtils rulerUtils;

    public PlayerQuitListener(final RulerUtils rulerUtils) {
        this.rulerUtils = rulerUtils;
    }

    @EventHandler
    public void onQuit(@NotNull final PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        rulerUtils.unregister(player);
    }
}
