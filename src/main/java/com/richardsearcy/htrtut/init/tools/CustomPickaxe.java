package com.richardsearcy.htrtut.init.tools;

import com.richardsearcy.htrtut.Main;
import net.minecraft.item.ItemPickaxe;

public class CustomPickaxe extends ItemPickaxe {

    public CustomPickaxe(String name, ToolMaterial material) {

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tutorialtab);

    }
}
