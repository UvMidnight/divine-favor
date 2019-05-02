package aurocosh.divinefavor.common.network.message.client.syncing

import aurocosh.divinefavor.DivineFavor
import aurocosh.divinefavor.common.custom_data.player.PlayerData
import aurocosh.divinefavor.common.network.base.WrappedClientMessage
import net.minecraft.util.math.Vec3d
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class MessageSyncRedFury : WrappedClientMessage {
    var vector: Vec3d = Vec3d.ZERO

    constructor() {}

    constructor(vector: Vec3d) {
        this.vector = vector
    }

    @SideOnly(Side.CLIENT)
    override fun handleSafe() {
        val player = DivineFavor.proxy.clientPlayer
        val redFuryData = PlayerData[player]!!.redFuryData
        redFuryData.vector = vector
    }
}
