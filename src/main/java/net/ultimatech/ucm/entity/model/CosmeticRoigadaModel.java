package net.ultimatech.ucm.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigadaEntity;

public class CosmeticRoigadaModel<C extends CosmeticRoigadaEntity> extends EntityModel<C> {

	private final ModelRenderer bb_main;

	public CosmeticRoigadaModel() {
		int texWidth = 16;
		int texHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 8.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 10).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(8, 10).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(C entity, float v, float v1, float v2, float v3, float v4) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}