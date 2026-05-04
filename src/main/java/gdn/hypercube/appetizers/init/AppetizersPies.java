package gdn.hypercube.appetizers.init;

import gdn.hypercube.appetizers.item.AppetizingFoodItem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.sound.SoundEvents;

public class AppetizersPies {
    private static final List<StatusEffectInstance> gapple = new ArrayList<>();

    public static void init() {
        AppetizersInit.register(new AppetizingFoodItem("plainpie", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "plainpie");
        AppetizersInit.register(new AppetizingFoodItem("gapple", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F, new ApplyEffectsConsumeEffect(gapple)), "gapple");
        AppetizersInit.register(new AppetizingFoodItem("applepie", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "applepie");
        AppetizersInit.register(new AppetizingFoodItem("happy", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "happy");
        AppetizersInit.register(new AppetizingFoodItem("grape", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "grape");
        AppetizersInit.register(new AppetizingFoodItem("baklava", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "baklava");
        AppetizersInit.register(new AppetizingFoodItem("meatpie", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "meatpie");
        AppetizersInit.register(new AppetizingFoodItem("mime", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "mime");
        AppetizersInit.register(new AppetizingFoodItem("xeno", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "xeno");
        AppetizersInit.register(new AppetizingFoodItem("cocolava", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "cocolava");
        AppetizersInit.register(new AppetizingFoodItem("frosty", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "frosty");
        AppetizersInit.register(new AppetizingFoodItem("cherry", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "cherry");
        AppetizersInit.register(new AppetizingFoodItem("berryclafoutis", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 6.5F), "berryclafoutis");

        AppetizersInit.register(new AppetizingFoodItem("baklava-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.0F), "baklava-slice");
        AppetizersInit.register(new AppetizingFoodItem("plainpie-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.0F), "plainpie-slice");
        AppetizersInit.register(new AppetizingFoodItem("mimetart-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.0F), "mimetart-slice");
    }

    static {
        gapple.add(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000));
        gapple.add(new StatusEffectInstance(StatusEffects.REGENERATION, 6000, 1));
        gapple.add(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 1));
        gapple.add(new StatusEffectInstance(StatusEffects.ABSORPTION, 6000, 1));
    }
}
