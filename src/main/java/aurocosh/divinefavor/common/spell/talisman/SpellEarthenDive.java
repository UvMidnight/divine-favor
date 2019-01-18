package aurocosh.divinefavor.common.spell.talisman;

import aurocosh.divinefavor.common.spell.talisman.base.ModSpell;
import aurocosh.divinefavor.common.spell.talisman.base.SpellContext;
import aurocosh.divinefavor.common.util.UtilCoordinates;
import aurocosh.divinefavor.common.util.UtilEntity;
import net.minecraft.util.math.BlockPos;

public class SpellEarthenDive extends ModSpell {
    private final int MAX_TELEPORTATION_DISTANCE = 64;

    @Override
    protected void performActionServer(SpellContext context) {
        BlockPos targetPos = UtilCoordinates.findPlaceToStandBelow(context.pos, context.world, MAX_TELEPORTATION_DISTANCE, true);
        if (targetPos == null)
            return;
        UtilEntity.teleport(context.player, targetPos);
    }
}