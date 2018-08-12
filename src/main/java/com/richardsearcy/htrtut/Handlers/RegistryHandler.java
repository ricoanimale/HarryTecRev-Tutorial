package com.richardsearcy.htrtut.Handlers;

import com.richardsearcy.htrtut.init.BlockInit;
import com.richardsearcy.htrtut.init.ItemInit;

public class RegistryHandler {

    public static void Client() {

        // Call the BlockInit registerRenders method
        BlockInit.registerRenders();
    }

    public static void Common() {

        // Initialize and register new items and blocks
        ItemInit.init();
        ItemInit.register();

        BlockInit.init();
        BlockInit.register();
    }
}
