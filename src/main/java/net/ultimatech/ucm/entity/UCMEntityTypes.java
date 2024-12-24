package net.ultimatech.ucm.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ultimatech.ucm.UCM;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigada;

public class UCMEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, UCM.MODID);


    public static final RegistryObject<EntityType<CosmeticRoigada>> COSMETIC_ROIGADA =
            ENTITY_TYPES.register("cosmetic_roigada", () -> EntityType.Builder.create(CosmeticRoigada::new, EntityClassification.MISC)
                    .size(1.0f, 1.0f)
                    .build(new ResourceLocation(UCM.MODID, "cosmetic_roigada").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}