package aurocosh.divinefavor.common.potions.potions;

import aurocosh.divinefavor.common.config.common.ConfigSpells;
import aurocosh.divinefavor.common.potions.base.potion.ModPotionToggle;
import aurocosh.divinefavor.common.util.UtilBlock;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PotionExtremeBuoyancy extends ModPotionToggle {
    public PotionExtremeBuoyancy() {
        super("extreme_buoyancy", true, 0x7FB8A4);
    }

    @Override
    public void performEffect(EntityLivingBase livingBase, int amplifier) {
        World world = livingBase.getEntityWorld();
        BlockPos pos = livingBase.getPosition();

        if (!UtilBlock.isLiquid(world.getBlockState(pos).getBlock()))
            return;
        if (livingBase.isSneaking())
            return;

        livingBase.motionY = ConfigSpells.extremeBuoyancy.buoyancyForce;
        livingBase.setAIMoveSpeed(0.1F);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}