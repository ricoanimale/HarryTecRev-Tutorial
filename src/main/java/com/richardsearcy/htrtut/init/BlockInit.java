package com.richardsearcy.htrtut.init;

import com.richardsearcy.htrtut.Main;
import com.richardsearcy.htrtut.init.blocks.CustomBlockStairs;
import com.richardsearcy.htrtut.init.blocks.CustomIngotBlock;
import com.richardsearcy.htrtut.init.blocks.CustomOre;
import com.richardsearcy.htrtut.init.blocks.slab.CustomBlockDoubleSlab;
import com.richardsearcy.htrtut.init.blocks.slab.CustomBlockHalfSlab;
import com.richardsearcy.htrtut.tabs.TutorialTab;
import com.richardsearcy.htrtut.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit {

    // Create a new block named tutorial_ore
    public static Block tutorial_ore, tutorial_ore_nether, tutorial_ore_end;

    // Create a new block named tutorial_block
    public static Block tutorial_block;

    // Create a custom stair block
    public static Block tutorial_stairs;

    public static CustomBlockHalfSlab tutorial_slab_half;
    public static CustomBlockDoubleSlab tutorial_slab_double;

    public static void init() {

        // Initialize the new block tutorial_ore
        tutorial_ore = new CustomOre("tutorial_ore", 2.0F, 4.0F, 2);
        tutorial_ore_nether = new CustomOre("tutorial_ore_nether", 2.0F, 4.0F, 2);
        tutorial_ore_end = new CustomOre("tutorial_ore_end", 2.0F, 4.0F, 2);

        // Initialize the new block tutorial_block
        tutorial_block = new CustomIngotBlock("tutorial_block", 2.5F, 4.5F, 2);

        // Initialize the new custom block tutorial stairs
        tutorial_stairs = new CustomBlockStairs("tutorial_stairs", tutorial_block.getDefaultState());

        tutorial_slab_half = new CustomBlockHalfSlab("tutorial_slab_half");
        tutorial_slab_double = new CustomBlockDoubleSlab("tutorial_slab_double");

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

        registerBlock(tutorial_slab_half, new ItemSlab(tutorial_slab_half, tutorial_slab_half, tutorial_slab_double));
        ForgeRegistries.BLOCKS.register(tutorial_slab_double);
    }

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

    public static void registerBlock(Block block, ItemBlock itemBlock) {

        ForgeRegistries.BLOCKS.register(block);
        block.setCreativeTab(Main.tutorialtab);
        itemBlock.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    /*public static void registerRenders () {

        // Call the registerRender method for tutorial_ore
        registerRender(tutorial_ore);
        registerRender(tutorial_ore_nether);
        registerRender(tutorial_ore_end);

        // Call the registerRender method for tutorial_block
        registerRender(tutorial_block);
    }

    public static void registerRender(Block block) {

        // Register the block renderer
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MODID + ":" + block.getUnlocalizedName().substring(5)));

    }*/
}
