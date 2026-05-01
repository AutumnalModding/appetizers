package gdn.hypercube.appetizers.item;

import java.util.function.Consumer;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class AppetizingFoodItem extends Item {
    private final String tooltip;

    public AppetizingFoodItem(String name, String tooltip, boolean always, int hunger, int saturation, RegistryEntry<SoundEvent> sound, float time, ApplyEffectsConsumeEffect... effects) {
        FoodComponent.Builder food = new FoodComponent.Builder();
        if (always) food = food.alwaysEdible();
        food = food.nutrition(hunger);
        food = food.saturationModifier(saturation);

        ConsumableComponent.Builder consumable = ConsumableComponent.builder();
        for (ApplyEffectsConsumeEffect effect : effects) {
            consumable = consumable.consumeEffect(effect);
        }
        consumable = consumable.sound(sound);
        consumable = consumable.consumeSeconds(time);

        Item.Settings settings = new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("appetizers", name)))
                .food(food.build(), consumable.build());

        this.tooltip = tooltip;
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent component, Consumer<Text> consumer, TooltipType type) {
        if (!this.tooltip.isEmpty()) {
            String[] lines = this.tooltip.split("\n");
            for (String line : lines) {
                consumer.accept(Text.literal(line).formatted(Formatting.ITALIC, Formatting.DARK_GRAY));
            }
        }
    }
}
