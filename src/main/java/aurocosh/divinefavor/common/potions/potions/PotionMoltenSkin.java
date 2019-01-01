package aurocosh.divinefavor.common.potions.potions;

import aurocosh.divinefavor.common.damage_source.ModDamageSources;
import aurocosh.divinefavor.common.player_data.molten_skin.IMoltenSkinHandler;
import aurocosh.divinefavor.common.potions.base.potion.ModPotionToggle;
import aurocosh.divinefavor.common.potions.common.ModPotions;
import aurocosh.divinefavor.common.util.UtilEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static aurocosh.divinefavor.common.player_data.molten_skin.MoltenSkinDataHandler.CAPABILITY_MOLTEN_SKIN;


@Mod.EventBusSubscriber
public class PotionMoltenSkin extends ModPotionToggle {
    private static float SPEED_MODIFIER = 0.14f;
    private static int FRAMES_TO_INIT_FOG = 5;

    private static int intitFrames = FRAMES_TO_INIT_FOG;

    public PotionMoltenSkin() {
        super("molten_skin", true, 0x7FB8A4);
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBase, int amplifier) {
        if (!(entityLivingBase instanceof EntityPlayer))
            return;

        EntityPlayer player = (EntityPlayer) entityLivingBase;
        IMoltenSkinHandler skinHandler = player.getCapability(CAPABILITY_MOLTEN_SKIN, null);
        assert skinHandler != null;

        if (entityLivingBase.isInLava()) {
            skinHandler.resetTime();
            return;
        }
        else if(entityLivingBase.isInWater())
            skinHandler.setMaxTime();

        if (!skinHandler.tick())
            return;

        player.attackEntityFrom(ModDamageSources.frostDamage, 4);
        skinHandler.delay();
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onFogDensity(EntityViewRenderEvent.FogDensity event) {
        if (isInLavaWithMoltenSkin(event)) {
            if (intitFrames-- <= 0) {
                event.setDensity(0.2F);
                event.setCanceled(true);
            }
        }
        else
            intitFrames = FRAMES_TO_INIT_FOG;
//        GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_EXP);
    }

    @SubscribeEvent
    public static void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        if (entity == null)
            return;
        if (!entity.isPotionActive(ModPotions.molten_skin))
            return;
        if (!entity.isInsideOfMaterial(Material.LAVA))
            return;
        UtilEntity.addVelocity(entity, SPEED_MODIFIER);
    }

    private static boolean isInLavaWithMoltenSkin(EntityViewRenderEvent event) {
//        if (event.getState().getMaterial() != Material.LAVA)
//            return false;
        Entity entity = event.getEntity();
        if (!entity.isInLava())
            return false;
        if (!(entity instanceof EntityPlayer))
            return false;
        EntityPlayer player = (EntityPlayer) entity;
        return player.isPotionActive(ModPotions.molten_skin);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
