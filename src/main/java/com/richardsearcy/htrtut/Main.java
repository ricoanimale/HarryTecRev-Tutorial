package com.richardsearcy.htrtut;

import com.richardsearcy.htrtut.tabs.TutorialTab;
import com.richardsearcy.htrtut.util.Reference;
import com.richardsearcy.htrtut.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

// Setup the mod annotation
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    public static final CreativeTabs tutorialtab = new TutorialTab("tutorialtab");

    // Set up the proxies
    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

        // Call the proxy preInit method
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

        // Call the proxy init method
        proxy.init(event);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

        // Call the proxy postInit method
        proxy.postInit(event);
    }
}
