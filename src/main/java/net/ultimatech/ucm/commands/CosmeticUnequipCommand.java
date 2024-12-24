package net.ultimatech.ucm.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class CosmeticUnequipCommand {

    public CosmeticUnequipCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("cosmetic")
                .then(Commands.literal("unequip").executes(context -> {return unequip(dispatcher);})));
    }

    private int unequip(CommandDispatcher<CommandSource> dispatcher) {
        return 1;
    }
}
