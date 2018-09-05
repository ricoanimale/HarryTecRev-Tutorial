package com.richardsearcy.htrtut.handlers;

import com.richardsearcy.htrtut.gen.TutorialOreGen;
import com.richardsearcy.htrtut.init.ArmorInit;
import com.richardsearcy.htrtut.init.BlockInit;
import com.richardsearcy.htrtut.init.ItemInit;
import com.richardsearcy.htrtut.init.ToolInit;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryHandler {

    public static void Client() {

        // Call the BlockInit registerRenders method
        // BlockInit.registerRenders();

        RecipeHandler.registerCrafting();
        RecipeHandler.registerSmelting();
    }

    public static void Common() {

        // Initialize and register new items, blocks, tools and armor
        ItemInit.init();
        ItemInit.register();

        BlockInit.init();
        BlockInit.register();

        ToolInit.init();
        ToolInit.register();

        ArmorInit.init();
        ArmorInit.register();

        // Register the tutorial ore generator
        GameRegistry.registerWorldGenerator(new TutorialOreGen(), 0);
    }
}
