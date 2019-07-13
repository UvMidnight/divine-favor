package aurocosh.divinefavor.common.item.spell_talismans.replace

import aurocosh.divinefavor.client.block_ovelay.BlockExchangeRendering
import aurocosh.divinefavor.common.config.common.ConfigGeneral
import aurocosh.divinefavor.common.item.spell_talismans.build.base.SpellTalismanBuild
import aurocosh.divinefavor.common.item.spell_talismans.common_build_properties.PositionPropertyWrapper
import aurocosh.divinefavor.common.item.spell_talismans.context.TalismanContext
import aurocosh.divinefavor.common.lib.extensions.get
import aurocosh.divinefavor.common.lib.interfaces.IBlockCatcher
import aurocosh.divinefavor.common.spirit.base.ModSpirit
import aurocosh.divinefavor.common.stack_properties.properties.StackPropertyBool
import aurocosh.divinefavor.common.stack_properties.properties.StackPropertyInt
import aurocosh.divinefavor.common.tasks.BlockReplacingTask
import net.minecraft.item.ItemStack
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.event.world.BlockEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

abstract class SpellTalismanReplace(name: String, spirit: ModSpirit) : SpellTalismanBuild(name, spirit, ConfigGeneral.blockReplacingCost), IBlockCatcher {
    protected val blockCount: StackPropertyInt = propertyHandler.registerIntProperty("block_count", 6, 1, 64)
    protected val isFuzzy: StackPropertyBool = propertyHandler.registerBoolProperty("fuzzy", false)
    override val positionPropertyWrapper: PositionPropertyWrapper = PositionPropertyWrapper(propertyHandler)

    override fun getCommonCoordinates(context: TalismanContext) = getCoordinates(context).filterNot { context.world.isAirBlock(it) }

    override fun performActionServer(context: TalismanContext) {
        val (player, stack) = context.getCommon()
        val state = stack.get(selectPropertyWrapper.selectedBlock)
        val coordinates = getCommonCoordinates(context)
        BlockReplacingTask(coordinates, state, player, 1).start()
    }

    @SideOnly(Side.CLIENT)
    override fun handleRendering(context: TalismanContext, lastEvent: RenderWorldLastEvent) {
        val coordinates = getCommonCoordinates(context)
        val state = context.stack.get(selectPropertyWrapper.selectedBlock)
        BlockExchangeRendering.render(lastEvent, context.player, state, coordinates)
    }

    override fun catchDrops(stack: ItemStack, toolStack: ItemStack, event: BlockEvent.HarvestDropsEvent) {
        event.drops.removeIf(event.harvester::addItemStackToInventory)
    }
}
