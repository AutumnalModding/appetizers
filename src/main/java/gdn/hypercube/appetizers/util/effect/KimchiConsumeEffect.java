package gdn.hypercube.appetizers.util.effect;

import com.mojang.serialization.MapCodec;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public record KimchiConsumeEffect() implements ConsumeEffect {
    public static final KimchiConsumeEffect INSTANCE = new KimchiConsumeEffect();
    public static final MapCodec<KimchiConsumeEffect> CODEC = MapCodec.unit(INSTANCE);
    public static final PacketCodec<RegistryByteBuf, KimchiConsumeEffect> PACKET_CODEC = PacketCodec.unit(INSTANCE);

    public static final Type<KimchiConsumeEffect> TYPE = new Type<>(CODEC, PACKET_CODEC);

    public static final RegistryKey<DamageType> DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("appetizers", "kimchi"));
    
    @Override
    public Type<? extends ConsumeEffect> getType() {
        return TYPE;
    }

    @Override
    public boolean onConsume(World world, ItemStack stack, LivingEntity user) {
        if (!world.isClient()) {
            if (user.getRandom().nextBetween(0, 100) >= 30) {
                DamageSource source = new DamageSource(
                        world.getRegistryManager()
                                .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                                .getEntry(DAMAGE.getValue()).orElseThrow()
                );

                user.setOnFireForTicks(35);
                user.damage((ServerWorld) world, source, 2.5F);
                return true;
            }
        }
        return false;
    }
}
