package gdn.hypercube.appetizers.init;

import gdn.hypercube.appetizers.item.AppetizingFoodItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.sound.SoundEvents;

public class AppetizersIceCreams {
    private static final StatusEffectInstance regen = new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1);

    public static void init() {
        AppetizersInit.register(new AppetizingFoodItem("bananasplit", "", true, 5, 2, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 2F), "bananasplit");
        AppetizersInit.register(new AppetizingFoodItem("blooddrop", "Disclaimer: not made with actual blood.\n\nWe think.", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F, new ApplyEffectsConsumeEffect(regen)), "blooddrop");
        AppetizersInit.register(new AppetizingFoodItem("caramel", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "caramel");
        AppetizersInit.register(new AppetizingFoodItem("choco", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "choco");
        AppetizersInit.register(new AppetizingFoodItem("coconut", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "coconut");
        AppetizersInit.register(new AppetizingFoodItem("coffee", "Yes, it's real coffee.", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F,  new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 1))), "coffee");
        AppetizersInit.register(new AppetizingFoodItem("greentea", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "greentea");
        AppetizersInit.register(new AppetizingFoodItem("hazelnut", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "hazelnut");
        AppetizersInit.register(new AppetizingFoodItem("lemon", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "lemon");
        AppetizersInit.register(new AppetizingFoodItem("mintchoco", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "mintchoco");
        AppetizersInit.register(new AppetizingFoodItem("neapolitan", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "neapolitan");
        AppetizersInit.register(new AppetizingFoodItem("orange", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "orange");
        AppetizersInit.register(new AppetizingFoodItem("rainbow", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "rainbow");
        AppetizersInit.register(new AppetizingFoodItem("rockyroad", "Now with \"real\" asphalt.", true, 8, 3, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 4.5F), "rockyroad");
        AppetizersInit.register(new AppetizingFoodItem("saltedcaramel", "Salted, not hashed.", true, 5, 1, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.75F), "saltedcaramel");
        AppetizersInit.register(new AppetizingFoodItem("spaghetti", "Just like your mother used to make...?", true, 6, 8, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 4.15F), "spaghetti");
        AppetizersInit.register(new AppetizingFoodItem("strawberry", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "strawberry");
        AppetizersInit.register(new AppetizingFoodItem("vanilla", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "vanilla");
        AppetizersInit.register(new AppetizingFoodItem("walnut", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "walnut");
        AppetizersInit.register(new AppetizingFoodItem("watermelon", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "watermelon");
    }
}
