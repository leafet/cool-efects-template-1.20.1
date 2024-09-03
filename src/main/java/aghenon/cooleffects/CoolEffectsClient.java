package aghenon.cooleffects;

import aghenon.cooleffects.ModEntities.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CoolEffectsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.COOL_SPLITTING_ARROW_ENTITY, (FlyingItemEntityRenderer::new));

    }

}
