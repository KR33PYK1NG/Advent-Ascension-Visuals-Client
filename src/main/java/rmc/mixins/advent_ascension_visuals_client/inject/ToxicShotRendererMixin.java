package rmc.mixins.advent_ascension_visuals_client.inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.tslat.aoa3.client.render.entity.projectile.blasters.ToxicShotRenderer;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = ToxicShotRenderer.class)
public abstract class ToxicShotRendererMixin {

    private boolean rmc$skip;

    @Inject(method = "Lnet/tslat/aoa3/client/render/entity/projectile/blasters/ToxicShotRenderer;addParticles(Lnet/tslat/aoa3/entity/projectile/blaster/ToxicShotEntity;F)V",
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