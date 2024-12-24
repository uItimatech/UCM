package net.ultimatech.ucm.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntitySummonArgument;
import net.minecraft.command.arguments.SuggestionProviders;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.ultimatech.ucm.entity.UCMEntityTypes;
import net.ultimatech.ucm.entity.cosmetic.CosmeticRoigada;

public class CosmeticEquipCommand {


    public CosmeticEquipCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("cosmetic")
                .then(Commands.literal("equip")
                        .then(Commands.argument("cosmetic", new EntitySummonArgument()).suggests(SuggestionProviders.SUMMONABLE_ENTITIES)
                                .executes(context -> {return equip(dispatcher, context);})))
                        .executes(context -> {return equip(dispatcher, context);}));
    }

    private int equip(CommandDispatcher<CommandSource> dispatcher, CommandContext<CommandSource> context) {
        Entity entity = context.getSource().getEntity();
        if (entity instanceof PlayerEntity) {
            //Summons a new CostmeticRoigada riding the player

            PlayerEntity player = (PlayerEntity) entity;
            CosmeticRoigada cosmeticRoigada = new CosmeticRoigada(UCMEntityTypes.COSMETIC_ROIGADA.get(), player.world);
            cosmeticRoigada.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());

            context.getSource().sendFeedback(new StringTextComponent("Equipped cosmetic"), true);
        }
        return 1;
    }
}
