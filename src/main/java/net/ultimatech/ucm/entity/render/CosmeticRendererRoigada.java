package net.ultimatech.ucm.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigadaEntity;
import net.ultimatech.ucm.entity.model.CosmeticModelRoigada;

import javax.annotation.Nullable;

public class CosmeticRendererRoigada extends EntityRenderer<CosmeticRoigadaEntity> {

    protected final EntityModel<Entity> model = new CosmeticModelRoigada();

    protected static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/cosmetic_roigada");

    public CosmeticRendererRoigada(EntityRendererManager entityRendererManager) {
        super(entityRendererManager);
    }


    @Override
    public ResourceLocation getEntityTexture(CosmeticRoigadaEntity cosmeticRoigadaEntity) {
        return TEXTURE;
    }

    @Override
    public void render(CosmeticRoigadaEntity cosmeticRoigadaEntity, float f1, float f2, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i) {
        matrixStack.push();

        this.model.render(matrixStack, iRenderTypeBuffer.getBuffer(RenderType.getEntityCutout(getEntityTexture(cosmeticRoigadaEntity))), i, 1, 1, 1, 1, 1);

        matrixStack.pop();
        super.render(cosmeticRoigadaEntity, f1, f2, matrixStack, iRenderTypeBuffer, i);
    }
}