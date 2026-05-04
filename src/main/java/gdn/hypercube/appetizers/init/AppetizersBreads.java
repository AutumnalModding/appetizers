package gdn.hypercube.appetizers.init;

import gdn.hypercube.appetizers.item.AppetizingFoodItem;
import net.minecraft.sound.SoundEvents;

public class AppetizersBreads {
    public static void init() {
        AppetizersInit.register(new AppetizingFoodItem("baguette", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 3.25F), "baguette");
        AppetizersInit.register(new AppetizingFoodItem("xenomeat", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 4.0F), "xenomeat");
        AppetizersInit.register(new AppetizingFoodItem("spidermeat", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 4.0F), "spidermeat");
        AppetizersInit.register(new AppetizingFoodItem("plainbread", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 4.0F), "plainbread");
        AppetizersInit.register(new AppetizingFoodItem("bananabread", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 4.0F), "bananabread");
        AppetizersInit.register(new AppetizingFoodItem("tofu", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 4.0F), "tofu");
        AppetizersInit.register(new AppetizingFoodItem("mimana", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 4.0F), "mimana");
        AppetizersInit.register(new AppetizingFoodItem("meatbread", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 4.0F), "meatbread");
        AppetizersInit.register(new AppetizingFoodItem("creamcheese", "", false, 10, 10, SoundEvents.ENTITY_GENERIC_EAT, 4.0F), "creamcheese");

        AppetizersInit.register(new AppetizingFoodItem("plain-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "plain-slice");
        AppetizersInit.register(new AppetizingFoodItem("meatbread-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "meatbread-slice");
        AppetizersInit.register(new AppetizingFoodItem("mimana-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "mimana-slice");
        AppetizersInit.register(new AppetizingFoodItem("spidermeat-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "spidermeat-slice");
        AppetizersInit.register(new AppetizingFoodItem("xenomeat-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "xenomeat-slice");
        AppetizersInit.register(new AppetizingFoodItem("creamcheese-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "creamcheese-slice");
        AppetizersInit.register(new AppetizingFoodItem("tofu-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "tofu-slice");
        AppetizersInit.register(new AppetizingFoodItem("buttered-toast", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "buttered-toast");
        AppetizersInit.register(new AppetizingFoodItem("jelly-toast", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "jelly-toast");
        AppetizersInit.register(new AppetizingFoodItem("french-toast", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "french-toast");
        AppetizersInit.register(new AppetizingFoodItem("garlic-slice", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "garlic-slice");
        AppetizersInit.register(new AppetizingFoodItem("grilled-cheese", "But can she make a grilled cheese?", false, 6, 6, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "grilled-cheese");
        AppetizersInit.register(new AppetizingFoodItem("crostini", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "crostini");

        AppetizersInit.register(new AppetizingFoodItem("croissant", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.0F), "croissant");
        AppetizersInit.register(new AppetizingFoodItem("bun-honey", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.0F), "bun-honey");
        AppetizersInit.register(new AppetizingFoodItem("bun-hotcross", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.0F), "bun-hotcross");
        AppetizersInit.register(new AppetizingFoodItem("bun-meat", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 1.0F), "bun-meat");
    }
}
