package net.ultimatech.ucm.entity.cosmetic;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CosmeticRoigadaEntity extends CosmeticEntity {

	public CosmeticRoigadaEntity(EntityType<? extends CosmeticEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {

		PlayerEntity player = this.world.getPlayerByUuid(this.getOwner());

		if (player == null) {
			this.remove();
		}

		this.setPosition(player.getPosX(), player.getPosY()+1.5, player.getPosZ());
		this.setRotation(player.rotationYaw, player.rotationPitch);
	}
}
