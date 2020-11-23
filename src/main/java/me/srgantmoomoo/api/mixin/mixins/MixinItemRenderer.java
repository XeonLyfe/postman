package me.srgantmoomoo.api.mixin.mixins;

import me.srgantmoomoo.api.event.events.TransformSideFirstPersonEvent;
import me.srgantmoomoo.postman.Main;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.util.EnumHandSide;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ItemRenderer.class)
public class MixinItemRenderer{

	@Inject(method = "transformSideFirstPerson", at = @At("HEAD"))
	public void transformSideFirstPerson(EnumHandSide hand, float p_187459_2_, CallbackInfo ci){
		TransformSideFirstPersonEvent event = new TransformSideFirstPersonEvent(hand);
		Main.EVENT_BUS.post(event);
	}

	@Inject(method = "transformFirstPerson", at = @At("HEAD"))
	public void transformFirstPerson(EnumHandSide hand, float p_187453_2_, CallbackInfo ci){
		TransformSideFirstPersonEvent event = new TransformSideFirstPersonEvent(hand);
		Main.EVENT_BUS.post(event);
	}
}
