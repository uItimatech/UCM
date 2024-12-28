package net.ultimatech.ucm.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.ResourceLocation;
import net.ultimatech.ucm.UCM;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigada;
import net.ultimatech.ucm.entity.model.CosmeticModelRoigada;

public class CosmeticRendererRoigada extends MobRenderer<CosmeticRoigada, CosmeticModelRoigada<CosmeticRoigada>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/cosmetic_roigada");

    public CosmeticRendererRoigada(EntityRendererManager p_i47210_1_) {
        super(p_i47210_1_, new CosmeticModelRoigada(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(CosmeticRoigada cosmeticRoigada) {
        return TEXTURE;
    }
}