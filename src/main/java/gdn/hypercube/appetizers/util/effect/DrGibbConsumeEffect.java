package gdn.hypercube.appetizers.util.effect;

import com.mojang.serialization.MapCodec;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public record DrGibbConsumeEffect() implements ConsumeEffect {
    public static final DrGibbConsumeEffect INSTANCE = new DrGibbConsumeEffect();
    public static final MapCodec<DrGibbConsumeEffect> CODEC = MapCodec.unit(INSTANCE);
    public static final PacketCodec<RegistryByteBuf, DrGibbConsumeEffect> PACKET_CODEC = PacketCodec.unit(INSTANCE);

    public static final Type<DrGibbConsumeEffect> TYPE = new Type<>(CODEC, PACKET_CODEC);

    public static final RegistryKey<DamageType> DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("appetizers", "drgibb"));

    @Override
    public Type<? extends ConsumeEffect> getType() {
        return TYPE;
    }

    @Override
    public boolean onConsume(World world, ItemStack stack, LivingEntity user) {
        if (!world.isClient() && user.getRandom().nextBetween(1, 1000) == 1000) {
            DamageSource source = new DamageSource(
                    world.getRegistryManager()
                            .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                            .getEntry(DAMAGE.getValue()).orElseThrow()
            );
            user.damage((ServerWorld) world, source, 1000);
            return true;
        }
        return false;
    }
}
