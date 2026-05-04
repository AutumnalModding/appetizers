package gdn.hypercube.appetizers.init;

import gdn.hypercube.appetizers.item.AppetizingFoodItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.sound.SoundEvents;

public class AppetizersMiscFood {
    public static void init() {
        AppetizersInit.register(new AppetizingFoodItem("avocadosushi", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 4.75F), "avocadosushi");
        AppetizersInit.register(new AppetizingFoodItem("avocadosushislice", "", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F), "avocadosushislice");
        AppetizersInit.register(new AppetizingFoodItem("carpsushi", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 4.75F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 3))), "carpsushi");
        AppetizersInit.register(new AppetizingFoodItem("carpsushislice", "", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 100))), "carpsushislice");
        AppetizersInit.register(new AppetizingFoodItem("freshsushi", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 4.75F), "freshsushi");
        AppetizersInit.register(new AppetizingFoodItem("freshsushislice", "", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F), "freshsushislice");
        AppetizersInit.register(new AppetizingFoodItem("gassushislice", "This is almost certainly unsafe.", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 3))), "gassushislice");
        AppetizersInit.register(new AppetizingFoodItem("sashimi", "Are you sure this was prepared correctly...?", false, 12, 8, SoundEvents.ENTITY_GENERIC_EAT, 4F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1))), "sashimi");

        AppetizersInit.register(new AppetizingFoodItem("bacon", "", false, 8, 6, SoundEvents.ENTITY_GENERIC_EAT, 2.75F), "bacon");
        AppetizersInit.register(new AppetizingFoodItem("bigbite", "Tall, not wide.", false, 15, 15, SoundEvents.ENTITY_GENERIC_EAT, 6.25F), "bigbite");
        AppetizersInit.register(new AppetizingFoodItem("cheese", "", false, 6, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "cheese");
        AppetizersInit.register(new AppetizingFoodItem("cheesealt", "", false, 9, 6, SoundEvents.ENTITY_GENERIC_EAT, 3F), "cheesealt");
        AppetizersInit.register(new AppetizingFoodItem("chicken", "", false, 8, 6, SoundEvents.ENTITY_GENERIC_EAT, 2.75F), "chicken");
        AppetizersInit.register(new AppetizingFoodItem("mcrib", "Legally distinct.", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 3.25F), "mcrib");
        AppetizersInit.register(new AppetizingFoodItem("plain", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "plain");
        AppetizersInit.register(new AppetizingFoodItem("superbite", "You might need to unhinge your jaw for this one.", false, 20, 20, SoundEvents.ENTITY_GENERIC_EAT, 12.5F), "superbite");

        AppetizersInit.register(new AppetizingFoodItem("cornuto", "", false, 4, 2, SoundEvents.ENTITY_GENERIC_EAT, 1.45F), "cornuto");
        AppetizersInit.register(new AppetizingFoodItem("sandwich", "Not made by Google.", false, 6, 3, SoundEvents.ENTITY_GENERIC_EAT, 2.15F), "sandwich");
        AppetizersInit.register(new AppetizingFoodItem("sandwich-strawberry", "", false, 6, 3, SoundEvents.ENTITY_GENERIC_EAT, 2.15F), "sandwich-strawberry");

        AppetizersInit.register(new AppetizingFoodItem("enchiladas", "", false, 16, 10, SoundEvents.ENTITY_GENERIC_EAT, 5.25F), "enchiladas");
        AppetizersInit.register(new AppetizingFoodItem("hotdog", "", false, 6, 3, SoundEvents.ENTITY_GENERIC_EAT, 2F), "hotdog");
        AppetizersInit.register(new AppetizingFoodItem("omelette", "", false, 12, 8, SoundEvents.ENTITY_GENERIC_EAT, 4F), "omelette");
        AppetizersInit.register(new AppetizingFoodItem("ribs", "", false, 12, 8, SoundEvents.ENTITY_GENERIC_EAT, 4F), "ribs");
        AppetizersInit.register(new AppetizingFoodItem("yakiimo", "", false, 10, 6, SoundEvents.ENTITY_GENERIC_EAT, 3.5F), "yakiimo");

        AppetizersInit.register(new AppetizingFoodItem("rice_pile", "", false, 2, 0, SoundEvents.ENTITY_GENERIC_EAT, 0.5F), "rice_pile");
    }
}
