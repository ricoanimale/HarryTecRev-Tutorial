package com.richardsearcy.htrtut.init.tools;

import com.richardsearcy.htrtut.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class CustomShovel extends ItemSpade {

    public CustomShovel(String name, Item.ToolMaterial material) {

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tutorialtab);
    }
}
