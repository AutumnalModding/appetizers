package gdn.hypercube.appetizers.init;

import gdn.hypercube.appetizers.item.AppetizingFoodItem;
import gdn.hypercube.appetizers.util.effect.KimchiConsumeEffect;
import gdn.hypercube.appetizers.util.effect.RandomEffectConsumeEffect;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.sound.SoundEvents;

public class AppetizersSoups {
    private static final List<StatusEffectInstance> eden = new ArrayList<>();
    private static final List<StatusEffectInstance> aesir = new ArrayList<>();

    public static void init() {
        AppetizersInit.register(new AppetizingFoodItem("aesir", "", false, 20, 20, SoundEvents.ENTITY_GENERIC_EAT, 6F, new ApplyEffectsConsumeEffect(aesir)), "aesir");
        AppetizersInit.register(new AppetizingFoodItem("bisque", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "bisque");
        AppetizersInit.register(new AppetizingFoodItem("blindingstew", "Feed her a stew that makes her go blind.", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1200))), "blindingstew");
        AppetizersInit.register(new AppetizingFoodItem("caesar", "TWENTY-THREE STAB WOUNDS", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "caesar");
        AppetizersInit.register(new AppetizingFoodItem("citrusdelight", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "citrusdelight");
        AppetizersInit.register(new AppetizingFoodItem("coleslaw", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "coleslaw");
        AppetizersInit.register(new AppetizingFoodItem("eden", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F, new ApplyEffectsConsumeEffect(eden)), "eden");
        AppetizersInit.register(new AppetizingFoodItem("escargot", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 4))), "escargot");
        AppetizersInit.register(new AppetizingFoodItem("eyeball", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "eyeball");
        AppetizersInit.register(new AppetizingFoodItem("gumbo", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "gumbo");
        AppetizersInit.register(new AppetizingFoodItem("kimchi", "Can you handle the spice?", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F, KimchiConsumeEffect.INSTANCE), "kimchi");
        AppetizersInit.register(new AppetizingFoodItem("meatball", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "meatball");
        AppetizersInit.register(new AppetizingFoodItem("miso", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "miso");
        AppetizersInit.register(new AppetizingFoodItem("monkeydelight", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "monkeydelight");
        AppetizersInit.register(new AppetizingFoodItem("mystery", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F, RandomEffectConsumeEffect.INSTANCE), "mystery");
        AppetizersInit.register(new AppetizingFoodItem("rice-egg", "You're telling me a shrimp fried this rice?", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "rice-egg");
        AppetizersInit.register(new AppetizingFoodItem("rice-pork", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1))), "rice-pork");
        AppetizersInit.register(new AppetizingFoodItem("rice-pudding", "Neptune's favourite.", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "rice-pudding");
        AppetizersInit.register(new AppetizingFoodItem("rice", "", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "rice");
        AppetizersInit.register(new AppetizingFoodItem("valid", "Killsign sold separately.", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "valid");
    }

    static {
        aesir.add(new StatusEffectInstance(StatusEffects.GLOWING, 1200));
        aesir.add(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200));
        aesir.add(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.HASTE, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.SPEED, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 20, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200, 4));
        aesir.add(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200, 4));

        eden.add(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1));
        eden.add(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1));
        eden.add(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 1));
        eden.add(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 1));
        eden.add(new StatusEffectInstance(StatusEffects.HASTE, 600, 1));
        eden.add(new StatusEffectInstance(StatusEffects.SPEED, 600, 1));
        eden.add(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1));
        eden.add(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 600, 1));
    }
}
