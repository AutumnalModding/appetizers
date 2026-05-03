package gdn.hypercube.appetizers.util.effect;

import com.mojang.serialization.MapCodec;
import gdn.hypercube.appetizers.util.WeightedRandom;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

// Multiple Random Effects, not Meal Ready-to-Eat.
public record MREConsumeEffect() implements ConsumeEffect {
    public static final MREConsumeEffect INSTANCE = new MREConsumeEffect();
    public static final MapCodec<MREConsumeEffect> CODEC = MapCodec.unit(INSTANCE);
    public static final PacketCodec<RegistryByteBuf, MREConsumeEffect> PACKET_CODEC = PacketCodec.unit(INSTANCE);

    public static final Type<MREConsumeEffect> TYPE = new Type<>(CODEC, PACKET_CODEC);
    private static final WeightedRandom<Integer> AMOUNT_RANDOM = new WeightedRandom<>();
    
    @Override
    public Type<? extends ConsumeEffect> getType() {
        return TYPE;
    }

    @Override
    public boolean onConsume(World world, ItemStack stack, LivingEntity user) {
        Random random = user.getRandom();

        List<StatusEffectInstance> effects = new ArrayList<>();
        for (int index = 0; index < AMOUNT_RANDOM.next(); index++) {
            StatusEffect effect = RandomEffectConsumeEffect.EFFECTS.get(random.nextBetween(0, RandomEffectConsumeEffect.EFFECTS.size()-1));
            effects.add(new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(effect), RandomEffectConsumeEffect.TIME_RANDOM.next(), RandomEffectConsumeEffect.LEVEL_RANDOM.next()));
        }

        for (StatusEffectInstance instance : effects) {
            user.addStatusEffect(instance);
        }

        return true;
    }

    static {
        AMOUNT_RANDOM.add(1, 25);
        AMOUNT_RANDOM.add(2, 60);
        AMOUNT_RANDOM.add(3, 55);
        AMOUNT_RANDOM.add(4, 40);
        AMOUNT_RANDOM.add(5, 10);
    }
}
