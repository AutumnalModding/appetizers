package gdn.hypercube.appetizers.util.effect;

import com.mojang.serialization.MapCodec;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.world.World;

public record AntifreezeConsumeEffect() implements ConsumeEffect {
    public static final AntifreezeConsumeEffect INSTANCE = new AntifreezeConsumeEffect();
    public static final MapCodec<AntifreezeConsumeEffect> CODEC = MapCodec.unit(INSTANCE);
    public static final PacketCodec<RegistryByteBuf, AntifreezeConsumeEffect> PACKET_CODEC = PacketCodec.unit(INSTANCE);

    public static final Type<AntifreezeConsumeEffect> TYPE = new Type<>(CODEC, PACKET_CODEC);

    @Override
    public Type<? extends ConsumeEffect> getType() {
        return TYPE;
    }

    @Override
    public boolean onConsume(World world, ItemStack stack, LivingEntity user) {
        user.setFrozenTicks(0);
        return true;
    }
}
