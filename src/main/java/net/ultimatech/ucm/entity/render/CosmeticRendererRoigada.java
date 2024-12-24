package net.ultimatech.ucm.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.ultimatech.ucm.UCM;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigada;
import net.ultimatech.ucm.entity.model.CosmeticModelRoigada;

public class CosmeticRendererRoigada extends EntityRenderer<CosmeticRoigada> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(UCM.MODID, "textures/entity/cosmetic_roigada.png");

    protected EntityModel<CosmeticRoigada> entityModel;

    public CosmeticRendererRoigada(EntityRendererManager renderManager) {
        super(renderManager);
        this.entityModel = new CosmeticModelRoigada();
    }

    @Override
    public ResourceLocation getEntityTexture(CosmeticRoigada entity) {
        return TEXTURE;
    }

    @Override
    public void render(CosmeticRoigada cosmeticRoigada, float f1, float f2, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i) {
        super.render(cosmeticRoigada, f1, f2, matrixStack, iRenderTypeBuffer, i);
        int lightOverlay = getPackedLight(cosmeticRoigada, 0);
        this.entityModel.render(matrixStack, iRenderTypeBuffer.getBuffer(RenderType.getCutout()), lightOverlay, 1, 1, 1, 1, 1);
    }
}
