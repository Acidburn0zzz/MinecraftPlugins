package com.ullarah.umagic.block;

import com.ullarah.umagic.MagicFunctions;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Bedrock extends MagicFunctions {

    public Bedrock(Block block, Player player) {

        super(false);

        if (block.hasMetadata(metaEmBr)) {

            getCommonString().messageSend(player, "Block converted to Barrier. Be careful!");

            block.setType(Material.BARRIER);

        }

    }

}
