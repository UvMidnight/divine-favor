package aurocosh.divinefavor.common.item.spell_talismans.build

import aurocosh.divinefavor.common.coordinate_generators.HollowSphereCoordinateGenerator
import aurocosh.divinefavor.common.item.spell_talismans.base.SpellOptions
import aurocosh.divinefavor.common.item.spell_talismans.context.TalismanContext
import aurocosh.divinefavor.common.lib.extensions.get
import aurocosh.divinefavor.common.lib.extensions.set
import aurocosh.divinefavor.common.spirit.base.ModSpirit
import aurocosh.divinefavor.common.stack_properties.StackPropertyInt
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import java.util.*

class SpellTalismanBuildHollowSphereRelative(name: String, spirit: ModSpirit, favorCost: Int, options: EnumSet<SpellOptions>) : SpellTalismanBuildRelative(name, spirit, favorCost, options) {
    private val radius_internal: StackPropertyInt = propertyHandler.registerIntProperty("radius_internal", 3, 1, 10)
    private val radius_external: StackPropertyInt = propertyHandler.registerIntProperty("radius_external", 1, 1, 10)

    init {
        radius_internal.addChangeListener(this::onInternalChanged)
        radius_external.addChangeListener(this::onExternalChanged)
    }

    private fun onInternalChanged(stack: ItemStack, value: Int) {
        val external = stack.get(radius_external)
        if (external <= value)
            stack.set(radius_internal, external - 1, true)
    }

    private fun onExternalChanged(stack: ItemStack, value: Int) {
        val internal = stack.get(radius_internal)
        if (internal >= value)
            stack.set(radius_external, internal + 1, true)
    }

    private fun getRadiuses(itemStack: ItemStack): Pair<Int, Int> {
        val (radius_internal, radius_external) = itemStack.get(radius_internal, radius_external)
        if (radius_internal >= radius_external)
            return Pair(radius_external - 1, radius_external)
        return Pair(radius_internal, radius_external)
    }

    override fun getBlockCount(stack: ItemStack): Int {
        val (internal, external) = getRadiuses(stack)
        val volume = ((4 * Math.PI) / 3) * ((internal * internal * internal) - (external * external * external))
        return volume.toInt()
    }

    override fun getCoordinates(context: TalismanContext): List<BlockPos> {
        val (internal, external) = getRadiuses(context.stack)
        val blockPos = positionPropertyWrapper.getPosition(context)
        return coordinateGenerator.getCoordinates(blockPos, internal, external)
    }

    companion object {
        private val coordinateGenerator: HollowSphereCoordinateGenerator = HollowSphereCoordinateGenerator()
    }
}
