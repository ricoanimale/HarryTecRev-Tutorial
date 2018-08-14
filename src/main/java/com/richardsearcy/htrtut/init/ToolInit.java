package com.richardsearcy.htrtut.init;

import com.richardsearcy.htrtut.init.tools.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ToolInit {

    // Create a tool material
    public static final Item.ToolMaterial tutorial = EnumHelper.addToolMaterial("tutorial", 3, 1200, 7.0F, 2.5F, 8);

    // Create a new tool
    public static Item tutorial_pickaxe, tutorial_axe, tutorial_hoe, tutorial_shovel, tutorial_sword;

    public static void init() {

        // Initialize the new item
        tutorial_pickaxe = new CustomPickaxe("tutorial_pickaxe", tutorial);
        tutorial_axe = new CustomAxe("tutorial_axe", tutorial);
        tutorial_hoe = new CustomHoe("tutorial_hoe", tutorial);
        tutorial_shovel = new CustomShovel("tutorial_shovel", tutorial);
        tutorial_sword = new CustomSword("tutorial_sword", tutorial);
    }

    public static void register() {

        // Call the registerItem method for the new item
        registerItem(tutorial_pickaxe);
        registerItem(tutorial_axe);
        registerItem(tutorial_hoe);
        registerItem(tutorial_shovel);
        registerItem(tutorial_sword);
    }

    public static void registerItem(Item item) {

        // Register the new item
        ForgeRegistries.ITEMS.register(item);

        // Set the model resource location for the item
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
