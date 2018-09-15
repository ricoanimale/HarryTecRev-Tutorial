package com.richardsearcy.htrtut.proxy;

import com.richardsearcy.htrtut.handlers.RegistryHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * ClientProxy class - clientside
 */
public class ClientProxy extends CommonProxy {

    /**
     * preInit method called by the preInit method in the Main class
     *
     * @param event
     */
    public void preInit(FMLPreInitializationEvent event) {

        // Call the CommonProxy preInit method
        super.preInit(event);
    }

    /**
     * init method called by the init method in the Main class
     *
     * @param event
     */
    public void init(FMLInitializationEvent event) {

        // Call the CommonProxy init method
        super.init(event);

        // Call the RegistryHandler Client method
        RegistryHandler.Client();
    }

    /**
     * postInit method called by the postInit method in the Main class
     *
     * @param event
     */
    public void postInit(FMLPostInitializationEvent event) {

        // Call the CommonProxy postInit method
        super.postInit(event);
    }
}
