package com.richardsearcy.htrtut.init.tools;

import com.richardsearcy.htrtut.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class CustomHoe extends ItemHoe {

    public CustomHoe(String name, ToolMaterial material) {

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tutorialtab);
    }
}
