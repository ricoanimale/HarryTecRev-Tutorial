package com.richardsearcy.htrtut.proxy;

import com.richardsearcy.htrtut.handlers.RegistryHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * CommonProxy class - serverside
 */
public class CommonProxy {

    /**
     * preInit method called by the preInit method in the Main class
     *
     * @param event
     */
    public void preInit(FMLPreInitializationEvent event) {

        // Call the RegistryHandler Common method
        RegistryHandler.Common();
    }

    /**
     * init method called by the init method in the Main class
     *
     * @param event
     */
    public void init(FMLInitializationEvent event) {

    }

    /**
     * postInit method called by the postInit method in the Main class
     *
     * @param event
     */
    public void postInit(FMLPostInitializationEvent event) {

    }
}
