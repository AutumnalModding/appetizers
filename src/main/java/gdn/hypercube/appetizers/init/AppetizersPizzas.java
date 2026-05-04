package gdn.hypercube.appetizers.init;

import gdn.hypercube.appetizers.item.AppetizingFoodItem;
import net.minecraft.sound.SoundEvents;

public class AppetizersPizzas {
    public static void init() {
        AppetizersInit.register(new AppetizingFoodItem("vegetable", "", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "vegetable");
        AppetizersInit.register(new AppetizingFoodItem("margherita", "", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "margherita");
        AppetizersInit.register(new AppetizingFoodItem("meat", "", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "meat");
        AppetizersInit.register(new AppetizingFoodItem("pineapple", "Controversial!", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "pineapple");
        AppetizersInit.register(new AppetizingFoodItem("mushroom", "", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "mushroom");
        AppetizersInit.register(new AppetizingFoodItem("sassysage", "", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "sassysage");
        AppetizersInit.register(new AppetizingFoodItem("sausage", "", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "sausage");
        AppetizersInit.register(new AppetizingFoodItem("arnold", "", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "arnold");
        AppetizersInit.register(new AppetizingFoodItem("uranium-pizza", "", false, 16, 20, SoundEvents.ENTITY_GENERIC_EAT, 8.0F), "uranium-pizza");

        AppetizersInit.register(new AppetizingFoodItem("margherita-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "margherita-slice");
        AppetizersInit.register(new AppetizingFoodItem("meat-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "meat-slice");
        AppetizersInit.register(new AppetizingFoodItem("mushroom-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "mushroom-slice");
        AppetizersInit.register(new AppetizingFoodItem("pineapple-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "pineapple-slice");
        AppetizersInit.register(new AppetizingFoodItem("sassysage-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "sassysage-slice");
        AppetizersInit.register(new AppetizingFoodItem("sausage-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "sausage-slice");
        AppetizersInit.register(new AppetizingFoodItem("arnold-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "arnold-slice");
        AppetizersInit.register(new AppetizingFoodItem("uranium-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "uranium-slice");
        AppetizersInit.register(new AppetizingFoodItem("vegetable-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.35F), "vegetable-slice");
    }
}
