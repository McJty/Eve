package mcjty.eve.entity;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

public class RenderEve extends RenderLiving<EntityEve> {

    private ResourceLocation mobTexture = new ResourceLocation("eve:textures/entity/eve.png");

    public static final Factory FACTORY = new Factory();

    public RenderEve(RenderManager rendermanagerIn) {
        // We use the vanilla zombie model here and we simply
        // retexture it. Of course you can make your own model
        super(rendermanagerIn, new ModelZombie(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityEve entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityEve> {

        @Override
        public Render<? super EntityEve> createRenderFor(RenderManager manager) {
            return new RenderEve(manager);
        }

    }

}
