package net.ultimatech.ucm.entity.cosmetic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.world.World;

import java.util.UUID;

public class CosmeticEntity extends Entity {

    protected UUID owner;

    public CosmeticEntity(EntityType<? extends Entity> entityType, World world) {
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

    public UUID getOwner() {
        return this.owner;
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
    protected void registerData() {}

    @Override
    public void tick() {
        super.tick();
        if (owner == null || owner == this.getUniqueID()) {
            this.remove();
        }
    }

    // Here is the method that will be used to spawn the entity from outside this class within the world considering the previous methods
    public void spawnAndAssign(World world, PlayerEntity player) {
        this.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
        this.setOwner(player.getUniqueID());
        world.addEntity(this);
    }
}
