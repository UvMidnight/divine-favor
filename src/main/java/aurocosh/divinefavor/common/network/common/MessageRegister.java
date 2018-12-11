package aurocosh.divinefavor.common.network.common;

import aurocosh.divinefavor.common.network.message.*;
import net.minecraftforge.fml.relauncher.Side;

public class MessageRegister {
	public static void init() {
        NetworkHandler.register(MessageDataSync.class, Side.CLIENT);
        NetworkHandler.register(MessagePartialDataSync.class, Side.CLIENT);
		NetworkHandler.register(MessageSyncPower.class, Side.CLIENT);
        NetworkHandler.register(MessageSyncFavor.class, Side.CLIENT);
        NetworkHandler.register(MessageSyncPotionCharge.class, Side.CLIENT);
	}
}