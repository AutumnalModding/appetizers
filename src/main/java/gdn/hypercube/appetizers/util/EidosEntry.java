package gdn.hypercube.appetizers.util;

import java.util.List;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Vec3d;

public record EidosEntry(Vec3d position, float health, int fireTicks, int frostTicks, List<StatusEffectInstance> effects) {
}
