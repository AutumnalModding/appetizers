package gdn.hypercube.appetizers.effect;

import gdn.hypercube.appetizers.init.AppetizersInit;
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
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class HeartAttackStatusEffect extends StatusEffect {
    public HeartAttackStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0xFF0000);
    }
    public static final RegistryKey<DamageType> DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("appetizers", "sheer_heart_attack"));

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        System.out.println("Updating effect");
        StatusEffectInstance effect = entity.getStatusEffect(AppetizersInit.HEART_ATTACK);
        if (effect != null) {
            int duration = effect.getDuration();

            DamageSource source = new DamageSource(
                    world.getRegistryManager()
                            .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                            .getEntry(DAMAGE.getValue()).orElseThrow()
            );
            switch (duration) {
                case 900: {
                    entity.damage(world, source, 3.15F);
                    break;
                }

                case 600: {
                    entity.damage(world, source, 6.25F);
                    break;
                }

                case 300: {
                    entity.damage(world, source, 12.75F);
                    break;
                }

                case 150: {
                    entity.damage(world, source, 17.5F);
                    break;
                }

                case 1: {
                    entity.damage(world, source, Float.MAX_VALUE);
                }
            }
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
