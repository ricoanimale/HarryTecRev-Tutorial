package com.richardsearcy.htrtut.tabs;

import com.richardsearcy.htrtut.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TutorialTab extends CreativeTabs {

    public TutorialTab(String label) {

        // Call the CreativeTabs constructor
        super("tutorialtab");

        // Set the tab background image located in resources/assets/minecraft/gui/container/creative_inventory
        // Note tab_ is prepended to the filename set below - the actual filename should be tab_<filename>.png
        this.setBackgroundImageName("tutorial.png");
    }

    @Override
    public ItemStack getTabIconItem() {

        // Set the tab icon
        return new ItemStack(ItemInit.tutorial_ingot);
    }
}
