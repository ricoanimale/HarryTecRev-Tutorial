package com.richardsearcy.htrtut.tabs;

import com.richardsearcy.htrtut.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * TutorialTab class creates a custom creative tab for the mod
 */
public class TutorialTab extends CreativeTabs {

    /**
     * TutorialTab constructor passes a supplied label to the CreativeTabs class and sets the tab background image.
     *
     * @param label
     */
    public TutorialTab(String label) {

        // Call the CreativeTabs constructor
        super("tutorialtab");

        // Set the tab background image located in resources/assets/minecraft/gui/container/creative_inventory
        // Note tab_ is prepended to the filename set below - the actual filename should be tab_<filename>.png
        this.setBackgroundImageName("tutorial.png");
    }

    /**
     * Sets the icon for the custom tab
     *
     * @return
     */
    @Override
    public ItemStack getTabIconItem() {

        // Set the tab icon
        return new ItemStack(ItemInit.tutorial_ingot);
    }
}
