package mcjty.eve.manager;

import mcjty.eve.config.EveConfiguration;
import net.minecraft.nbt.NBTTagCompound;

import java.util.UUID;

public class EveData {

    // The player eve is currently targetting
    private UUID targetPlayer;

    // The strengh. The strengthCounter is counted in number of 'eve ticks'.
    private EveStrength strength;
    private int strengthCounter = 0;

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

    public int getStrengthCounter() {
        return strengthCounter;
    }

    public void setStrengthCounter(int strengthCounter) {
        this.strengthCounter = strengthCounter;
    }

    // Get the strength at which we advance to the next level
    private int getAdvanceStrength() {
        switch (strength) {
            case SLEEP:
                return EveConfiguration.fromSleepToWeak;
            case WEAK:
                return EveConfiguration.fromWeakToNormal;
            case NORMAL:
                return EveConfiguration.fromNormalToStrong;
            case STRONG:
                return EveConfiguration.fromStrongToDeadly;
            case DEADLY:
                return -1;
        }
        return -1;
    }

    // Proceed to the next tick
    public void nextTick() {
        strengthCounter++;
        int advanceStrength = getAdvanceStrength();
        if (advanceStrength != -1 && strengthCounter >= advanceStrength) {
            strength = EveStrength.values()[strength.ordinal()+1];
        }
    }


    public void writeToNBT(NBTTagCompound compound) {
        compound.setUniqueId("target", targetPlayer);
        compound.setInteger("strength", strength.ordinal());
        compound.setInteger("strengthCounter", strengthCounter);
    }

    public void readFromNBT(NBTTagCompound compound) {
        if (compound.hasUniqueId("target")) {
            targetPlayer = compound.getUniqueId("target");
        } else {
            targetPlayer = null;
        }
        strength = EveStrength.values()[compound.getInteger("strength")];
        strengthCounter = compound.getInteger("strengthCounter");
    }
}
