package gdn.hypercube.appetizers.effect;

import gdn.hypercube.appetizers.init.AppetizersInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import net.minecraft.world.explosion.ExplosionImpl;

public class TimeBombStatusEffect extends StatusEffect {
    public static final RegistryKey<DamageType> DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("appetizers", "timebomb"));

    public TimeBombStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0xC49E5B);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        StatusEffectInstance effect = entity.getStatusEffect(AppetizersInit.TIMEBOMB);
        if (effect != null) {
            int duration = effect.getDuration();

            Vec3d pos = entity.getEntityPos();
            if (entity instanceof PlayerEntity player) {
                if (duration % 200 == 0) {
                    player.sendOverlayMessage(Text.literal("Tick...").formatted(Formatting.RED));
                    world.playSound(null, pos.x, pos.y, pos.z, SoundEvents.UI_BUTTON_CLICK, SoundCategory.PLAYERS, 1F, 1F);
                } else if (duration % 200 == 100) {
                    player.sendOverlayMessage(Text.literal("Tock..").formatted(Formatting.RED));
                    world.playSound(null, pos.x, pos.y, pos.z, SoundEvents.UI_BUTTON_CLICK, SoundCategory.PLAYERS, 1F, 0.75F);
                }
            }

            if (duration <= 1) {
                DamageSource source = new DamageSource(
                        world.getRegistryManager()
                                .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                                .getEntry(DAMAGE.getValue()).orElseThrow()
                );

                world.playSound(null, pos.x, pos.y, pos.z, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1F, 1F);
                ExplosionImpl explosion = new ExplosionImpl(world, null, source, new Behaviour(), entity.getEntityPos(), 10, false, Explosion.DestructionType.KEEP);
                explosion.explode();
            }
        }

        return true;
    }

    private static class Behaviour extends ExplosionBehavior {
        @Override
        public boolean shouldDamage(Explosion explosion, Entity entity) {
            return entity instanceof PlayerEntity;
        }

        @Override
        public boolean canDestroyBlock(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float power) {
            return false;
        }

        @Override
        public float calculateDamage(Explosion explosion, Entity entity, float amount) {
            return Float.MAX_VALUE;
        }
    }
}
