package com.richardsearcy.htrtut.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CustomBlock extends Block {

    public CustomBlock(String name, float hardness, float resistance) {

        // Call the Block constructor
        super(Material.ROCK);

        // Set some basic parameters for all blocks
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
    }
}
