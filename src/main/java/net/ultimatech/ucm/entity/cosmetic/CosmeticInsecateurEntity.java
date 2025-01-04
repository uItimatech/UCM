package net.ultimatech.ucm.entity.cosmetic;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CosmeticInsecateurEntity extends CosmeticEntity {

	public CosmeticInsecateurEntity(EntityType<? extends CosmeticEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();

		PlayerEntity player = this.world.getPlayerByUuid(this.getOwner());

		if (player == null) {
			this.remove();
		} else {
			if (!player.isPassenger(this)) {
				this.startRiding(player, true);
			}
			this.setRotation(player.rotationYawHead, player.rotationPitch);
		}
	}
}
