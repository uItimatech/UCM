package net.ultimatech.ucm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.ultimatech.ucm.entity.cosmetic.CosmeticInsecateurEntity;

public class CosmeticInsecateurModel<C extends CosmeticInsecateurEntity> extends EntityModel<C> {

	private final ModelRenderer model;
	private final ModelRenderer wing_1;
	private final ModelRenderer wing_3;
	private final ModelRenderer wing_2;
	private final ModelRenderer wing_4;

	public CosmeticInsecateurModel() {
		int texWidth = 64;
		int texHeight = 64;

		model = new ModelRenderer(this);
		model.setTextureSize(texWidth, texHeight);
		model.setRotationPoint(-1.7921F, 28.3512F, 2.1542F);


		wing_1 = new ModelRenderer(this);
		wing_1.setTextureSize(texWidth, texHeight);
		wing_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		model.addChild(wing_1);
		setRotationAngle(wing_1, 0.3496F, -0.9275F, 0.3111F);
		wing_1.setTextureOffset(32, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		wing_1.setTextureOffset(0, -16).addBox(0.0F, -4.0F, 2.0F, 0.0F, 8.0F, 16.0F, 0.0F, false);

		wing_3 = new ModelRenderer(this);
		wing_3.setTextureSize(texWidth, texHeight);
		wing_3.setRotationPoint(3.5842F, 0.0F, 0.0F);
		model.addChild(wing_3);
		setRotationAngle(wing_3, 0.3496F, 0.9275F, -0.3111F);
		wing_3.setTextureOffset(32, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);
		wing_3.setTextureOffset(0, -16).addBox(0.0F, -4.0F, 2.0F, 0.0F, 8.0F, 16.0F, 0.0F, true);

		wing_2 = new ModelRenderer(this);
		wing_2.setTextureSize(texWidth, texHeight);
		wing_2.setRotationPoint(-0.5765F, 1.8491F, 0.0966F);
		model.addChild(wing_2);
		setRotationAngle(wing_2, 0.0273F, -0.6774F, 0.1999F);
		wing_2.setTextureOffset(32, 6).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		wing_2.setTextureOffset(0, -9).addBox(0.0F, -4.0F, 1.0F, 0.0F, 8.0F, 16.0F, 0.0F, false);

		wing_4 = new ModelRenderer(this);
		wing_4.setTextureSize(texWidth, texHeight);
		wing_4.setRotationPoint(4.1607F, 1.8491F, 0.0966F);
		model.addChild(wing_4);
		setRotationAngle(wing_4, 0.0273F, 0.6774F, -0.1999F);
		wing_4.setTextureOffset(32, 6).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, true);
		wing_4.setTextureOffset(0, -9).addBox(0.0F, -4.0F, 1.0F, 0.0F, 8.0F, 16.0F, 0.0F, true);
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