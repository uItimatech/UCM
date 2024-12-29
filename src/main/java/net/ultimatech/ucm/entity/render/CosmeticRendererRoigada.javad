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

import javax.annotation.Nullable;

public class CosmeticRendererRoigada<T extends Entity, M extends EntityModel<T>> extends EntityRenderer<CosmeticRoigadaEntity> {

    protected M entityModel;

    protected static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/cosmetic_roigada");

    public CosmeticRendererRoigada(EntityRendererManager entityRendererManager) {
        super(entityRendererManager);
    }

    public M getEntityModel() {
        return this.entityModel;
    }

    @Override
    public ResourceLocation getEntityTexture(CosmeticRoigadaEntity cosmeticRoigadaEntity) {
        return TEXTURE;
    }

    @Override
    public void render(CosmeticRoigadaEntity cosmeticRoigadaEntity, float f1, float f2, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i) {
        RenderType rendertype = this.getRenderType(cosmeticRoigadaEntity, true, true, false);
        if (rendertype != null) {
            IVertexBuilder ivertexbuilder = iRenderTypeBuffer.getBuffer(rendertype);
            this.entityModel.render(matrixStack, ivertexbuilder, i, i, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        super.render(cosmeticRoigadaEntity, f1, f2, matrixStack, iRenderTypeBuffer, i);
    }

    @Nullable
    protected RenderType getRenderType(CosmeticRoigadaEntity cosmeticRoigadaEntity, boolean b1, boolean b2, boolean b3) {
        ResourceLocation resourcelocation = this.getEntityTexture(cosmeticRoigadaEntity);
        if (b2) {
            return RenderType.getItemEntityTranslucentCull(resourcelocation);
        } else if (b1) {
            return this.entityModel.getRenderType(resourcelocation);
        } else {
            return b3 ? RenderType.getOutline(resourcelocation) : null;
        }
    }
}