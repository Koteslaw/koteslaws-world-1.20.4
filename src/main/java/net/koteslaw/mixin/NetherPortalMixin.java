package net.koteslaw.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.NetherPortal;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NetherPortal.class)
public class NetherPortalMixin {
    @Shadow private @Nullable BlockPos lowerCorner;

    @Inject(at=@At("HEAD"),method = "isValid")
    private void isValid(CallbackInfoReturnable<Boolean> cir){
        this.lowerCorner=null;
    }
}
