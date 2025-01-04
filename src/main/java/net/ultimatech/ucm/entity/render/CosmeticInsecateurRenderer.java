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
import net.ultimatech.ucm.entity.cosmetic.CosmeticInsecateurEntity;
import net.ultimatech.ucm.entity.model.CosmeticInsecateurModel;

public class CosmeticInsecateurRenderer extends EntityRenderer<CosmeticInsecateurEntity> {

    protected CosmeticInsecateurModel<CosmeticInsecateurEntity> model;

    protected static final ResourceLocation TEXTURE = new ResourceLocation(UCM.MODID,"textures/entity/cosmetic_insecateur.png");

    public CosmeticInsecateurRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager);
        this.model = new CosmeticInsecateurModel();
    }

    @Override
    public ResourceLocation getEntityTexture(CosmeticInsecateurEntity cosmeticInsecateurEntity) {
        return TEXTURE;
    }

    @Override
    public void render(CosmeticInsecateurEntity entityIn, float f1, float f2, MatrixStack matrixStack, IRenderTypeBuffer bufferIn, int i) {

        PlayerEntity player = (PlayerEntity) this.renderManager.info.getRenderViewEntity();

        matrixStack.push();

        double pitch;
        double yaw;

        if (player.isSneaking() && !player.abilities.isFlying) {
            pitch = -0.5F;
            yaw = -(player.renderYawOffset-180) * Math.PI / 180;
        } else if (player.isElytraFlying()) {
            pitch = 0;
            yaw = -(player.renderYawOffset-180) * Math.PI / 180;
        } else if (player.isSwimming()) {
            pitch = 0;
            yaw = -(player.renderYawOffset-180) * Math.PI / 180;
        } else {
            pitch = 0;
            yaw = -(player.renderYawOffset-180) * Math.PI / 180;
        }


        float qw = (float) (Math.cos(pitch/2) * Math.cos(yaw/2));
        float qx = (float) (Math.sin(pitch/2) * Math.cos(yaw/2));
        float qy = (float) (Math.cos(pitch/2) * Math.sin(yaw/2));
        float qz = (float) (-Math.sin(pitch/2) * Math.sin(yaw/2));

        Quaternion correctedRotation = new Quaternion(qx, qy, qz, qw);

        matrixStack.rotate(correctedRotation);

        if (player.isSneaking() && !player.abilities.isFlying) {
            matrixStack.translate(0.225, -1.975, 0);
        } else if (player.isElytraFlying()) {
            matrixStack.translate(0.225, -1.975, 0);
        } else if (player.isSwimming()) {
            matrixStack.translate(0.225, -1.975, 0);
        } else {
            matrixStack.translate(0.225, -1.875, 0);
        }

        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.model.getRenderType(this.getEntityTexture(entityIn)));

        this.model.setRotationAngle(0,0,(float) Math.PI);
        this.model.render(matrixStack, ivertexbuilder, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStack.pop();
        super.render(entityIn, f1, f2, matrixStack, bufferIn, i);
    }

    // The entity will only render when the player is in third person or when the player is not the owner of the entity
    @Override
    public boolean shouldRender(CosmeticInsecateurEntity cosmeticInsecateurEntity, ClippingHelper clippingHelper, double d1, double d2, double d3) {
        PlayerEntity player = (PlayerEntity) cosmeticInsecateurEntity.world.getPlayerByUuid(cosmeticInsecateurEntity.getOwner());

        if (player.isInvisible() || player.isSpectator() || player.isSwimming() || player.isElytraFlying() || player.isSpinAttacking())
            return false;

        return this.getRenderManager().info.isThirdPerson() || (!cosmeticInsecateurEntity.getOwner().toString().equals(this.getRenderManager().info.getRenderViewEntity().getUniqueID().toString()));
    }
}