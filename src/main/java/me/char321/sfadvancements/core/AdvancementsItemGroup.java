package me.char321.sfadvancements.core;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import me.char321.sfadvancements.SFAdvancements;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class AdvancementsItemGroup extends FlexItemGroup {

    public static void init(SFAdvancements plugin) {
        if (SFAdvancements.getMainConfig().getConfiguration().getBoolean("add-advancements-to-guide")) {
            new AdvancementsItemGroup().register(plugin);
        }
    }

    public AdvancementsItemGroup() {
        super(
                new NamespacedKey(SFAdvancements.instance(), "advancements"),
                new CustomItemStack(Material.FILLED_MAP, "&9进度"),
                -1);
    }

    @Override
    public boolean isVisible(Player p, PlayerProfile profile, SlimefunGuideMode layout) {
        return true;
    }

    @Override
    public void open(Player p, PlayerProfile profile, SlimefunGuideMode layout) {
        SFAdvancements.getGuiManager().displayGUI(p);
    }
}
