package com.richardsearcy.htrtut.handlers;

import com.richardsearcy.htrtut.init.ArmorInit;
import com.richardsearcy.htrtut.init.BlockInit;
import com.richardsearcy.htrtut.init.ItemInit;
import com.richardsearcy.htrtut.init.ToolInit;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

    public static void registerCrafting() {

        // Craft a shaped recipe for a tutorial ore from tutorial ingots and vanilla stone
        GameRegistry.addShapedRecipe(new ResourceLocation("htrtut:tutorial_ore"), new ResourceLocation("htrtut:tutorial_blocks"), new ItemStack(BlockInit.tutorial_ore),
                new Object[] {"SSS", "SIS", "SSS", 'S', Blocks.STONE, 'I', ItemInit.tutorial_ingot});

        // Register the crafting recipes for the armor
        registerArmorCrafting(ArmorInit.tutorial_helmet, ArmorInit.tutorial_chestplate, ArmorInit.tutorial_leggings, ArmorInit.tutorial_boots, ItemInit.tutorial_ingot);

        // Register the crafting recipies for the tools
        registerToolCrafting(ToolInit.tutorial_axe, ToolInit.tutorial_hoe, ToolInit.tutorial_pickaxe, ToolInit.tutorial_shovel, ToolInit.tutorial_sword, ItemInit.tutorial_ingot);

        // Add a shapeless recipe for 9 tutorial ingots from one tutorial ingot block
        GameRegistry.addShapelessRecipe(new ResourceLocation("htrtut:tutorial_ingot"), new ResourceLocation("htrtut:tutorial_items"), new ItemStack(ItemInit.tutorial_ingot, 9), new Ingredient[]{Ingredient.fromItem(Item.getItemFromBlock(BlockInit.tutorial_block))});

        // Add a shaped recipe for a tutorial block from 9 tutorial ingots
        GameRegistry.addShapedRecipe(new ResourceLocation("htrtut:tutorial_block"), new ResourceLocation("htrtut:tutoril_ingot"), new ItemStack(BlockInit.tutorial_block),
                new Object[] {"III", "III", "III", 'I', ItemInit.tutorial_ingot});
    }

    public static void registerSmelting() {

        // Create a smelting recipie for tutorial_ore to tutorial_ingots
        GameRegistry.addSmelting(BlockInit.tutorial_ore, new ItemStack(ItemInit.tutorial_ingot), 10);
    }

    private static void registerToolCrafting(Item axe, Item hoe, Item pickaxe, Item shovel, Item sword, Item ingot) {

        // Create the crafting recipes for the tools
        GameRegistry.addShapedRecipe(new ResourceLocation("" + axe.getRegistryName()), new ResourceLocation("htrtut:tutorial_tools"), new ItemStack(axe),
                new Object[] {"II ", "IS ", " S ", 'S', Items.STICK, 'I', ItemInit.tutorial_ingot});

        GameRegistry.addShapedRecipe(new ResourceLocation("" + hoe.getRegistryName()), new ResourceLocation("htrtut:tutorial_tools"), new ItemStack(hoe),
                new Object[] {"II ", " S ", " S ", 'S', Items.STICK, 'I', ItemInit.tutorial_ingot});

        GameRegistry.addShapedRecipe(new ResourceLocation("" + pickaxe.getRegistryName()), new ResourceLocation("htrtut:tutorial_tools"), new ItemStack(pickaxe),
                new Object[] {"III", " S ", " S ", 'S', Items.STICK, 'I', ItemInit.tutorial_ingot});

        GameRegistry.addShapedRecipe(new ResourceLocation("" + shovel.getRegistryName()), new ResourceLocation("htrtut:tutorial_tools"), new ItemStack(shovel),
                new Object[] {" I ", " S ", " S ", 'S', Items.STICK, 'I', ItemInit.tutorial_ingot});

        GameRegistry.addShapedRecipe(new ResourceLocation("" + sword.getRegistryName()), new ResourceLocation("htrtut:tutorial_tools"), new ItemStack(sword),
                new Object[] {" I ", " I ", " S ", 'S', Items.STICK, 'I', ItemInit.tutorial_ingot});
    }

    private static void registerArmorCrafting(Item helmet, Item chestplate, Item leggings, Item boots, Item ingot) {

        // Create the crafting recipes for the armor
        GameRegistry.addShapedRecipe(new ResourceLocation("" + helmet.getRegistryName()), new ResourceLocation("htrtut:tutorial_armor"), new ItemStack(helmet),
                new Object[] {"   ", "III", "I I", 'I', ItemInit.tutorial_ingot});

        GameRegistry.addShapedRecipe(new ResourceLocation("" + chestplate.getRegistryName()), new ResourceLocation("htrtut:tutorial_armor"), new ItemStack(chestplate),
                new Object[] {"I I", "III", "III", 'I', ItemInit.tutorial_ingot});

        GameRegistry.addShapedRecipe(new ResourceLocation("" + leggings.getRegistryName()), new ResourceLocation("htrtut:tutorial_armor"), new ItemStack(leggings),
                new Object[] {"III", "I I", "I I", 'I', ItemInit.tutorial_ingot});

        GameRegistry.addShapedRecipe(new ResourceLocation("" + boots.getRegistryName()), new ResourceLocation("htrtut:tutorial_armor"), new ItemStack(boots),
                new Object[] {"   ", "I I", "I I", 'I', ItemInit.tutorial_ingot});
    }
}
