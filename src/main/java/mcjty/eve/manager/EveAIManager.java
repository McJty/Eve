package mcjty.eve.manager;

import net.minecraft.world.World;

public class EveAIManager {

    public static void handleAI(World world) {
        EveData data = EveWorldSavedData.getData(world);

        data.nextTick();

        EveWorldSavedData.save(world);
    }

}
