package net.ultimatech.ucm.entity.cosmetic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.world.World;
import net.ultimatech.ucm.entity.UCMEntityTypes;

import java.util.UUID;

public class CosmeticRoigada extends MobEntity {

    private UUID owner;

    public CosmeticRoigada(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void readAdditional(CompoundNBT compoundNBT) {
        if (compoundNBT.hasUniqueId("Owner")) {
            this.owner = compoundNBT.getUniqueId("Owner");
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compoundNBT) {
        if (this.owner != null) {
            compoundNBT.putUniqueId("Owner", this.owner);
        }
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        Entity entity = this.getEntity();
        return new SSpawnObjectPacket(this, entity == null ? 0 : entity.getEntityId());
    }

    @Override
    public void tick() {
        super.tick();
        if (owner == null || owner == this.getUniqueID()) {
            //this.remove();
        }
    }
}
