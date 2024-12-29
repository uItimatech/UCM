package net.ultimatech.ucm.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.ultimatech.ucm.entity.cosmetic.CosmeticEntity;

import java.util.List;

public class CosmeticUnequipAllCommand {

    public CosmeticUnequipAllCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("cosmetic")
                .then(Commands.argument("player", EntityArgument.entities())
                    .then(Commands.literal("unequip").executes(context -> {return unequip(context,  EntityArgument.getEntity(context, "player"));}))));
    }

    private int unequip(CommandContext<CommandSource> context, Entity sourceEntity) {

        if (sourceEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) sourceEntity;

            List<CosmeticEntity> cosmeticEntityList = player.world.getEntitiesWithinAABB(CosmeticEntity.class, player.getBoundingBox().grow(1));

            for (CosmeticEntity cosmeticEntity : cosmeticEntityList) {
                if (cosmeticEntity.getOwner() != null && cosmeticEntity.getOwner().equals(player.getUniqueID())) {
                    cosmeticEntity.remove();
                }
            }

            if (!cosmeticEntityList.isEmpty()) {
                context.getSource().sendFeedback(new StringTextComponent("Unequipped " + cosmeticEntityList.size() + " cosmetics"), true);
                return 1;
            } else {
                context.getSource().sendErrorMessage(new StringTextComponent("No cosmetics to unequip"));
                return 0;
            }

        } else {
            context.getSource().sendErrorMessage(new StringTextComponent("Invalid player"));
        }
        return 0;
    }
}
