package com.richardsearcy.htrtut.init.tools;

import com.richardsearcy.htrtut.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class CustomSword extends ItemSword {

    public CustomSword(String name, ToolMaterial material) {

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tutorialtab);
    }
}
