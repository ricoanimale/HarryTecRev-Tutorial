package com.richardsearcy.htrtut.proxy;

import com.richardsearcy.htrtut.Handlers.RegistryHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

        // Call the CommonProxy preInit method
        super.preInit(event);
    }

    public void init(FMLInitializationEvent event) {

        // Call the CommonProxy init method
        super.init(event);

        // Call the RegistryHandler Client method
        RegistryHandler.Client();
    }

    public void postInit(FMLPostInitializationEvent event) {

        // Call the CommonProxy postInit method
        super.postInit(event);
    }
}
