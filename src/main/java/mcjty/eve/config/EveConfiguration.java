package mcjty.eve.config;

import net.minecraftforge.common.config.Configuration;

public class EveConfiguration {

    public static final String CATEGORY_GENERAL = "general";

    private static final int MINUTE = 60 * 20;

    public static int eveTick = 100;
    public static int fromSleepToWeak = (20 * MINUTE) / 100;
    public static int fromWeakToNormal = (30 * MINUTE) / 100;
    public static int fromNormalToStrong = (50 * MINUTE) / 100;
    public static int fromStrongToDeadly = (80 * MINUTE) / 100;

    public static void init(Configuration cfg) {
        eveTick = cfg.getInt("eveTick", CATEGORY_GENERAL, eveTick, 1, 10000, "The amount of minecraft ticks for one eve tick");
        fromSleepToWeak = cfg.getInt("fromSleepToWeak", CATEGORY_GENERAL, fromSleepToWeak, 1, 1000000000, "Amount of eve ticks at which transition to weak occurs");
        fromWeakToNormal = cfg.getInt("fromWeakToNormal", CATEGORY_GENERAL, fromWeakToNormal, 1, 1000000000, "Amount of eve ticks at which transition to normal occurs");
        fromNormalToStrong = cfg.getInt("fromNormalToStrong", CATEGORY_GENERAL, fromNormalToStrong, 1, 1000000000, "Amount of eve ticks at which transition to strong occurs");
        fromStrongToDeadly = cfg.getInt("fromStrongToDeadly", CATEGORY_GENERAL, fromStrongToDeadly, 1, 1000000000, "Amount of eve ticks at which transition to deadly occurs");
    }

}
