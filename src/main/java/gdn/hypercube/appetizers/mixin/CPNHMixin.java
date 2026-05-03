package gdn.hypercube.appetizers.mixin;

import gdn.hypercube.appetizers.init.AppetizersInit;
import gdn.hypercube.appetizers.util.MiscUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// HAAAAAAANK
// HAAAAAAAAAAAAANK, DON'T ABBREVIATE CLIENT PLAY NETWORK HANDLER
// HAAAAAAAAANK
@Mixin(ClientPlayNetworkHandler.class)
public class CPNHMixin {

    @ModifyVariable(at = @At("HEAD"), method = "sendChatMessage", argsOnly = true, name = "content")
    private String coggers(String content) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.getStatusEffect(AppetizersInit.COGCHAMP) != null) {
            return MiscUtils.rot13(content);
        }
        return content;
    }

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    public void silence(String content, CallbackInfo ci) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.getStatusEffect(AppetizersInit.SILENCED) != null) {
            player.sendOverlayMessage(Text.literal("You can't speak right now!").formatted(Formatting.RED));
            ci.cancel();
        }
    }
}