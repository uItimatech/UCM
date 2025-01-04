package net.ultimatech.ucm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.ultimatech.ucm.entity.cosmetic.CosmeticSkelenoxEntity;

public class CosmeticSkelenoxModel<C extends CosmeticSkelenoxEntity> extends EntityModel<C> {

	private final ModelRenderer model;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;

	public CosmeticSkelenoxModel() {
		int texWidth = 32;
		int texHeight = 32;

		model = new ModelRenderer(this);
		model.setTextureSize(texWidth, texHeight);
		model.setRotationPoint(0.0F, 15.0F, 0.0F);
		model.setTextureOffset(18, 3).addBox(-2.625F, 4.0F, -4.6F, 2.0F, 2.0F, 0.0F, 0.1F, false);
		model.setTextureOffset(27, 6).addBox(-0.95F, 5.5F, -4.1F, -1.0F, -1.0F, -1.0F, -0.1F, true);
		model.setTextureOffset(21, 6).addBox(-0.925F, 4.5F, -4.75F, -1.0F, 1.0F, 0.0F, 0.0F, false);
		model.setTextureOffset(27, 6).addBox(1.95F, 5.5F, -4.1F, -1.0F, -1.0F, -1.0F, -0.1F, false);
		model.setTextureOffset(21, 6).addBox(1.925F, 4.5F, -4.75F, -1.0F, 1.0F, 0.0F, 0.0F, true);
		model.setTextureOffset(18, 12).addBox(0.625F, 4.0F, -4.6F, 2.0F, 2.0F, 0.0F, 0.1F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setTextureSize(texWidth, texHeight);
		cube_r1.setRotationPoint(0.0F, 4.0F, -5.975F);
		model.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.2618F, 0.0F);
		cube_r1.setTextureOffset(0, 17).addBox(0.0F, 2.525F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setTextureSize(texWidth, texHeight);
		cube_r2.setRotationPoint(0.0F, 3.5F, -6.0F);
		model.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.2618F, 0.0F);
		cube_r2.setTextureOffset(22, 0).addBox(-0.75F, -2.0F, 0.5F, 4.0F, 2.0F, 0.0F, 0.0F, true);
		cube_r2.setTextureOffset(10, 9).addBox(0.0F, -2.5F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 3).addBox(0.0F, -0.5F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(12, 12).addBox(0.0F, 0.5F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 6).addBox(0.0F, 2.5F, 0.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(12, 0).addBox(3.0F, 0.5F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setTextureSize(texWidth, texHeight);
		cube_r3.setRotationPoint(0.0F, 3.5F, -6.0F);
		model.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.2618F, 0.0F);
		cube_r3.setTextureOffset(22, 0).addBox(-3.25F, -2.0F, 0.5F, 4.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r3.setTextureOffset(10, 6).addBox(-4.0F, -2.5F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r3.setTextureOffset(6, 12).addBox(-1.0F, 0.5F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 9).addBox(-3.0F, 2.5F, 0.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 12).addBox(-4.0F, 0.5F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 0).addBox(-4.0F, -0.5F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setTextureSize(texWidth, texHeight);
		cube_r4.setRotationPoint(1.9319F, 7.0F, -5.4574F);
		model.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0914F, -0.2457F, -0.3604F);
		cube_r4.setTextureOffset(18, 16).addBox(0.0F, -0.5F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setTextureSize(texWidth, texHeight);
		cube_r5.setRotationPoint(-1.9319F, 7.0F, -5.4574F);
		model.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0914F, 0.2457F, 0.3604F);
		cube_r5.setTextureOffset(12, 16).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setTextureSize(texWidth, texHeight);
		cube_r6.setRotationPoint(0.0F, 4.0F, -5.975F);
		model.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.2618F, 0.0F);
		cube_r6.setTextureOffset(18, 0).addBox(-1.0F, 2.5F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(C entity, float v, float v1, float v2, float v3, float v4) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.model.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngle(float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}