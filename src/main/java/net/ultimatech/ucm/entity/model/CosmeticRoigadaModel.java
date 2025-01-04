package net.ultimatech.ucm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigadaEntity;

public class CosmeticRoigadaModel<C extends CosmeticRoigadaEntity> extends EntityModel<C> {

	private final ModelRenderer model;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer horn_1;
	private final ModelRenderer cube_r8;
	private final ModelRenderer horn_2;
	private final ModelRenderer cube_r9;

	public CosmeticRoigadaModel() {
		int texWidth = 64;
		int texHeight = 64;

		model = new ModelRenderer(this);
		model.setTextureSize(texWidth, texHeight);
		model.setRotationPoint(0.0F, 26.0F, 0.0F);
		setRotationAngle(model, -0.2182F, 0.0F, 0.0F);


		cube_r1 = new ModelRenderer(this);
		cube_r1.setTextureSize(texWidth, texHeight);
		cube_r1.setRotationPoint(0.0F, -9.0854F, -0.0185F);
		model.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.setTextureOffset(24, 13).addBox(0.0F, -1.5F, -5.5F, 0.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setTextureSize(texWidth, texHeight);
		cube_r2.setRotationPoint(0.0F, -9.0854F, -0.0185F);
		model.addChild(cube_r2);
		setRotationAngle(cube_r2, -3.1416F, -0.5236F, -3.1416F);
		cube_r2.setTextureOffset(24, 13).addBox(0.0F, -1.5F, -6.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setTextureSize(texWidth, texHeight);
		cube_r3.setRotationPoint(0.0F, -9.0854F, -0.0185F);
		model.addChild(cube_r3);
		setRotationAngle(cube_r3, -3.1416F, 0.5236F, -3.1416F);
		cube_r3.setTextureOffset(24, 13).addBox(0.0F, -1.5F, -6.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setTextureSize(texWidth, texHeight);
		cube_r4.setRotationPoint(0.0F, -9.0854F, -0.0185F);
		model.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 1.5708F, 0.0F);
		cube_r4.setTextureOffset(24, 13).addBox(0.0F, -2.0F, -5.5F, 0.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setTextureSize(texWidth, texHeight);
		cube_r5.setRotationPoint(0.0F, -9.0854F, -0.0185F);
		model.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.6545F, 0.0F);
		cube_r5.setTextureOffset(24, 13).addBox(0.0F, -1.5F, -6.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setTextureSize(texWidth, texHeight);
		cube_r6.setRotationPoint(0.0F, -8.5854F, -0.0185F);
		model.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.6545F, 0.0F);
		cube_r6.setTextureOffset(24, 13).addBox(0.0F, -2.0F, -6.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setTextureSize(texWidth, texHeight);
		cube_r7.setRotationPoint(0.0F, -1.1F, 0.0F);
		model.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(28, 25).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(0, 22).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r7.setTextureOffset(26, 29).addBox(-1.0F, -7.5F, -3.75F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r7.setTextureOffset(16, 28).addBox(-1.5F, -8.0F, -3.475F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(0, 13).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.setTextureOffset(0, 33).addBox(-3.5F, -5.5F, -3.5F, 7.0F, 2.0F, 7.0F, -0.1F, false);
		cube_r7.setTextureOffset(0, 42).addBox(-5.5F, -2.5F, -5.5F, 11.0F, 2.0F, 11.0F, -0.1F, false);
		cube_r7.setTextureOffset(0, 0).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 3.0F, 10.0F, 0.0F, false);

		horn_1 = new ModelRenderer(this);
		horn_1.setTextureSize(texWidth, texHeight);
		horn_1.setRotationPoint(4.4546F, -3.1129F, -0.3965F);
		model.addChild(horn_1);
		setRotationAngle(horn_1, 0.0447F, 0.218F, -0.5576F);
		horn_1.setTextureOffset(16, 22).addBox(-0.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setTextureSize(texWidth, texHeight);
		cube_r8.setRotationPoint(2.5F, 0.0F, 0.0F);
		horn_1.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -0.48F);
		cube_r8.setTextureOffset(28, 21).addBox(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		horn_2 = new ModelRenderer(this);
		horn_2.setTextureSize(texWidth, texHeight);
		horn_2.setRotationPoint(-4.4546F, -3.1129F, -0.3965F);
		model.addChild(horn_2);
		setRotationAngle(horn_2, 0.0447F, -0.218F, 0.5576F);
		horn_2.setTextureOffset(16, 22).addBox(-2.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, true);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setTextureSize(texWidth, texHeight);
		cube_r9.setRotationPoint(-2.5F, 0.0F, 0.0F);
		horn_2.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 0.48F);
		cube_r9.setTextureOffset(28, 21).addBox(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, true);
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