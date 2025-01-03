package net.ultimatech.ucm.entity.cosmetic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.Optional;
import java.util.UUID;

public abstract class CosmeticEntity extends Entity implements IRendersAsItem {

    public static final DataParameter<Optional<UUID>> OWNER = EntityDataManager.createKey(CosmeticEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);

    public CosmeticEntity(EntityType<? extends Entity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void readAdditional(CompoundNBT compoundNBT) {
        if (compoundNBT.hasUniqueId("Owner")) {
            this.setOwner(compoundNBT.getUniqueId("Owner"));
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compoundNBT) {
        if (this.getOwner() != null) {
            compoundNBT.putUniqueId("Owner", this.getOwner());
        }
    }

    public UUID getOwner() {
        return this.getDataManager().get(OWNER).orElse(null);
    }

    public void setOwner(UUID owner) {
        this.getDataManager().set(OWNER, Optional.of(owner));
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return new SCosmeticSpawnPacket(this.getEntityId(), this.getUniqueID(), this.getOwner(), this.getPosX(), this.getPosY(), this.getPosZ(), this.getType());
    }

    @Override
    protected void registerData() {
        this.getDataManager().register(OWNER, Optional.empty());
    }

    @Override
    public void tick() {
        super.tick();

        PlayerEntity player = this.world.getPlayerByUuid(this.getOwner());

        if (player == null) {
            this.remove();
        }
    }

    public void spawnAndAssign(World world, PlayerEntity player) {
        this.setOwner(player.getUniqueID());
        this.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
        this.startRiding(player, true);
        world.addEntity(this);
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean canCollide(Entity p_241849_1_) {
        return false;
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(Items.PUMPKIN);
    }
}
