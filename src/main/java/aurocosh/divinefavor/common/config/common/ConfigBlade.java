package aurocosh.divinefavor.common.config.common;

import aurocosh.divinefavor.DivineFavor;
import aurocosh.divinefavor.common.config.entries.talismans.blade.*;
import net.minecraftforge.common.config.Config;

@Config(modid = DivineFavor.MOD_ID, name = DivineFavor.MOD_ID + "/blade_talismans")
public class ConfigBlade {
    @Config.Name("Blade of snow")
    public static BladeOfSnow bladeOfSnow = new BladeOfSnow();
    @Config.Name("Confusion")
    public static Confusion confusion = new Confusion();
    @Config.Name("Corrosion")
    public static Corrosion corrosion = new Corrosion();
    @Config.Name("Gamble")
    public static Gamble gamble = new Gamble();
    @Config.Name("HandSwap")
    public static HandSwap handSwap = new HandSwap();
    @Config.Name("Heavy blade")
    public static HeavyBlade heavyBlade = new HeavyBlade();
    @Config.Name("Holy blade")
    public static HolyBlade holyBlade = new HolyBlade();
    @Config.Name("Hungry blade")
    public static HungryBlade hungryBlade = new HungryBlade();
    @Config.Name("Inflame")
    public static Inflame inflame = new Inflame();
    @Config.Name("Poison coating")
    public static PoisonCoating poisonCoating = new PoisonCoating();
    @Config.Name("Rain sword")
    public static RainSword rainSword = new RainSword();
    @Config.Name("Vengeful blade")
    public static VengefulBlade vengefulBlade = new VengefulBlade();
    @Config.Name("Wither coating")
    public static WitherCoating witherCoating = new WitherCoating();
}