package mcjty.eve.manager;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class EveWorldSavedData extends WorldSavedData {

    private static final String NAME = "EveData";
    private static EveWorldSavedData instance = null;

    private EveData data = new EveData();

    public static void clearInstance() {
        if (instance != null) {
            instance = null;
        }
    }

    public EveWorldSavedData(String identifier) {
        super(identifier);
    }

    public static void save(World world) {
        EveWorldSavedData data = getEveData(world);
        world.getMapStorage().setData(NAME, data);
        data.markDirty();
    }

    private static EveWorldSavedData getEveData(World world) {
        if (instance != null) {
            return instance;
        }
        instance = (EveWorldSavedData) world.getMapStorage().getOrLoadData(EveWorldSavedData.class, NAME);
        if (instance == null) {
            instance = new EveWorldSavedData(NAME);
        }
        return instance;
    }

    public static EveData getData(World world) {
        return getEveData(world).getData();
    }

    private EveData getData() {
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        data.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        data.writeToNBT(compound);
        return compound;
    }
}
