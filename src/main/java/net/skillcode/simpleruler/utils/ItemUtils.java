package net.skillcode.simpleruler.utils;

import net.skillcode.simpleruler.constants.Constants;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

    private ItemStack ruler = null;

    public ItemUtils init() {
        ruler = new ItemStack(Material.STICK);

        final ItemMeta itemMeta = ruler.getItemMeta();

        itemMeta.setDisplayName(Constants.RULER_ITEM_NAME);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addEnchant(Enchantment.LUCK, 1, true);

        ruler.setItemMeta(itemMeta);

        return this;
    }

    public ItemStack getRuler() {
        return ruler;
    }

}
