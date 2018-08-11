package com.richardsearcy.htrtut.Handlers;

import com.richardsearcy.htrtut.init.ItemInit;

public class RegistryHandler {

    public static void Client() {


    }

    public static void Common() {

        ItemInit.init();
        ItemInit.register();
    }
}
