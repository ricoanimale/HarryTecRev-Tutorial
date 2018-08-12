package com.richardsearcy.htrtut.init.blocks;

import net.minecraft.block.Block;

public class CustomOre extends CustomBlock {

    public CustomOre(String name, float hardness, float resistance, int harvestLevel) {

        // Call the CustomBlock constructor
        super(name, hardness, resistance);

        // Set the harvest level for the custom ore
        setHarvestLevel("pickaxe", harvestLevel);
    }
}
