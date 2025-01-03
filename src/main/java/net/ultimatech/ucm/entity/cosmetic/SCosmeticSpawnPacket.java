package net.ultimatech.ucm.entity.cosmetic;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.ultimatech.ucm.entity.UCMEntityTypes;

import java.io.IOException;
import java.util.UUID;

public class SCosmeticSpawnPacket implements IPacket<IClientPlayNetHandler> {

	private int entityId;
	private UUID uniqueId;
	private EntityType<?> type;

	public SCosmeticSpawnPacket(int entityId, UUID uniqueId, EntityType<?> entityType) {
		this.entityId = entityId;
		this.uniqueId = uniqueId;
		this.type = entityType;
	}

	@Override
	public void readPacketData(PacketBuffer buf) throws IOException {
		this.entityId = buf.readVarInt();
		this.uniqueId = buf.readUniqueId();
		this.type = Registry.ENTITY_TYPE.getByValue(buf.readVarInt());
	}

	@Override
	public void writePacketData(PacketBuffer buf) throws IOException {
		buf.writeVarInt(this.entityId);
		buf.writeUniqueId(this.uniqueId);
		buf.writeVarInt(Registry.ENTITY_TYPE.getId(this.type));
	}

	public void processPacket(IClientPlayNetHandler handler) {
		PacketThreadUtil.checkThreadAndEnqueue(this, handler, Minecraft.getInstance());
		EntityType<?> entitytype = this.type;

		CosmeticEntity entity = null;

		if (entitytype == UCMEntityTypes.COSMETIC_ROIGADA.get()) {
			entity = new CosmeticRoigadaEntity(UCMEntityTypes.COSMETIC_ROIGADA.get(), Minecraft.getInstance().world);
		}

		if (entity != null) {
			int i = this.getEntityID();
			entity.setEntityId(i);
			entity.setUniqueId(this.getUniqueId());
			entity.setOwner(this.uniqueId);
			Minecraft.getInstance().world.addEntity(i, entity);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public int getEntityID() {
		return this.entityId;
	}

	@OnlyIn(Dist.CLIENT)
	public UUID getUniqueId() {
		return this.uniqueId;
	}

	@OnlyIn(Dist.CLIENT)
	public EntityType<?> getType() {
		return this.type;
	}
}
