package aurocosh.divinefavor.common.entity.minions.behaviour;

import aurocosh.divinefavor.common.entity.ai.EntityAIFollowOwner;
import aurocosh.divinefavor.common.entity.ai.EntityAIMinionWait;
import aurocosh.divinefavor.common.entity.ai.EntityAIOwnerHurtByTarget;
import aurocosh.divinefavor.common.entity.ai.EntityAIOwnerOrderedToAttack;
import aurocosh.divinefavor.common.entity.minions.base.IMinion;
import aurocosh.divinefavor.common.entity.minions.base.MinionData;
import aurocosh.divinefavor.common.entity.minions.behaviour.base.MinionBehaviour;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;

public class MinionBehaviourCreeper<T extends EntityCreeper & IMinion> extends MinionBehaviour<T> {
    @Override
    public void apply(T minion, EntityAITasks tasks, EntityAITasks targetTasks) {
        MinionData minionData = minion.getMinionData();

        tasks.addTask(0, new EntityAISwimming(minion));
        tasks.addTask(1, new EntityAICreeperSwell(minion));
        tasks.addTask(2, new EntityAIAvoidEntity<>(minion, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
        tasks.addTask(3, new EntityAIFollowOwner<>(minion, 2.0D, 5.0F, 2.0F, true, minionData::isFollowing));
        tasks.addTask(4, new EntityAIMinionWait<>(minion, () -> minionData.isFollowing() || minionData.isWaiting()));
        tasks.addTask(5, new EntityAIAttackMelee(minion, 1.0D, false));
        tasks.addTask(6, new EntityAIFollowOwner<>(minion, 2.0D, 5.0F, 2.0F, false, () -> true));
        tasks.addTask(7, new EntityAIWanderAvoidWater(minion, 0.8D));
        tasks.addTask(8, new EntityAIWatchClosest(minion, EntityPlayer.class, 8.0F));
        tasks.addTask(8, new EntityAILookIdle(minion));

        targetTasks.addTask(1, new EntityAIOwnerHurtByTarget<>(minion));
        targetTasks.addTask(2, new EntityAIOwnerOrderedToAttack<>(minion, minionData));
        targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(minion, EntityLiving.class, 0, true, true, minionData::shouldAttack));
        targetTasks.addTask(4, new EntityAIHurtByTarget(minion, false));
    }
}