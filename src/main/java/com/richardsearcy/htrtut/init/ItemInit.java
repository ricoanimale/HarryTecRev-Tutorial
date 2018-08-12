package com.richardsearcy.htrtut.init;

import com.richardsearcy.htrtut.init.items.CustomIngot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemInit {

    // Create a new item
    public static Item tutorial_ingot;

    public static void init() {

        // Initialize the new item
        tutorial_ingot = new CustomIngot("tutorial_ingot");
    }

    public static void register() {

        // Call the registerItem method for the new item
        registerItem(tutorial_ingot);
    }

    public static void registerItem(Item item) {

        // Register the new item
        ForgeRegistries.ITEMS.register(item);

        // Set the model resource location for the item
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
