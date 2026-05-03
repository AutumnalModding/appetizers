package gdn.hypercube.appetizers.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CogchampStatusEffect extends StatusEffect {
    public CogchampStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0xC49E5B);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
