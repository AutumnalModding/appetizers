package gdn.hypercube.appetizers.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;

public class NonUpdatingSEI extends StatusEffectInstance {
    public NonUpdatingSEI(RegistryEntry<StatusEffect> effect, int duration, int amplifier) {
        super(effect, duration, amplifier);
    }

    @Override public void tickClient() { /* NOP */ }
    @Override public boolean update(ServerWorld world, LivingEntity entity, Runnable hiddenEffectCallback) { return false; }
}
