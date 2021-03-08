package net.skillcode.simpleruler.utils;

import net.skillcode.simpleruler.constants.Constants;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RulerUtils {

    private final Map<Player, Location> locations = new ConcurrentHashMap<>();

    public void handle(@NotNull final Player player, @NotNull final Location clickedLocation) {
        if (!locations.containsKey(player)) {
            locations.put(player, clickedLocation);

            player.sendMessage(String.format(Constants.POSITION_SET, 1, getLocationAsString(clickedLocation)));
        } else {
            final Location pos1 = locations.get(player);

            unregister(player);

            final DecimalFormat decimalFormat = new DecimalFormat("##.00");

            final double distance = pos1.distance(clickedLocation);

            player.sendMessage(String.format(Constants.POSITION_SET, 2, getLocationAsString(clickedLocation)));
            player.sendMessage(String.format(Constants.DISTANCE, decimalFormat.format(distance)));
        }
    }

    public void unregister(@NotNull final Player player) {
        if (locations.containsKey(player)) {
            locations.remove(player);
        }
    }

    private String getLocationAsString(@NotNull final Location location) {
        final StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder
                .append(location.getX())
                .append(", ")
                .append(location.getY())
                .append(", ")
                .append(location.getZ())
                .append("]");

        return stringBuilder.toString();
    }

}
