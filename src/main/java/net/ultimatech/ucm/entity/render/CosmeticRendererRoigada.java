package net.ultimatech.ucm.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.ultimatech.ucm.UCM;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigadaEntity;
import net.ultimatech.ucm.entity.model.CosmeticModelRoigada;

public class CosmeticRendererRoigada extends EntityRenderer<CosmeticRoigadaEntity> {

    protected EntityModel<Entity> model;

    protected static final ResourceLocation TEXTURE = new ResourceLocation(UCM.MODID,"textures/entity/cosmetic_roigada.png");
    protected static final RenderType RENDER_TYPE = RenderType.getEntityCutout(TEXTURE);

    public CosmeticRendererRoigada(EntityRendererManager entityRendererManager) {
        super(entityRendererManager);
        this.model = new CosmeticModelRoigada();
    }

    @Override
    public ResourceLocation getEntityTexture(CosmeticRoigadaEntity cosmeticRoigadaEntity) {
        return TEXTURE;
    }

    @Override
    public void render(CosmeticRoigadaEntity cosmeticRoigadaEntity, float f1, float f2, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i) {
        matrixStack.push();

        matrixStack.scale(1.0F, -1.0F, -1.0F);
        matrixStack.translate(0.0D, -1.501D, 0.0D);
        IVertexBuilder ivertexbuilder = iRenderTypeBuffer.getBuffer(RENDER_TYPE);
        this.model.render(matrixStack, ivertexbuilder, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStack.pop();
        super.render(cosmeticRoigadaEntity, f1, f2, matrixStack, iRenderTypeBuffer, i);
    }
}