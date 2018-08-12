package com.richardsearcy.htrtut.init.items;

import com.richardsearcy.htrtut.Main;
import com.richardsearcy.htrtut.tabs.TutorialTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CustomIngot extends Item {

    public CustomIngot(String name) {

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tutorialtab);
    }
}
