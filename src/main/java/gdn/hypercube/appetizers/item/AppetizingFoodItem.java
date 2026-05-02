package gdn.hypercube.appetizers.item;

import gdn.hypercube.appetizers.AppetizersInit;
import java.lang.reflect.Field;
import java.util.function.Consumer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class AppetizingFoodItem extends BlockItem {
    private final String name;
    private final String tooltip;

    public AppetizingFoodItem(String name, String tooltip, boolean always, int hunger, int saturation, RegistryEntry<SoundEvent> sound, float time, ConsumeEffect... effects) {
        this.name = name;

        FoodComponent.Builder food = new FoodComponent.Builder();
        if (always) food = food.alwaysEdible();
        food = food.nutrition(hunger);
        food = food.saturationModifier(saturation);

        ConsumableComponent.Builder consumable = ConsumableComponent.builder();
        for (ConsumeEffect effect : effects) {
            consumable = consumable.consumeEffect(effect);
        }
        consumable = consumable.sound(sound);
        consumable = consumable.consumeSeconds(time);

        Item.Settings settings = new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("appetizers", name)))
                .food(food.build(), consumable.build());

        this.tooltip = tooltip;
        super(null, settings);
    }

    public AppetizingFoodItem setBlock(Block target) {
        try {
            Field field = BlockItem.class.getDeclaredField("block");
            field.setAccessible(true);
            field.set(this, target);
        } catch (ReflectiveOperationException exception) {
            AppetizersInit.LOGGER.error("Failed to set block of item {} to {}!", this.name, target.getName().getLiteralString());
            AppetizersInit.LOGGER.error("Dumping stacktrace!", exception);
        }

        return this;
    }

    public AppetizingFoodItem registerBlock(Block copyTarget) {
        Block target = new Block(AbstractBlock.Settings.copy(copyTarget).breakInstantly().registryKey(RegistryKey.of(
                RegistryKeys.BLOCK,
                Identifier.of("appetizers", this.name))
        ));

        Registry.register(Registries.BLOCK, Identifier.of("appetizers", this.name), target);
        this.setBlock(target);

        return this;
    }

   @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return this.getBlock() == null ? ActionResult.PASS : super.useOnBlock(context);
    }

    @Override
    public ActionResult place(ItemPlacementContext context) {
        return this.getBlock() == null ? ActionResult.PASS : super.place(context);
    }

    @Override
    protected boolean place(ItemPlacementContext context, BlockState state) {
        return this.getBlock() != null && super.place(context, state);
    }

    @Override
    protected boolean canPlace(ItemPlacementContext context, BlockState state) {
        return this.getBlock() != null && super.canPlace(context, state);
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
