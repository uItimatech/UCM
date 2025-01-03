package net.ultimatech.ucm.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.arguments.EntitySummonArgument;
import net.minecraft.command.arguments.SuggestionProviders;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.ultimatech.ucm.UCM;
import net.ultimatech.ucm.entity.UCMEntityTypes;
import net.ultimatech.ucm.entity.cosmetic.CosmeticEntity;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigadaEntity;

public class CosmeticEquipCommand {

    public CosmeticEquipCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("cosmetic")
                        .then(Commands.argument("player", EntityArgument.entities())
                                .then(Commands.literal("equip")
                                        .then(Commands.argument("cosmetic", EntitySummonArgument.entitySummon()).suggests(SuggestionProviders.SUMMONABLE_ENTITIES)
                                                .executes(context -> {return equip(context, EntityArgument.getEntity(context, "player"));})))));
    }

    private int equip(CommandContext<CommandSource> context, Entity sourceEntity) {

        UCM.LOGGER.info("sourceEntity: " + sourceEntity.toString());
        UCM.LOGGER.info(sourceEntity.getClass());

        ResourceLocation cosmeticResourceLocation = context.getArgument("cosmetic", ResourceLocation.class);
        String cosmeticName = cosmeticResourceLocation.getPath();

        if (!cosmeticResourceLocation.getNamespace().equals(UCM.MODID)) {
            context.getSource().sendErrorMessage(new StringTextComponent("Invalid cosmetic"));
            return 0;
        }

        if (sourceEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) sourceEntity;
            CosmeticEntity headCosmeticEntity = null;

            // Choice of cosmetic
            if (cosmeticName.equals(Cosmetic.COSMETIC_ROIGADA)) {
                headCosmeticEntity = new CosmeticRoigadaEntity(UCMEntityTypes.COSMETIC_ROIGADA.get(), player.world);
            }

            if (headCosmeticEntity != null) {
                headCosmeticEntity.spawnAndAssign(player.world, player);
                context.getSource().sendFeedback(new StringTextComponent("Equipped " + context.getArgument("cosmetic", ResourceLocation.class).toString()), true);
                return 1;
            } else {
                context.getSource().sendErrorMessage(new StringTextComponent("An error occurred while equipping the cosmetic"));
                return 0;
            }
        } else {
            context.getSource().sendErrorMessage(new StringTextComponent("Invalid player"));
        }
        return 0;
    }
}
