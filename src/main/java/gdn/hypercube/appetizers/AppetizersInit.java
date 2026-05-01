package gdn.hypercube.appetizers;

import gdn.hypercube.appetizers.block.JarBlock;
import gdn.hypercube.appetizers.item.AppetizingFoodItem;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.impl.creativetab.FabricCreativeModeTabBuilderImpl;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppetizersInit implements ModInitializer {
    //
    private static final List<Item> ITEMS = new ArrayList<>();
    public static final Logger LOGGER = LogManager.getLogger("Assorted Appetizers");

    private void register(Item target, String name) {
        Registry.register(Registries.ITEM, Identifier.of("appetizers", name), target);
        ITEMS.add(target);
    }

    public static final Block JAR = new JarBlock();

    @Override
    public void onInitialize() {
        register(new AppetizingFoodItem("bananasplit", "", true, 5, 2, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 2F), "bananasplit");
        register(new AppetizingFoodItem("blooddrop", "Disclaimer: not made with actual blood.\n\nWe think.", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "blooddrop");
        register(new AppetizingFoodItem("caramel", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "caramel");
        register(new AppetizingFoodItem("choco", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "choco");
        register(new AppetizingFoodItem("coconut", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "coconut");
        register(new AppetizingFoodItem("coffee", "Yes, it's real coffee.", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F,  new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 1))), "coffee");
        register(new AppetizingFoodItem("greentea", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "greentea");
        register(new AppetizingFoodItem("hazelnut", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "hazelnut");
        register(new AppetizingFoodItem("lemon", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "lemon");
        register(new AppetizingFoodItem("mintchoco", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "mintchoco");
        register(new AppetizingFoodItem("neapolitan", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "neapolitan");
        register(new AppetizingFoodItem("orange", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "orange");
        register(new AppetizingFoodItem("rainbow", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "rainbow");
        register(new AppetizingFoodItem("rockyroad", "Now with \"real\" asphalt.", true, 8, 3, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 4.5F), "rockyroad");
        register(new AppetizingFoodItem("saltedcaramel", "Salted, not hashed.", true, 5, 1, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.75F), "saltedcaramel");
        register(new AppetizingFoodItem("spaghetti", "Just like your mother used to make...?", true, 6, 8, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 4.15F), "spaghetti");
        register(new AppetizingFoodItem("strawberry", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "strawberry");
        register(new AppetizingFoodItem("vanilla", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "vanilla");
        register(new AppetizingFoodItem("walnut", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "walnut");
        register(new AppetizingFoodItem("watermelon", "", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F), "watermelon");

        register(new AppetizingFoodItem("avocadosushi", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 4.75F), "avocadosushi");
        register(new AppetizingFoodItem("avocadosushislice", "", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F), "avocadosushislice");
        register(new AppetizingFoodItem("carpsushi", "Maybe keep an antitoxin on hand.", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 4.75F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 3))), "carpsushi");
        register(new AppetizingFoodItem("carpsushislice", "It's probably safe, now that it's sliced...\n\n...Surely.", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 100))), "carpsushislice");
        register(new AppetizingFoodItem("freshsushi", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 4.75F), "freshsushi");
        register(new AppetizingFoodItem("freshsushislice", "", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F), "freshsushislice");
        register(new AppetizingFoodItem("gassushislice", "This is almost certainly unsafe.", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 3))), "gassushislice");
        register(new AppetizingFoodItem("sashimi", "Are you sure this was prepared correctly...?", false, 12, 8, SoundEvents.ENTITY_GENERIC_EAT, 4F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1))), "sashimi");

        register(new AppetizingFoodItem("bacon", "", false, 8, 6, SoundEvents.ENTITY_GENERIC_EAT, 2.75F), "bacon");
        register(new AppetizingFoodItem("bigbite", "Tall, not wide.", false, 15, 15, SoundEvents.ENTITY_GENERIC_EAT, 6.25F), "bigbite");
        register(new AppetizingFoodItem("cheese", "", false, 6, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.5F), "cheese");
        register(new AppetizingFoodItem("cheesealt", "", false, 9, 6, SoundEvents.ENTITY_GENERIC_EAT, 3F), "cheesealt");
        register(new AppetizingFoodItem("chicken", "", false, 8, 6, SoundEvents.ENTITY_GENERIC_EAT, 2.75F), "chicken");
        register(new AppetizingFoodItem("mcrib", "Legally distinct.", false, 10, 7, SoundEvents.ENTITY_GENERIC_EAT, 3.25F), "mcrib");
        register(new AppetizingFoodItem("plain", "", false, 4, 4, SoundEvents.ENTITY_GENERIC_EAT, 2.25F), "plain");
        register(new AppetizingFoodItem("superbite", "You might need to unhinge your jaw for this one.", false, 20, 20, SoundEvents.ENTITY_GENERIC_EAT, 12.5F), "superbite");
        
        register(new AppetizingFoodItem("cornuto", "", false, 4, 2, SoundEvents.ENTITY_GENERIC_EAT, 1.45F), "cornuto");
        register(new AppetizingFoodItem("sandwich", "Not made by Google.", false, 6, 3, SoundEvents.ENTITY_GENERIC_EAT, 2.15F), "sandwich");
        register(new AppetizingFoodItem("sandwich-strawberry", "", false, 6, 3, SoundEvents.ENTITY_GENERIC_EAT, 2.15F), "sandwich-strawberry");
            
        register(new AppetizingFoodItem("enchiladas", "", false, 16, 10, SoundEvents.ENTITY_GENERIC_EAT, 5.25F), "enchiladas");
        register(new AppetizingFoodItem("hotdog", "", false, 6, 3, SoundEvents.ENTITY_GENERIC_EAT, 2F), "hotdog");
        register(new AppetizingFoodItem("omelette", "", false, 12, 8, SoundEvents.ENTITY_GENERIC_EAT, 4F), "omelette");
        register(new AppetizingFoodItem("ribs", "", false, 12, 8, SoundEvents.ENTITY_GENERIC_EAT, 4F), "ribs");
        register(new AppetizingFoodItem("yakiimo", "", false, 10, 6, SoundEvents.ENTITY_GENERIC_EAT, 3.5F), "yakiimo");

        Registry.register(Registries.BLOCK, Identifier.of("appetizers", "jar"), JAR);
        Registry.register(Registries.ITEM, Identifier.of("appetizers", "jar"), new BlockItem(JAR,
                new Item.Settings()
                .registryKey(RegistryKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of("appetizers", "jar"))
                )
        ));

        Registry.register(Registries.ITEM_GROUP, RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of("appetizers", "appetizers")), FabricCreativeModeTab.builder()
                .icon(() -> ITEMS.getFirst().getDefaultStack())
                .displayName(Text.translatable("itemGroup.appetizers"))
                .entries(((_, entries) -> ITEMS.forEach(entries::add)))
                .build());
    }
}
