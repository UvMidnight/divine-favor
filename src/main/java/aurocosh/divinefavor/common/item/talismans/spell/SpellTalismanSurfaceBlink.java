package aurocosh.divinefavor.common.item.talismans.spell;
import aurocosh.divinefavor.common.item.talismans.base.spell.ItemSpellTalisman;
import aurocosh.divinefavor.common.item.talismans.base.spell.TalismanContext;
import aurocosh.divinefavor.common.util.UtilEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class SpellTalismanSurfaceBlink extends ItemSpellTalisman {
    private static final double blinkDistance = 20;
    private static final int USES = 10;

    public SpellTalismanSurfaceBlink() {
        super("surface_blink", USES, true, true);
    }

    @Override
    public boolean isConsumeCharge(TalismanContext context) {
        BlockPos target = getBlinkTarget(context);
        return canWarp(target, context);
    }

    @Override
    protected void performActionServer(TalismanContext context) {
        BlockPos target = getBlinkTarget(context);
        if (canWarp(target, context))
            UtilEntity.teleport(context.player, target);
    }

    private BlockPos getBlinkTarget(TalismanContext context) {
        if(context.pos == null)
            return null;
        if(context.facing == null)
            return null;
        BlockPos target = context.pos.offset(context.facing);
        if(context.facing == EnumFacing.DOWN)
            return target.down();
        if(context.facing == EnumFacing.UP)
            return target;
        return target.down();
    }

    private boolean canWarp(BlockPos target, TalismanContext context){
        if(target == null)
            return false;
        if(!context.world.isAirBlock(target))
            return false;
        if(!context.world.isAirBlock(target.up()))
            return false;
        return context.player.getDistanceSq(target) < blinkDistance * blinkDistance;
    }
}