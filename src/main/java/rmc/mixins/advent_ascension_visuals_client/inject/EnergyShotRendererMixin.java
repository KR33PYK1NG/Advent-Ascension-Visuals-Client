package rmc.mixins.advent_ascension_visuals_client.inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.tslat.aoa3.client.render.entity.projectile.cannonshots.EnergyShotRenderer;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = EnergyShotRenderer.class)
public abstract class EnergyShotRendererMixin {

    private boolean rmc$skip;

    @Inject(method = "Lnet/tslat/aoa3/client/render/entity/projectile/cannonshots/EnergyShotRenderer;render(Lnet/tslat/aoa3/entity/projectile/cannon/EnergyShotEntity;FFLcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;I)V",
            remap = false,
            cancellable = true,
            at = @At(value = "HEAD"))
    private void lowerParticles(CallbackInfo mixin) {
        this.rmc$skip = !this.rmc$skip;
        if (this.rmc$skip) {
            mixin.cancel();
        }
    }

}