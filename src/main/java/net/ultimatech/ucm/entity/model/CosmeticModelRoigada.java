package net.ultimatech.ucm.entity.model;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigadaEntity;

public class CosmeticModelRoigada <C extends CosmeticRoigadaEntity> extends EntityModel<C> {

	private final ModelRenderer body;
	private final ModelRenderer cube_r1;

	public CosmeticModelRoigada() {
		int texWidth = 64;
		int texHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, -8.0F, 16.0F, 5.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(0, 21).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 3.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(0, 36).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(9.0F, -8.0F, 0.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2391F, -0.8609F, -0.4031F);
		cube_r1.setTextureOffset(32, 36).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(C entity, float v, float v1, float v2, float v3, float v4) {
		this.body.rotateAngleY = v2;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}