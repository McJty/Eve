package mcjty.eve;

import mcjty.eve.entity.EntityEve;
import mcjty.eve.entity.RenderEve;
import mcjty.lib.tools.EntityTools;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {

    public static void init() {
        // Every entity in our mod has an ID (local to this mod)
        int id = 1;
        EntityTools.registerModEntity(new ResourceLocation(Eve.MODID, "eve"), EntityEve.class, "eve", id++, Eve.instance, 64, 3, true, 0x996600, 0x00ff00);

        // This is the loot table for our mob
//        LootTableList.register(EntityEve.LOOT);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityEve.class, RenderEve.FACTORY);
    }
}
