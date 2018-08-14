package com.richardsearcy.htrtut.init;

import com.richardsearcy.htrtut.init.armor.CustomArmor;
import com.richardsearcy.htrtut.init.items.CustomIngot;
import com.richardsearcy.htrtut.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ArmorInit {

    // Create a new armor material
    public static final ItemArmor.ArmorMaterial tutorial_armor = EnumHelper.addArmorMaterial("tutorial_armor", Reference.MODID + ":tutorial", 25, new int[] {3,5,7,2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5F);

    // Create a new armor item
    public static Item tutorial_helmet, tutorial_chestplate, tutorial_leggings, tutorial_boots;

    public static void init() {

        // Initialize the new item
        tutorial_helmet = new CustomArmor("tutorial_helmet", tutorial_armor, 1, EntityEquipmentSlot.HEAD );
        tutorial_chestplate = new CustomArmor("tutorial_chestplate", tutorial_armor, 1, EntityEquipmentSlot.CHEST);
        tutorial_leggings = new CustomArmor("tutorial_leggings", tutorial_armor, 2, EntityEquipmentSlot.LEGS);
        tutorial_boots = new CustomArmor("tutorial_boots", tutorial_armor, 1, EntityEquipmentSlot.FEET);
    }

    public static void register() {

        // Call the registerItem method for the new item
        registerItem(tutorial_helmet);
        registerItem(tutorial_chestplate);
        registerItem(tutorial_leggings);
        registerItem(tutorial_boots);
    }

    public static void registerItem(Item item) {

        // Register the new item
        ForgeRegistries.ITEMS.register(item);

        // Set the model resource location for the item
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
