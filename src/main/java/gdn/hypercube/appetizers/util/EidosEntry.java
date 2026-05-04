package gdn.hypercube.appetizers.util;

import java.util.List;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public record EidosEntry(
        Vec3d position,
        float health,
        int fireTicks,
        int frostTicks,
        int age,
        float sideways,
        float upward,
        float forward,
        float yaw,
        Pair<Float, Float> limbYaw,
        Pair<Float, Float> lastYaw,
        Pair<Float, Float> pitch,
        Pair<Vec3d, Vec3d> rotation,
        List<StatusEffectInstance> effects,
        @Nullable PlayerSpecific playerdata
) {
    public record PlayerSpecific(int hunger, float saturation, int level, int total, float progress) {}
}
