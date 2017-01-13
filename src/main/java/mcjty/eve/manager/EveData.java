package mcjty.eve.manager;

import net.minecraft.nbt.NBTTagCompound;

import java.util.UUID;

public class EveData {

    // The player eve is currently targetting
    private UUID targetPlayer;

    private EveStrength strength;

    public UUID getTargetPlayer() {
        return targetPlayer;
    }

    public void setTargetPlayer(UUID targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    public EveStrength getStrength() {
        return strength;
    }

    public void setStrength(EveStrength strength) {
        this.strength = strength;
    }

    public void writeToNBT(NBTTagCompound compound) {
        compound.setUniqueId("target", targetPlayer);
        compound.setInteger("strength", strength.ordinal());
    }

    public void readFromNBT(NBTTagCompound compound) {
        if (compound.hasUniqueId("target")) {
            targetPlayer = compound.getUniqueId("target");
        } else {
            targetPlayer = null;
        }
        strength = EveStrength.values()[compound.getInteger("strength")];
    }
}
