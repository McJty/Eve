package mcjty.eve;


import mcjty.eve.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Eve.MODID, name = Eve.MODNAME,
        dependencies =
                "required-after:compatlayer@[" + Eve.COMPATLAYER_VER + ",);" +
                "after:Forge@[" + Eve.MIN_FORGE10_VER + ",);" +
                "after:forge@[" + Eve.MIN_FORGE11_VER + ",)",
        version = Eve.VERSION,
        acceptedMinecraftVersions = "[1.10,1.12)")
public class Eve {

    public static final String MODID = "eve";
    public static final String MODNAME = "Eve";
    public static final String VERSION = "0.0.1";
    public static final String MIN_FORGE10_VER = "12.18.1.2082";
    public static final String MIN_FORGE11_VER = "13.19.0.2176";
    public static final String COMPATLAYER_VER = "0.1.6";

    @SidedProxy(clientSide = "mcjty.eve.proxy.ClientProxy", serverSide = "mcjty.eve.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Eve instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        proxy.preInit(event);
//        MainCompatHandler.registerWaila();
//        MainCompatHandler.registerTOP();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
