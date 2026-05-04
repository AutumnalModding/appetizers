package gdn.hypercube.appetizers.effect;

import gdn.hypercube.appetizers.init.AppetizersInit;
import gdn.hypercube.appetizers.util.EidosEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;

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
            List<StatusEffectInstance> effects = new ArrayList<>();
            entity.getStatusEffects().forEach(instance -> {
                if (instance.getEffectType() != AppetizersInit.CHRONO_ANCHOR) {
                    effects.add(instance);
                }
            });
            EidosEntry entry = new EidosEntry(entity.getEntityPos(), entity.getHealth(), entity.getFireTicks(), entity.getFrozenTicks(), effects);
            EIDOS_CHANGELOG.put(uuid, entry);
        }

        StatusEffectInstance effect = entity.getStatusEffect(AppetizersInit.CHRONO_ANCHOR);
        if (effect != null && effect.getDuration() <= 1) {
            EidosEntry entry = EIDOS_CHANGELOG.get(uuid);
            entity.teleport(entry.position().x, entry.position().y, entry.position().z, false);
            entity.setHealth(entry.health());
            entity.setFireTicks(entry.fireTicks());
            entity.setFrozenTicks(entry.frostTicks());
            for (StatusEffectInstance instance : entity.getStatusEffects()) {
                if (instance.getEffectType() != AppetizersInit.CHRONO_ANCHOR) {
                    entity.removeStatusEffect(instance.getEffectType());
                }
            }

            for (StatusEffectInstance instance : entry.effects()) {
                entity.addStatusEffect(instance);
            }
            EIDOS_CHANGELOG.remove(entity.getUuid());
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
