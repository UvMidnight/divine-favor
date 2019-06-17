package aurocosh.divinefavor.common.item.talisman_tools.grimoire

import aurocosh.divinefavor.DivineFavor
import aurocosh.divinefavor.common.constants.ConstGuiIDs
import aurocosh.divinefavor.common.constants.ConstMainTabOrder
import aurocosh.divinefavor.common.item.common.ModItems
import aurocosh.divinefavor.common.item.spell_talismans.base.ItemSpellTalisman
import aurocosh.divinefavor.common.item.spell_talismans.context.TalismanContextGenerator
import aurocosh.divinefavor.common.item.talisman_tools.ItemTalismanContainer
import aurocosh.divinefavor.common.item.talisman_tools.TalismanContainerMode
import aurocosh.divinefavor.common.item.talisman_tools.grimoire.capability.GrimoireDataHandler.CAPABILITY_GRIMOIRE
import aurocosh.divinefavor.common.item.talisman_tools.grimoire.capability.GrimoireProvider
import aurocosh.divinefavor.common.item.talisman_tools.grimoire.capability.GrimoireStorage
import aurocosh.divinefavor.common.lib.extensions.cap
import aurocosh.divinefavor.common.util.UtilItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.common.capabilities.ICapabilityProvider

class ItemGrimoire : ItemTalismanContainer("grimoire", "grimoire", ConstMainTabOrder.CONTAINERS) {
    init {
        setMaxStackSize(1)
        creativeTab = DivineFavor.TAB_MAIN
    }

    override fun onItemUse(player: EntityPlayer, world: World, pos: BlockPos, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): EnumActionResult {
        val stack = player.getHeldItem(hand)
        if (getModeOrTransform(stack, player) != TalismanContainerMode.NORMAL)
            return EnumActionResult.PASS

        val (talismanStack, talisman) = getTalisman<ItemSpellTalisman>(stack) ?: return EnumActionResult.PASS
        val context = TalismanContextGenerator.useCast(player, world, pos, hand, facing, talismanStack)
        val success = talisman.cast(context)
        return UtilItem.actionResultPass(success)
    }

    override fun onItemRightClick(world: World, player: EntityPlayer, hand: EnumHand): ActionResult<ItemStack> {
        val stack = player.getHeldItem(hand)
        val success = performRightClickAction(world, player, hand, stack)
        return UtilItem.actionResult(success, stack)
    }

    private fun performRightClickAction(world: World, player: EntityPlayer, hand: EnumHand, stack: ItemStack): Boolean {
        if (player.isSneaking) {
            player.openGui(DivineFavor, ConstGuiIDs.GRIMOIRE, world, player.posX.toInt(), player.posY.toInt(), player.posZ.toInt())
        } else {
            val (talismanStack, talisman) = getTalisman<ItemSpellTalisman>(stack) ?: return true
            val context = TalismanContextGenerator.rightClick(world, player, hand, talismanStack)
            talisman.cast(context)
        }
        return true
    }

    override fun initCapabilities(item: ItemStack, nbt: NBTTagCompound?): ICapabilityProvider? {
        return if (item.item === ModItems.grimoire) GrimoireProvider() else null
    }

    override fun getShareTag(): Boolean {
        return true
    }

    override fun getNBTShareTag(stack: ItemStack): NBTTagCompound? {
        var tag = super.getNBTShareTag(stack)
        if (tag == null)
            tag = NBTTagCompound()

        val grimoireHandler = stack.cap(CAPABILITY_GRIMOIRE)
        val tagShare = GrimoireStorage.getNbtBase(grimoireHandler)
        tag.setTag(TAG_SHARE, tagShare)
        return tag
    }

    override fun readNBTShareTag(stack: ItemStack, nbt: NBTTagCompound?) {
        super.readNBTShareTag(stack, nbt)
        if (nbt == null)
            return

        val grimoireHandler = stack.cap(CAPABILITY_GRIMOIRE)
        val tagShare = nbt.getCompoundTag(TAG_SHARE)
        GrimoireStorage.readNbtBase(grimoireHandler, tagShare)
    }

    companion object {
        const val SLOT_COUNT = 27
        private const val TAG_SHARE = "Grimoire"
    }
}

