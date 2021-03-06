package com.ullarah.umagic.event;

import com.ullarah.umagic.MagicFunctions;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class BlockFade extends MagicFunctions implements Listener {

    public BlockFade() {
        super(false);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void event(BlockFadeEvent event) {

        for (String meta : new String[]{metaFire, metaCice})
            if (event.getBlock().hasMetadata(meta)) event.setCancelled(true);

    }

}
