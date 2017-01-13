package mcjty.eve;

import mcjty.eve.manager.EveAIManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ForgeEventHandlers {

    public static int counter = 10;


    @SubscribeEvent
    public void onWorldTickEvent(TickEvent.WorldTickEvent event) {
        counter--;
        if (counter <= 0) {
            counter = 100;
            if (event.world.provider.getDimension() == 0) {
                EveAIManager.handleAI();
            }
        }
    }

}
