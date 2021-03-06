package com.richardsearcy.htrtut.init;

import com.richardsearcy.htrtut.Main;
import com.richardsearcy.htrtut.init.blocks.trees.CustomBlockLeaves;
import com.richardsearcy.htrtut.init.blocks.trees.CustomBlockLog;
import com.richardsearcy.htrtut.init.blocks.trees.CustomBlockPlanks;
import com.richardsearcy.htrtut.init.blocks.CustomBlockStairs;
import com.richardsearcy.htrtut.init.blocks.CustomIngotBlock;
import com.richardsearcy.htrtut.init.blocks.CustomOre;
import com.richardsearcy.htrtut.init.blocks.activators.CustomBlockButton;
import com.richardsearcy.htrtut.init.blocks.activators.CustomBlockPressurePlate;
import com.richardsearcy.htrtut.init.blocks.fence.CustomBlockFence;
import com.richardsearcy.htrtut.init.blocks.fence.CustomBlockFenceGate;
import com.richardsearcy.htrtut.init.blocks.item.ItemBlockVariants;
import com.richardsearcy.htrtut.init.blocks.slab.CustomBlockDoubleSlab;
import com.richardsearcy.htrtut.init.blocks.slab.CustomBlockHalfSlab;
import com.richardsearcy.htrtut.init.blocks.trees.CustomBlockSapling;
import com.richardsearcy.htrtut.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit {

    // Create a new block named tutorial_ore
    public static Block tutorial_ore, tutorial_ore_nether, tutorial_ore_end;

    // Create a new block named tutorial_block
    public static Block tutorial_block;

    // Create a custom stair block
    public static Block tutorial_stairs;

    // Custom slabs
    public static CustomBlockHalfSlab tutorial_slab_half;
    public static CustomBlockDoubleSlab tutorial_slab_double;

    // Custom fence and gate
    public static CustomBlockFence tutorial_fence;
    public static CustomBlockFenceGate tutorial_fence_gate;

    // Custom button and pressure plate
    public static CustomBlockButton tutorial_button;
    public static CustomBlockPressurePlate tutorial_pressure_plate;

    // Planks, leaves, logs and saplings
    public static Block planks, leaves, log, sapling;

    public static void init() {

        // Initialize the new block tutorial_ore
        tutorial_ore = new CustomOre("tutorial_ore", 2.0F, 4.0F, 2);
        tutorial_ore_nether = new CustomOre("tutorial_ore_nether", 2.0F, 4.0F, 2);
        tutorial_ore_end = new CustomOre("tutorial_ore_end", 2.0F, 4.0F, 2);

        // Initialize the new block tutorial_block
        tutorial_block = new CustomIngotBlock("tutorial_block", 2.5F, 4.5F, 2);

        // Initialize the new custom block tutorial stairs
        tutorial_stairs = new CustomBlockStairs("tutorial_stairs", tutorial_block.getDefaultState());

        // Initialize the custom slabs
        tutorial_slab_half = new CustomBlockHalfSlab("tutorial_slab_half");
        tutorial_slab_double = new CustomBlockDoubleSlab("tutorial_slab_double");

        // Initialize the custom fence and gate
        tutorial_fence = new CustomBlockFence("tutorial_fence", 2.5F, 4.5F);
        tutorial_fence_gate = new CustomBlockFenceGate("tutorial_fence_gate", 2.5F, 4.5F);

        // Initialize the custom button and pressure plate
        tutorial_button = new CustomBlockButton("tutorial_button", 2.5F, 4.5F);
        tutorial_pressure_plate = new CustomBlockPressurePlate("tutorial_pressure_plate", 2.5F, 4.5F);

        // Initialize the custom planks, leaves, logs and saplings
        planks = new CustomBlockPlanks("planks");
        log = new CustomBlockLog("log");
        leaves = new CustomBlockLeaves("leaves");
        sapling = new CustomBlockSapling("sapling");

    }

    public static void register() {

        // Call the registerBlock method to register tutorial_ore
        registerBlock(tutorial_ore);
        registerBlock(tutorial_ore_nether);
        registerBlock(tutorial_ore_end);

        // Call the registerBlock method to register the tutorial_block
        registerBlock(tutorial_block);

        // Call the registerBlock method to register the tutorial_stairs
        registerBlock(tutorial_stairs);

        // Call the registerBlock method to register the slabs
        registerBlock(tutorial_slab_half, new ItemSlab(tutorial_slab_half, tutorial_slab_half, tutorial_slab_double));
        ForgeRegistries.BLOCKS.register(tutorial_slab_double);

        // Call the registerBlock method to register the fence and gate
        registerBlock(tutorial_fence);
        registerBlock(tutorial_fence_gate);

        // Call the registerBlock method to register the button and pressure plate
        registerBlock(tutorial_button);
        registerBlock(tutorial_pressure_plate);

        // Call the registerBlockWithVariants(Block block, ItemBlock itemBlock) method to register the custom planks, leaves,logs and sapling.
        registerBlockWithVariants(planks, new ItemBlockVariants(planks));
        registerBlockWithVariants(log, new ItemBlockVariants(log));
        registerBlockWithVariants(leaves, new ItemBlockVariants(leaves));
        registerBlockWithVariants(sapling, new ItemBlockVariants(sapling));
    }

    // For the custom planks
    public static void registerRenders() {

        // Loop through each value in CustomBlockPlanks.EnumType...
        for(int i=0; i < CustomBlockPlanks.EnumType.values().length; i++) {
            // Call the registerRender(Block block, int meta, String filename) method
            // prepend "planks_" to each enum value - "planks_tutorial"
            registerRender(planks, i, "planks_" + CustomBlockPlanks.EnumType.values()[i].getName());
            registerRender(log, i, "log_" + CustomBlockPlanks.EnumType.values()[i].getName());
            registerRender(leaves, i, "leaves_" + CustomBlockPlanks.EnumType.values()[i].getName());
            registerRender(sapling, i, "sapling_"+ CustomBlockPlanks.EnumType.values()[i].getName());
        }
    }

    // Register normal blocks
    public static void registerBlock(Block block) {

        // Register the new block
        ForgeRegistries.BLOCKS.register(block);

        // Set the creative tab for the new block
        block.setCreativeTab(Main.tutorialtab);

        // Create an itemblock for the block
        ItemBlock item = new ItemBlock(block);

        // Set the itemblock name from the block name
        item.setRegistryName(block.getRegistryName());

        // Register the itemblock (as an item)
        ForgeRegistries.ITEMS.register(item);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    // Register ItemBlocks
    public static void registerBlock(Block block, ItemBlock itemBlock) {

        ForgeRegistries.BLOCKS.register(block);
        block.setCreativeTab(Main.tutorialtab);
        itemBlock.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    // Register blocks with several enum variants
    public static void registerBlockWithVariants(Block block, ItemBlock itemBlock) {

        ForgeRegistries.BLOCKS.register(block);
        block.setCreativeTab(Main.tutorialtab);
        itemBlock.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

    }

    // Register the models for blocks with enum variants
    public static void registerRender(Block block, int meta, String filename) {

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), "inventory"));
    }
}
