package aurocosh.divinefavor.common.custom_data.player.data.aura.energetic;

import aurocosh.divinefavor.common.lib.IncrementalChanceCounter;

// The default implementation of the capability. Holds all the logic.
public class EnergeticAuraData {
    private static final float STARTING_CHANCE = 0.0f;
    private static final float CHANCE_INCREASE = 0.01f;

    private final IncrementalChanceCounter chanceCounter;

    public EnergeticAuraData() {
        chanceCounter = new IncrementalChanceCounter(STARTING_CHANCE, CHANCE_INCREASE);
    }

    public void reset() {
        chanceCounter.reset();
    }

    public boolean tryLuck() {
        return chanceCounter.tryLuck();
    }

    public float getChance() {
        return chanceCounter.getChance();
    }

    public void setChance(float chance) {
        chanceCounter.setChance(chance);
    }
}