package aurocosh.divinefavor.common.network.message.client;

import aurocosh.divinefavor.DivineFavor;
import aurocosh.divinefavor.common.custom_data.player.PlayerData;
import aurocosh.divinefavor.common.custom_data.player.data.spell.focused_fury.FocusedFuryData;
import aurocosh.divinefavor.common.network.base.NetworkWrappedClientMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageSyncFury extends NetworkWrappedClientMessage {
    public String mobTypeId;

    public MessageSyncFury() {
    }

    public MessageSyncFury(ResourceLocation mobTypeId) {
        this.mobTypeId = mobTypeId.toString();
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected void handleSafe() {
        EntityPlayer player = DivineFavor.proxy.getClientPlayer();
        FocusedFuryData furyData = PlayerData.get(player).getFocusedFuryData();
        furyData.setMobTypeId(new ResourceLocation(mobTypeId));
    }
}
