package aurocosh.divinefavor.common.config.talismans.arrow;

import aurocosh.divinefavor.common.util.UtilTick;
import net.minecraftforge.common.config.Config;

public class HollowLeg {
    @Config.Name("Favor cost")
    public int favorCost = 5;
    @Config.Name("Duration")
    public int duration = UtilTick.minutesToTicks(2);
    @Config.Name("Exaustion value")
    public float exaustionValue =  20f;
    @Config.Name("Exaustion time")
    public int exaustionRate = UtilTick.secondsToTicks(1);
}