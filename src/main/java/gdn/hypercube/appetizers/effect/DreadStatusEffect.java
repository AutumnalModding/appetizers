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

public class DreadStatusEffect extends StatusEffect {
    public static final RegistryKey<DamageType> DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("appetizers", "dread"));

    public DreadStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x000000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        StatusEffectInstance effect = entity.getStatusEffect(AppetizersInit.DREAD);
        if (effect != null) {
            int duration = effect.getDuration();

            if (entity instanceof PlayerEntity player) {
                switch (duration) {
                    case 6000: {
                        player.sendOverlayMessage(Text.literal("Your mind goes numb...").formatted(Formatting.RED));
                        break;
                    }

                    case 1200: {
                        player.sendOverlayMessage(Text.literal("You are overwhelmed with pain...").formatted(Formatting.RED));
                        break;
                        }

                    case 600: {
                        player.sendOverlayMessage(Text.literal("Impending doom approaches...").formatted(Formatting.RED));
                        break;
                    }
                }
            }

            if (duration <= 1) {
                DamageSource source = new DamageSource(
                        world.getRegistryManager()
                                .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                                .getEntry(DAMAGE.getValue()).orElseThrow()
                );
                entity.damage(world, source, Float.MAX_VALUE);
            }
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
