package com.richardsearcy.htrtut.init.blocks.fence;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;

public class CustomBlockFence extends BlockFence {

    public CustomBlockFence(String name, float hardness, float resistance) {

        super(Material.IRON, Material.IRON.getMaterialMapColor());

        setUnlocalizedName(name);
        setRegistryName(name);
        setResistance(resistance);
        setHardness(hardness);
        this.useNeighborBrightness = true;
    }
}
