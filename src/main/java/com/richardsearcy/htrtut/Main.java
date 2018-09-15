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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Main entry point for the mod.
 *
 * Starts with the @Mod annotation that indicates to the Forge Mod Loader that this class is the entry point for the
 * mod. The @Mod annotation contains various metadata about the mod. It also designates the class that will receive the
 * @EventHandler events.
 *
 * @Mod properties:
 *  modid                       String      required    A unique identifier for the mod. It must be lowercase and 64 characters or less.
 *
 *  name                        String                  A user-friendly name for the mod.
 *
 *  version                     String                  The version of the mod. It should be just numbers separated by dots.
 *
 *  dependencies                String                  Dependencies for the mod.
 *
 *  useMetadata                 Boolean     false       If set to true, properties in @Mod will be overridden by mcmod.info.
 *
 *  clientSideOnly              Boolean     false       If either is set to true, the jar will be skipped on the other side, and the mod will not load.
 *  serverSideOnly              Boolean     false       If both are true, the game crashes.
 *
 *  acceptedMinecraft versions  String                  The version range of Minecraft the mod will run on. An empty string will match all versions.
 *
 *  acceptableRemoteVersions    String                  Specifies a remote version range that this mod will accept as valid.* "" Matches the current version, and "*" matches all versions.
 *
 *  acceptableSaveVersions      String                  A version range specifying compatible save version information.* If you follow an unusual version convention, use SaveInspectionHandler instead.
 *
 *  certificateFingerprint      String                  See the tutorial on jar signing.
 *
 *  modLanguage                 String      "java"      The programming language the mod is written in. Can be either "java" or "scala".
 *
 *  modLanguageAdapter          String                  Path to a language adapter for the mod. The class must have a default constructor and must implement ILanguageAdapter. If it doesn’t, Forge will crash. If set, overrides modLanguage.
 *
 *  canBeDeactivated            String      false       This is not implemented, but if the mod could be deactivated (e.g. a minimap mod), this would be set to true and the mod would receive FMLDeactivationEvent to perform cleanup tasks.
 *
 *  guiFactory                  String                  Path to the mod’s GUI factory, if one exists. GUI factories are used to make custom config screens, and must implement IModGuiFactory. For an example, look at FMLConfigGuiFactory.
 *
 *  updateJson                  String                  URL to an update JSON file. See Forge Update Checker.
 */
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    /**
     *  Initialize a new tab on the creative inventory
     */
    public static final CreativeTabs tutorialtab = new TutorialTab("tutorialtab");

    @SideOnly(Side.CLIENT)
    @Mod.Instance
    public static Main INSTANCE;

    /**
     * Set up the proxies
     */
    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;

    /**
     * preInit event handler
     *
     * @param event
     */
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

        // Call the proxy preInit method
        proxy.preInit(event);
    }

    /**
     * init event handler
     *
     * @param event
     */
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

        // Call the proxy init method
        proxy.init(event);
    }

    /**
     * postInit event handler
     *
     * @param event
     */
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

        // Call the proxy postInit method
        proxy.postInit(event);
    }
}
