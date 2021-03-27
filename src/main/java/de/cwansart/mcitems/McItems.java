package de.cwansart.mcitems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = McItems.MODID, useMetadata = true)
public class McItems {

    private static Logger logger;

    public static final String MODID = "mcitems";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("loading MC-Items");
        MinecraftForge.EVENT_BUS.register(ItemRegister.class);
    }
}
