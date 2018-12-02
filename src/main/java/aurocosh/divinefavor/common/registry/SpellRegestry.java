package aurocosh.divinefavor.common.registry;

import aurocosh.divinefavor.common.spell.base.ModSpell;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class SpellRegestry {
    private static ArrayList<ModSpell> list = new ArrayList<>();

    public static void register(ModSpell spell) {
        list.add(spell);
    }

    @SubscribeEvent
    public void registerAll(RegistryEvent.Register<ModSpell> event) {
        IForgeRegistry registry = event.getRegistry();
        for (ModSpell spell : list)
            registry.register(spell);
    }
}


