package gdn.hypercube.appetizers.util.effect;

import com.mojang.serialization.MapCodec;
import gdn.hypercube.appetizers.util.WeightedRandom;
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

public record RandomEffectConsumeEffect() implements ConsumeEffect {
    public static final RandomEffectConsumeEffect INSTANCE = new RandomEffectConsumeEffect();
    public static final MapCodec<RandomEffectConsumeEffect> CODEC = MapCodec.unit(INSTANCE);
    public static final PacketCodec<RegistryByteBuf, RandomEffectConsumeEffect> PACKET_CODEC = PacketCodec.unit(INSTANCE);

    public static final Type<RandomEffectConsumeEffect> TYPE = new Type<>(CODEC, PACKET_CODEC);

    static final List<StatusEffect> EFFECTS = Registries.STATUS_EFFECT.stream().toList();
    static final WeightedRandom<Integer> LEVEL_RANDOM = new WeightedRandom<>();
    static final WeightedRandom<Integer> TIME_RANDOM = new WeightedRandom<>();

    @Override
    public Type<? extends ConsumeEffect> getType() {
        return TYPE;
    }

    @Override
    public boolean onConsume(World world, ItemStack stack, LivingEntity user) {
        Random random = user.getRandom();
        StatusEffect effect = EFFECTS.get(random.nextBetween(0, EFFECTS.size()-1));
        user.addStatusEffect(new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(effect), TIME_RANDOM.next(), LEVEL_RANDOM.next()));
        return true;
    }

    static {
        LEVEL_RANDOM.add(0, 80);
        LEVEL_RANDOM.add(1, 50);
        LEVEL_RANDOM.add(2, 35);
        LEVEL_RANDOM.add(3, 20);
        LEVEL_RANDOM.add(4, 5);

        TIME_RANDOM.add(300, 50);
        TIME_RANDOM.add(600, 70);
        TIME_RANDOM.add(900, 40);
        TIME_RANDOM.add(1200, 25);
    }
}
