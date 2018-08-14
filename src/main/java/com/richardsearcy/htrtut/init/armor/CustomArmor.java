package com.richardsearcy.htrtut.init.armor;

import com.richardsearcy.htrtut.Main;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class CustomArmor extends ItemArmor {
    public CustomArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {

        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tutorialtab);
    }
}
