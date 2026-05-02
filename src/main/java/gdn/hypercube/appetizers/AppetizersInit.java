package gdn.hypercube.appetizers;

import gdn.hypercube.appetizers.block.JarBlock;
import gdn.hypercube.appetizers.item.AppetizingFoodItem;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.impl.creativetab.FabricCreativeModeTabBuilderImpl;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
        register(new AppetizingFoodItem("blooddrop", "Disclaimer: not made with actual blood.\n\nWe think.", true, 3, 0, SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.5F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1))), "blooddrop");
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
        register(new AppetizingFoodItem("carpsushi", "", false, 12, 6, SoundEvents.ENTITY_GENERIC_EAT, 4.75F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 3))), "carpsushi");
        register(new AppetizingFoodItem("carpsushislice", "", false, 2, 1, SoundEvents.ENTITY_GENERIC_EAT, 0.75F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 100))), "carpsushislice");
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

        // Four. Hundred. Drinks.
        register(new AppetizingFoodItem("7deadlysins", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "7deadlysins");
        register(new AppetizingFoodItem("absintheglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "absintheglass");
        register(new AppetizingFoodItem("acidspitglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "acidspitglass");
        register(new AppetizingFoodItem("aleglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "aleglass");
        register(new AppetizingFoodItem("alienbrainhemorrhage", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "alienbrainhemorrhage");
        register(new AppetizingFoodItem("alliescocktail", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "alliescocktail");
        register(new AppetizingFoodItem("aloe", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "aloe");
        register(new AppetizingFoodItem("amasecglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "amasecglass");
        register(new AppetizingFoodItem("andalusia", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "andalusia");
        register(new AppetizingFoodItem("antifreeze", "The forbidden juice.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "antifreeze");
        register(new AppetizingFoodItem("appleberryfizz", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "appleberryfizz");
        register(new AppetizingFoodItem("arnoldpalmer", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "arnoldpalmer");
        register(new AppetizingFoodItem("atomicbombglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "atomicbombglass");

        List<StatusEffectInstance> atpunch = new ArrayList<>();
        atpunch.add(new StatusEffectInstance(StatusEffects.SPEED, 600, 1));
        atpunch.add(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1));
        atpunch.add(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1));
        register(new AppetizingFoodItem("atomicpunch", "Birds fly, grass grows, sun shines...", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(atpunch)), "atomicpunch");

        register(new AppetizingFoodItem("bnp", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bnp");
        register(new AppetizingFoodItem("b52glass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "b52glass");
        register(new AppetizingFoodItem("bacchusblessing", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bacchusblessing");
        register(new AppetizingFoodItem("bahama_mama", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bahama_mama");
        register(new AppetizingFoodItem("banana", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "banana");
        register(new AppetizingFoodItem("bananahonkglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bananahonkglass");
        register(new AppetizingFoodItem("bande", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bande");
        register(new AppetizingFoodItem("beepskysmashglass", "Stop! You violated the law.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "beepskysmashglass");
        register(new AppetizingFoodItem("beerglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "beerglass");
        register(new AppetizingFoodItem("beesknees", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "beesknees");
        register(new AppetizingFoodItem("berryjuice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "berryjuice");
        register(new AppetizingFoodItem("blackrussianglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "blackrussianglass");
        register(new AppetizingFoodItem("bloodglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300))), "bloodglass");
        register(new AppetizingFoodItem("bloodymaryglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bloodymaryglass");
        register(new AppetizingFoodItem("bluehawaiian", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bluehawaiian");
        register(new AppetizingFoodItem("brainbomb", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "brainbomb");
        register(new AppetizingFoodItem("bravebullglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bravebullglass");
        register(new AppetizingFoodItem("bronx", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bronx");
        register(new AppetizingFoodItem("brownstar", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "brownstar");
        register(new AppetizingFoodItem("bubbletea", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "bubbletea");
        register(new AppetizingFoodItem("budgetinsulsdrink", "Tider's favourite.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "budgetinsulsdrink");
        register(new AppetizingFoodItem("cafedecacao", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "cafedecacao");
        register(new AppetizingFoodItem("caipirinha", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "caipirinha");
        register(new AppetizingFoodItem("calicosunrise", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "calicosunrise");
        register(new AppetizingFoodItem("carrotjuice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "carrotjuice");
        register(new AppetizingFoodItem("champagneglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "champagneglass");
        register(new AppetizingFoodItem("chocolateglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "chocolateglass");
        register(new AppetizingFoodItem("circusjuice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "circusjuice");
        register(new AppetizingFoodItem("clownblood", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 1))), "clownblood");
        register(new AppetizingFoodItem("coconutrum", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "coconutrum");
        register(new AppetizingFoodItem("coffeeglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "coffeeglass");
        register(new AppetizingFoodItem("coffeeliqueurglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "coffeeliqueurglass");
        register(new AppetizingFoodItem("cogchamp", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "cogchamp");
        register(new AppetizingFoodItem("cognacglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "cognacglass");
        register(new AppetizingFoodItem("colaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "colaglass");
        register(new AppetizingFoodItem("cosmopolitan", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "cosmopolitan");
        register(new AppetizingFoodItem("creambar", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "creambar");
        register(new AppetizingFoodItem("cremedecacao", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "cremedecacao");
        register(new AppetizingFoodItem("crushdepth", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "crushdepth");
        register(new AppetizingFoodItem("cubalibreglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "cubalibreglass");
        register(new AppetizingFoodItem("cucumberwater", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "cucumberwater");
        register(new AppetizingFoodItem("curacaoglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "curacaoglass");
        register(new AppetizingFoodItem("daiquiri", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "daiquiri");
        register(new AppetizingFoodItem("darknstormy", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "darknstormy");
        register(new AppetizingFoodItem("darkoasis", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "darkoasis");
        register(new AppetizingFoodItem("davenport", "Does not contain pufferfish.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "davenport");
        register(new AppetizingFoodItem("deadmansdraught", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "deadmansdraught");
        register(new AppetizingFoodItem("deathintheafternoon", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "deathintheafternoon");
        register(new AppetizingFoodItem("demonsblood", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 2))), "demonsblood");
        register(new AppetizingFoodItem("devilskiss", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "devilskiss");
        register(new AppetizingFoodItem("dirtywastelander", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "dirtywastelander");

        List<StatusEffectInstance> ddelight = new ArrayList<>();
        ddelight.add(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 3));
        ddelight.add(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 3));
        ddelight.add(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1));
        ddelight.add(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1));
        register(new AppetizingFoodItem("doctorsdelightglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(ddelight)), "doctorsdelightglass");

        register(new AppetizingFoodItem("doublecreamblaster", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "doublecreamblaster");
        register(new AppetizingFoodItem("dr_gibb_glass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "dr_gibb_glass");

        List<StatusEffectInstance> drblood = new ArrayList<>();
        drblood.add(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3000));
        drblood.add(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 3));
        drblood.add(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 3));
        register(new AppetizingFoodItem("dragonsblood", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(drblood)), "dragonsblood");

        List<StatusEffectInstance> drbreath = new ArrayList<>();
        drbreath.add(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000));
        drbreath.add(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1));
        drbreath.add(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1));
        register(new AppetizingFoodItem("dragonsbreath", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(drbreath)), "dragonsbreath");

        register(new AppetizingFoodItem("driestmartiniglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "driestmartiniglass");
        register(new AppetizingFoodItem("eggnogglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "eggnogglass");
        register(new AppetizingFoodItem("electricshark", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "electricshark");
        register(new AppetizingFoodItem("emeraldglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 6000, 4))), "emeraldglass");
        register(new AppetizingFoodItem("eminence", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "eminence");
        register(new AppetizingFoodItem("empress75", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "empress75");
        register(new AppetizingFoodItem("erikasurprise", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "erikasurprise");
        register(new AppetizingFoodItem("espressomartini", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "espressomartini");
        register(new AppetizingFoodItem("feverdream", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "feverdream");

        List<StatusEffectInstance> floko = new ArrayList<>();
        floko.add(new StatusEffectInstance(StatusEffects.SPEED, 600, 4));
        floko.add(new StatusEffectInstance(StatusEffects.HASTE, 600, 4));
        floko.add(new StatusEffectInstance(StatusEffects.POISON, 600, 9));
        floko.add(new StatusEffectInstance(StatusEffects.WITHER, 600, 9));
        register(new AppetizingFoodItem("fourteen_loko_glass", "Your heart will hate you.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(floko)), "fourteen_loko_glass");

        register(new AppetizingFoodItem("gargleblasterglass", "Do you know where your towel is?", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "gargleblasterglass");
        register(new AppetizingFoodItem("gildlagerglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "gildlagerglass");
        register(new AppetizingFoodItem("ginfizzglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "ginfizzglass");
        register(new AppetizingFoodItem("gintonicglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "gintonicglass");
        register(new AppetizingFoodItem("ginvodkaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "ginvodkaglass");
        register(new AppetizingFoodItem("goldbloomspecial", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "goldbloomspecial");
        register(new AppetizingFoodItem("grandnavy", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "grandnavy");
        register(new AppetizingFoodItem("grapejuice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "grapejuice");
        register(new AppetizingFoodItem("graveyard", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "graveyard");
        register(new AppetizingFoodItem("greenteaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "greenteaglass");
        register(new AppetizingFoodItem("grenadineglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "grenadineglass");
        register(new AppetizingFoodItem("grogglass", "Won't remove nanomachines.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "grogglass");
        register(new AppetizingFoodItem("gsodaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "gsodaglass");
        register(new AppetizingFoodItem("heartbreakmountain", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "heartbreakmountain");
        register(new AppetizingFoodItem("hippiesdelightglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "hippiesdelightglass");
        register(new AppetizingFoodItem("holyvice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "holyvice");
        register(new AppetizingFoodItem("icecreamglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "icecreamglass");
        register(new AppetizingFoodItem("iced_beerglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "iced_beerglass");
        register(new AppetizingFoodItem("icedcoffeeglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "icedcoffeeglass");
        register(new AppetizingFoodItem("icedgreenteaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "icedgreenteaglass");
        register(new AppetizingFoodItem("icedteaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "icedteaglass");
        register(new AppetizingFoodItem("iceglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "iceglass");
        register(new AppetizingFoodItem("irishcoffeeglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "irishcoffeeglass");
        register(new AppetizingFoodItem("irishcreamglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "irishcreamglass");
        register(new AppetizingFoodItem("irishslammer", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "irishslammer");
        register(new AppetizingFoodItem("jackrose", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "jackrose");
        register(new AppetizingFoodItem("junglebird", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "junglebird");
        register(new AppetizingFoodItem("kalimotxo", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "kalimotxo");
        register(new AppetizingFoodItem("kiraspecial", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "kiraspecial");
        register(new AppetizingFoodItem("kvass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "kvass");
        register(new AppetizingFoodItem("lamplight", "oh goodness gracious I'm stuck in an elevator with the messiah and also literally god themself this is awkward", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "lamplight");
        register(new AppetizingFoodItem("lean", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "lean");
        register(new AppetizingFoodItem("lemonade", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "lemonade");
        register(new AppetizingFoodItem("lemonadeglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "lemonadeglass");
        register(new AppetizingFoodItem("lemonglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "lemonglass");
        register(new AppetizingFoodItem("lemonjuiceglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "lemonjuiceglass");
        register(new AppetizingFoodItem("lemonlime", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "lemonlime");
        register(new AppetizingFoodItem("lemonpopsicle", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "lemonpopsicle");
        register(new AppetizingFoodItem("longislandicedteaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "longislandicedteaglass");
        register(new AppetizingFoodItem("loverskiss", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "loverskiss");
        register(new AppetizingFoodItem("manhattanglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "manhattanglass");
        register(new AppetizingFoodItem("manlydorfglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "manlydorfglass");
        register(new AppetizingFoodItem("margaritaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "margaritaglass");
        register(new AppetizingFoodItem("mariejulep", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "mariejulep");
        register(new AppetizingFoodItem("martiniglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "martiniglass");
        register(new AppetizingFoodItem("mayojito", "Revolting.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "mayojito");
        register(new AppetizingFoodItem("meadglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "meadglass");
        register(new AppetizingFoodItem("milkshake", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "milkshake");
        register(new AppetizingFoodItem("mimeosa", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "mimeosa");
        register(new AppetizingFoodItem("mimosa", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "mimosa");
        register(new AppetizingFoodItem("mojito", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "mojito");
        register(new AppetizingFoodItem("monkeybusiness", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "monkeybusiness");
        register(new AppetizingFoodItem("moonshineglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "moonshineglass");
        register(new AppetizingFoodItem("moscowmule", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "moscowmule");
        register(new AppetizingFoodItem("neurotoxinglass", "Why would you drink this?", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WITHER, 1200, 9))), "neurotoxinglass");
        register(new AppetizingFoodItem("nuclear_colaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "nuclear_colaglass");
        register(new AppetizingFoodItem("numberone", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "numberone");
        register(new AppetizingFoodItem("orangecreamcicle", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "orangecreamcicle");
        register(new AppetizingFoodItem("orangejuiceglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "orangejuiceglass");
        register(new AppetizingFoodItem("painkiller", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "painkiller");
        register(new AppetizingFoodItem("patronglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "patronglass");
        register(new AppetizingFoodItem("pinacolada", "No, it won't open a portal.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "pinacolada");
        register(new AppetizingFoodItem("pineappleblast", "Special edition!", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "pineappleblast");
        register(new AppetizingFoodItem("pinkdrink", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "pinkdrink");
        register(new AppetizingFoodItem("poisonberryjuice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 3))), "poisonberryjuice");
        register(new AppetizingFoodItem("pomonade", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "pomonade");
        register(new AppetizingFoodItem("pompassion", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "pompassion");
        register(new AppetizingFoodItem("pomtwist", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "pomtwist");
        register(new AppetizingFoodItem("prairieoyster", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "prairieoyster");
        register(new AppetizingFoodItem("prisonwine", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "prisonwine");
        register(new AppetizingFoodItem("proj_manhattanglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "proj_manhattanglass");
        register(new AppetizingFoodItem("pumpkinspicelatte", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "pumpkinspicelatte");
        register(new AppetizingFoodItem("pwineglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 3))), "pwineglass");
        register(new AppetizingFoodItem("quadruplecreamchalice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "quadruplecreamchalice");
        register(new AppetizingFoodItem("radler", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "radler");
        register(new AppetizingFoodItem("red_meadglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "red_meadglass");
        register(new AppetizingFoodItem("rewriter", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "rewriter");
        register(new AppetizingFoodItem("rootbeerfloatglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "rootbeerfloatglass");
        register(new AppetizingFoodItem("rootbeerglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "rootbeerglass");
        register(new AppetizingFoodItem("royrogers", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "royrogers");
        register(new AppetizingFoodItem("rubberneck", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "rubberneck");
        register(new AppetizingFoodItem("rumglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "rumglass");
        register(new AppetizingFoodItem("sakeglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "sakeglass");
        register(new AppetizingFoodItem("saketokkuri", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "saketokkuri");
        register(new AppetizingFoodItem("salvagersdelight", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "salvagersdelight");
        register(new AppetizingFoodItem("sapopicante", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "sapopicante");
        register(new AppetizingFoodItem("sbitenglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "sbitenglass");
        register(new AppetizingFoodItem("screwdriverglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "screwdriverglass");
        register(new AppetizingFoodItem("sdreamglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "sdreamglass");
        register(new AppetizingFoodItem("shake-blue", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "shake-blue");
        register(new AppetizingFoodItem("shake-meat", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "shake-meat");
        register(new AppetizingFoodItem("shake-robo", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "shake-robo");
        register(new AppetizingFoodItem("shake-white", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "shake-white");
        register(new AppetizingFoodItem("shirleytemple", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "shirleytemple");
        register(new AppetizingFoodItem("silencerglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "silencerglass");
        register(new AppetizingFoodItem("silverjack", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "silverjack");
        register(new AppetizingFoodItem("singulo", "Don't get sucked in.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "singulo");
        register(new AppetizingFoodItem("slimeshine", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "slimeshine");
        register(new AppetizingFoodItem("snowball", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "snowball");
        register(new AppetizingFoodItem("snowwhite", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "snowwhite");
        register(new AppetizingFoodItem("sojuglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "sojuglass");
        register(new AppetizingFoodItem("sol_dry_glass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "sol_dry_glass");
        register(new AppetizingFoodItem("soy_latte", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "soy_latte");
        register(new AppetizingFoodItem("space-up_glass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "space-up_glass");
        register(new AppetizingFoodItem("space_mountain_wind_glass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "space_mountain_wind_glass");
        register(new AppetizingFoodItem("specialsundae", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "specialsundae");
        register(new AppetizingFoodItem("strayglass", "Meow.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "strayglass");
        register(new AppetizingFoodItem("sugarglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 3))), "sugarglass");
        register(new AppetizingFoodItem("sweetbloodshot", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "sweetbloodshot");
        register(new AppetizingFoodItem("syndicatebomb", "Somebody set us up the bomb!", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "syndicatebomb");
        register(new AppetizingFoodItem("syndicatesoverseer", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "syndicatesoverseer");
        register(new AppetizingFoodItem("teaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "teaglass");
        register(new AppetizingFoodItem("tequillaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "tequillaglass");
        register(new AppetizingFoodItem("tequillasunriseglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "tequillasunriseglass");
        register(new AppetizingFoodItem("the_martinez", "You didn't take me to the moon, but you were there with me.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "the_martinez");
        register(new AppetizingFoodItem("thesunalsorises", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "thesunalsorises");
        register(new AppetizingFoodItem("thewaterslide", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "thewaterslide");
        register(new AppetizingFoodItem("threemileislandglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "threemileislandglass");
        register(new AppetizingFoodItem("tonicglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "tonicglass");
        register(new AppetizingFoodItem("torpedojuice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "torpedojuice");
        register(new AppetizingFoodItem("tortuga", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "tortuga");

        List<StatusEffectInstance> toxins = new ArrayList<>();
        toxins.add(new StatusEffectInstance(StatusEffects.POISON, 600, 4));
        toxins.add(new StatusEffectInstance(StatusEffects.WITHER, 600, 4));
        toxins.add(new StatusEffectInstance(StatusEffects.BLINDNESS, 600));
        toxins.add(new StatusEffectInstance(StatusEffects.NAUSEA, 600));
        toxins.add(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 4));
        toxins.add(new StatusEffectInstance(StatusEffects.HUNGER, 600, 4));
        toxins.add(new StatusEffectInstance(StatusEffects.UNLUCK, 600, 4));
        toxins.add(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 600, 4));
        toxins.add(new StatusEffectInstance(StatusEffects.WEAKNESS, 600, 4));
        register(new AppetizingFoodItem("toxinsspecialglass", "I wouldn't drink this if I were you.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F, new ApplyEffectsConsumeEffect(toxins)), "toxinsspecialglass");

        register(new AppetizingFoodItem("triplecitrus", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "triplecitrus");
        register(new AppetizingFoodItem("vampiro", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "vampiro");
        register(new AppetizingFoodItem("vermouthglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "vermouthglass");
        register(new AppetizingFoodItem("vodkatonicglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "vodkatonicglass");
        register(new AppetizingFoodItem("voltage", "Short Circuit Crash!! not included.", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "voltage");
        register(new AppetizingFoodItem("wakeupjuice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "wakeupjuice");
        register(new AppetizingFoodItem("wassail", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "wassail");
        register(new AppetizingFoodItem("watermelonjuice", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "watermelonjuice");
        register(new AppetizingFoodItem("watermelonglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "watermelonglass");
        register(new AppetizingFoodItem("whiskeycolaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "whiskeycolaglass");
        register(new AppetizingFoodItem("whiskeyglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "whiskeyglass");
        register(new AppetizingFoodItem("whiskeysodaglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "whiskeysodaglass");
        register(new AppetizingFoodItem("whiskeysodaglass2", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "whiskeysodaglass2");
        register(new AppetizingFoodItem("whiskeysour", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "whiskeysour");
        register(new AppetizingFoodItem("whiterussianglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "whiterussianglass");
        register(new AppetizingFoodItem("wineglass", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "wineglass");
        register(new AppetizingFoodItem("xenobasher", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "xenobasher");
        register(new AppetizingFoodItem("zombiecocktail", "", true, 4, 4, SoundEvents.ENTITY_GENERIC_DRINK, 2.25F), "zombiecocktail");


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
