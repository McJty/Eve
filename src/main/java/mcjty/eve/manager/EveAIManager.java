package mcjty.eve.manager;

import net.minecraft.world.World;

public class EveAIManager {

    public static void handleAI(World world) {
        EveData data = EveWorldSavedData.getData(world);

        data.nextTick();

        switch (data.getStrength()) {
            case SLEEP:
                break;
            case WEAK:
                handleWeakState(world, data);
                break;
            case NORMAL:
                handleNormalState(world, data);
                break;
            case STRONG:
                handleStrongState(world, data);
                break;
            case DEADLY:
                handleDeadlyState(world, data);
                break;
        }

        EveWorldSavedData.save(world);
    }

    private static void handleWeakState(World world, EveData data) {

    }

    private static void handleNormalState(World world, EveData data) {
        resolveTarget(world, data);
    }

    private static void handleStrongState(World world, EveData data) {
        resolveTarget(world, data);
    }

    private static void handleDeadlyState(World world, EveData data) {
        resolveTarget(world, data);
    }

    // If Eve has no target or the target is not online try to find another target
    private static void resolveTarget(World world, EveData data) {

    }

}
