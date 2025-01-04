package net.ultimatech.ucm.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ultimatech.ucm.UCM;
import net.ultimatech.ucm.entity.cosmetic.CosmeticInsecateurEntity;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigadaEntity;
import net.ultimatech.ucm.entity.cosmetic.CosmeticSkelenoxEntity;

public class UCMEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, UCM.MODID);

    public static final RegistryObject<EntityType<CosmeticRoigadaEntity>> COSMETIC_ROIGADA =
            ENTITY_TYPES.register("cosmetic_roigada",
                    () -> EntityType.Builder.create(CosmeticRoigadaEntity::new,
                                    EntityClassification.MISC)
                            .size(1f, 1f)
                            .build(new ResourceLocation(UCM.MODID, "cosmetic_roigada").toString()));

    public static final RegistryObject<EntityType<CosmeticSkelenoxEntity>> COSMETIC_SKELENOX =
            ENTITY_TYPES.register("cosmetic_skenelox",
                    () -> EntityType.Builder.create(CosmeticSkelenoxEntity::new,
                                    EntityClassification.MISC)
                            .size(1f, 1f)
                            .build(new ResourceLocation(UCM.MODID, "cosmetic_skenelox").toString()));

    public static final RegistryObject<EntityType<CosmeticInsecateurEntity>> COSMETIC_INSECATEUR =
            ENTITY_TYPES.register("cosmetic_insecateur",
                    () -> EntityType.Builder.create(CosmeticInsecateurEntity::new,
                                    EntityClassification.MISC)
                            .size(1f, 1f)
                            .build(new ResourceLocation(UCM.MODID, "cosmetic_insecateur").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
