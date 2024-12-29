package net.ultimatech.ucm.entity.cosmetic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class HeadCosmeticEntity extends CosmeticEntity {
	public HeadCosmeticEntity(EntityType<? extends Entity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();

		PlayerEntity player = this.world.getPlayerByUuid(owner);

		if (player == null) {
			this.remove();
		} else {
			this.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
			this.setRotation(player.rotationYaw, player.rotationPitch);
		}
	}
}
