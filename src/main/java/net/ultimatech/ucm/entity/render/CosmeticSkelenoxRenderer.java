package net.ultimatech.ucm.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.ultimatech.ucm.UCM;
import net.ultimatech.ucm.entity.cosmetic.CosmeticSkelenoxEntity;
import net.ultimatech.ucm.entity.model.CosmeticSkelenoxModel;

public class CosmeticSkelenoxRenderer extends EntityRenderer<CosmeticSkelenoxEntity> {

    protected CosmeticSkelenoxModel<CosmeticSkelenoxEntity> model;

    protected static final ResourceLocation TEXTURE = new ResourceLocation(UCM.MODID,"textures/entity/cosmetic_skelenox.png");

    public CosmeticSkelenoxRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager);
        this.model = new CosmeticSkelenoxModel();
    }

    @Override
    public ResourceLocation getEntityTexture(CosmeticSkelenoxEntity CosmeticSkelenoxEntity) {
        return TEXTURE;
    }

    @Override
    public void render(CosmeticSkelenoxEntity entityIn, float f1, float f2, MatrixStack matrixStack, IRenderTypeBuffer bufferIn, int i) {

        PlayerEntity player = (PlayerEntity) this.renderManager.info.getRenderViewEntity();
        float sneakingFactor = player.isSneaking() && !player.abilities.isFlying ? -0.125F : 0.0F;

        matrixStack.push();

        double pitch = -(entityIn.rotationPitch) * Math.PI / 180;
        double yaw = -(entityIn.rotationYaw-180) * Math.PI / 180;

        float qw = (float) (Math.cos(pitch/2) * Math.cos(yaw/2));
        float qx = (float) (Math.sin(pitch/2) * Math.cos(yaw/2));
        float qy = (float) (Math.cos(pitch/2) * Math.sin(yaw/2));
        float qz = (float) (-Math.sin(pitch/2) * Math.sin(yaw/2));

        Quaternion correctedRotation = new Quaternion(qx, qy, qz, qw);

        matrixStack.rotate(correctedRotation);
        matrixStack.translate(0, -0.35F + sneakingFactor, 0);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.model.getRenderType(this.getEntityTexture(entityIn)));

        this.model.setRotationAngle(0,0,(float) Math.PI);
        this.model.render(matrixStack, ivertexbuilder, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStack.pop();
        super.render(entityIn, f1, f2, matrixStack, bufferIn, i);
    }

    // The entity will only render when the player is in third person or when the player is not the owner of the entity
    @Override
    public boolean shouldRender(CosmeticSkelenoxEntity cosmeticSkelenoxEntity, ClippingHelper clippingHelper, double d1, double d2, double d3) {
        PlayerEntity player = (PlayerEntity) cosmeticSkelenoxEntity.world.getPlayerByUuid(cosmeticSkelenoxEntity.getOwner());

        if (player.isInvisible() || player.isSpectator() || player.isSwimming() || player.isElytraFlying())
            return false;

        return this.getRenderManager().info.isThirdPerson() || (!cosmeticSkelenoxEntity.getOwner().toString().equals(this.getRenderManager().info.getRenderViewEntity().getUniqueID().toString()));
    }
}