package com.richardsearcy.htrtut.init;

import com.richardsearcy.htrtut.Main;
import com.richardsearcy.htrtut.init.blocks.CustomIngotBlock;
import com.richardsearcy.htrtut.init.blocks.CustomOre;
import com.richardsearcy.htrtut.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit {

    // Create a new block named tutorial_ore
    public static Block tutorial_ore;

    // Create a new block named tutorial_block
    public static Block tutorial_block;

    public static void init() {

        // Initialize the new block tutorial_ore
        tutorial_ore = new CustomOre("tutorial_ore", 2.0F, 4.0F, 2);

        // Initialize the new block tutorial_block
        tutorial_block = new CustomIngotBlock("tutorial_block", 2.5F, 4.5F, 2);

    }

    public static void register() {

        // Call the registerBlock method to register tutorial_ore
        registerBlock(tutorial_ore);

        // Call the registerBlock method to register the tutorial_block
        registerBlock(tutorial_block);
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
    }

    public static void registerRenders () {

        // Call the registerRender method for tutorial_ore
        registerRender(tutorial_ore);

        // Call the registerRender method for tutorial_block
        registerRender(tutorial_block);
    }

    public static void registerRender(Block block) {

        // Register the block renderer
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MODID + ":" + block.getUnlocalizedName().substring(5)));

    }
}
