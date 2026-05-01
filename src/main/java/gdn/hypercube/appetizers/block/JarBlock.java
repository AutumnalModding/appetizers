package gdn.hypercube.appetizers.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class JarBlock extends Block {
    public JarBlock() {
        super(AbstractBlock.Settings.copy(Blocks.GLASS).breakInstantly().registryKey(RegistryKey.of(
                RegistryKeys.BLOCK,
                Identifier.of("appetizers", "jar"))
        ));
    }
}
