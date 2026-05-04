package gdn.hypercube.appetizers.effect;

import gdn.hypercube.appetizers.init.AppetizersInit;
import gdn.hypercube.appetizers.util.EidosEntry;
import gdn.hypercube.appetizers.util.NonUpdatingSEI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Vec3d;

public class ChronoAnchorAtHome extends StatusEffect {
    private static final HashMap<UUID, EidosEntry> EIDOS_CHANGELOG = new HashMap<>();

    public ChronoAnchorAtHome() {
        super(StatusEffectCategory.BENEFICIAL, 0xC49E5B);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        UUID uuid = entity.getUuid();
        if (!EIDOS_CHANGELOG.containsKey(uuid)) {
            List<NonUpdatingSEI> effects = new ArrayList<>();
            entity.getStatusEffects().forEach(instance -> {
                if (instance.getEffectType() != AppetizersInit.CHRONO_ANCHOR) {
                    effects.add(new NonUpdatingSEI(instance.getEffectType(), instance.getDuration(), instance.getAmplifier()));
                }
            });

            EidosEntry.PlayerSpecific data = null;
            if (entity instanceof PlayerEntity player) {
                HungerManager manager = player.getHungerManager();
                data = new EidosEntry.PlayerSpecific(
                        manager.getFoodLevel(),
                        manager.getSaturationLevel(),
                        player.experienceLevel,
                        player.totalExperience,
                        player.experienceProgress
                );
            }

            EidosEntry entry = new EidosEntry(
                    entity.getEntityPos(),
                    entity.getHealth(),
                    entity.getFireTicks(),
                    entity.getFrozenTicks(),
                    entity.age,
                    entity.sidewaysSpeed,
                    entity.upwardSpeed,
                    entity.forwardSpeed,
                    entity.getYaw(),
                    new Pair<>(entity.bodyYaw, entity.headYaw),
                    new Pair<>(entity.lastBodyYaw, entity.lastHeadYaw),
                    new Pair<>(entity.getPitch(), entity.lastPitch),
                    new Pair<>(entity.getRotationVector(), entity.getHeadRotationVector()),
                    effects,
                    data
            );
            EIDOS_CHANGELOG.put(uuid, entry);
        }

        StatusEffectInstance effect = entity.getStatusEffect(AppetizersInit.CHRONO_ANCHOR);
        if (effect != null) {
            Vec3d pos = entity.getEntityPos();
            int duration = effect.getDuration();
            if (duration % 200 == 0) {
                world.playSound(null, pos.x, pos.y, pos.z, SoundEvents.BLOCK_BELL_USE, SoundCategory.PLAYERS, 1F, 0F);
            }

            if (duration == 50) {
                world.playSound(null, pos.x, pos.y, pos.z, SoundEvents.BLOCK_BELL_RESONATE, SoundCategory.PLAYERS, 10F, 1F);
            }

            if (duration <= 1) {
                EidosEntry entry = EIDOS_CHANGELOG.get(uuid);
                entity.requestTeleport(entry.position().x, entry.position().y, entry.position().z);
                entity.setAngles(entry.pitch().getLeft(), entry.yaw());
                entity.setHealth(entry.health());
                entity.setFireTicks(entry.fireTicks());
                entity.setFrozenTicks(entry.frostTicks());
                entity.age = entry.age();
                entity.sidewaysSpeed = entry.sideways();
                entity.upwardSpeed = entry.upward();
                entity.forwardSpeed = entry.forward();
                entity.bodyYaw = entry.limbYaw().getLeft();
                entity.headYaw = entry.limbYaw().getRight();
                entity.lastBodyYaw = entry.lastYaw().getLeft();
                entity.lastHeadYaw = entry.lastYaw().getRight();
                entity.lastPitch = entry.pitch().getRight();

                for (StatusEffectInstance instance : entity.getStatusEffects()) {
                    if (instance.getEffectType() != AppetizersInit.CHRONO_ANCHOR) {
                        entity.removeStatusEffect(instance.getEffectType());
                    }
                }
                for (StatusEffectInstance instance : entry.effects()) {
                    entity.addStatusEffect(new StatusEffectInstance(instance.getEffectType(), instance.getDuration(), instance.getAmplifier()));
                }

                if (entity instanceof PlayerEntity player) {
                    EidosEntry.PlayerSpecific data = entry.playerdata();
                    HungerManager manager = player.getHungerManager();
                    manager.setFoodLevel(data.hunger());
                    manager.setSaturationLevel(data.saturation());
                    player.experienceLevel = data.level();
                    player.totalExperience = data.total();
                    player.experienceProgress = data.progress();
                }

                EIDOS_CHANGELOG.remove(entity.getUuid());
            }

        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
