package aurocosh.divinefavor.client.block_ovelay

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound

class UniqueItemStack(stack: ItemStack) {
    val uniqueItem: UniqueItem
    val nbt: NBTTagCompound?

    init {
        uniqueItem = UniqueItem(stack.item, stack.metadata)
        nbt = stack.tagCompound
    }

    override fun equals(obj: Any?): Boolean {
        if (obj === this)
            return true

        if (obj !is UniqueItemStack)
            return false

        val other = obj as UniqueItemStack?
        return uniqueItem == other!!.uniqueItem && if (nbt != null) nbt == other.nbt else if (other.nbt != null) other.nbt == nbt else true
    }

    override fun hashCode(): Int {
        return uniqueItem.hashCode() xor (nbt?.hashCode() ?: 0)
    }
}