package gdn.hypercube.appetizers.init;

import gdn.hypercube.appetizers.block.JarBlock;
import gdn.hypercube.appetizers.effect.CogchampStatusEffect;
import gdn.hypercube.appetizers.effect.DreadStatusEffect;
import gdn.hypercube.appetizers.effect.HeartAttackStatusEffect;
import gdn.hypercube.appetizers.effect.ChronoAnchorAtHome;
import gdn.hypercube.appetizers.effect.SilencedStatusEffect;
import gdn.hypercube.appetizers.effect.TimeBombStatusEffect;
import gdn.hypercube.appetizers.util.effect.AntifreezeConsumeEffect;
import gdn.hypercube.appetizers.util.effect.DrGibbConsumeEffect;
import gdn.hypercube.appetizers.util.effect.KimchiConsumeEffect;
import gdn.hypercube.appetizers.util.effect.MREConsumeEffect;
import gdn.hypercube.appetizers.util.effect.RandomEffectConsumeEffect;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppetizersInit implements ModInitializer {
    private static final List<Item> ITEMS = new ArrayList<>();
    public static final Logger LOGGER = LogManager.getLogger("Assorted Appetizers");

    static void register(Item target, String name) {
        Registry.register(Registries.ITEM, Identifier.of("appetizers", name), target);
        ITEMS.add(target);
    }

    public static final RegistryEntry<StatusEffect> DREAD = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("appetizers", "dread"), new DreadStatusEffect());
    public static final RegistryEntry<StatusEffect> COGCHAMP = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("appetizers", "cogchamp"), new CogchampStatusEffect());
    public static final RegistryEntry<StatusEffect> SILENCED = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("appetizers", "silenced"), new SilencedStatusEffect());
    public static final RegistryEntry<StatusEffect> TIMEBOMB = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("appetizers", "timebomb"), new TimeBombStatusEffect());
    public static final RegistryEntry<StatusEffect> CHRONO_ANCHOR = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("appetizers", "chrono_anchor"), new ChronoAnchorAtHome());
    public static final RegistryEntry<StatusEffect> HEART_ATTACK = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("appetizers", "sheer_heart_attack"), new HeartAttackStatusEffect());

    public static final Block JAR = new JarBlock();

    @Override
    public void onInitialize() {
        Registry.register(Registries.CONSUME_EFFECT_TYPE, Identifier.of("appetiers", "mre"), MREConsumeEffect.TYPE);
        Registry.register(Registries.CONSUME_EFFECT_TYPE, Identifier.of("appetizers", "kimchi"), KimchiConsumeEffect.TYPE);
        Registry.register(Registries.CONSUME_EFFECT_TYPE, Identifier.of("appetizers", "drgibb"), DrGibbConsumeEffect.TYPE);
        Registry.register(Registries.CONSUME_EFFECT_TYPE, Identifier.of("appetizers", "random"), RandomEffectConsumeEffect.TYPE);
        Registry.register(Registries.CONSUME_EFFECT_TYPE, Identifier.of("appetizers", "antifreeze"), AntifreezeConsumeEffect.TYPE);

        AppetizersIceCreams.init();
        AppetizersMiscFood.init();
        AppetizersSoups.init();
        AppetizersBreads.init();
        AppetizersCakes.init();
        AppetizersPies.init();
        AppetizersPizzas.init();
        AppetizersDrinks.init();

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
