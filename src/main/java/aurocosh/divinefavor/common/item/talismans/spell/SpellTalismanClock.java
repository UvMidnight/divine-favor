package aurocosh.divinefavor.common.item.talismans.spell;

import aurocosh.divinefavor.common.item.talismans.spell.base.ItemSpellTalisman;
import aurocosh.divinefavor.common.item.talismans.spell.base.SpellOptions;
import aurocosh.divinefavor.common.item.talismans.spell.base.TalismanContext;
import aurocosh.divinefavor.common.spirit.base.ModSpirit;
import net.minecraft.util.text.TextComponentString;

import java.util.EnumSet;

public class SpellTalismanClock extends ItemSpellTalisman {
    public SpellTalismanClock(String name, ModSpirit spirit, int favorCost, EnumSet<SpellOptions> options) {
        super(name, spirit, favorCost, options);
    }

    @Override
    protected void performActionServer(TalismanContext context) {
    }

    @Override
    protected void performActionClient(TalismanContext context) {
        long time = context.world.getWorldTime();
        context.player.sendMessage(new TextComponentString("Time: " + time));
        context.player.sendMessage(new TextComponentString("Day time: " + time % 24000));
    }
}
