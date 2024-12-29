package net.ultimatech.ucm.events;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.server.command.ConfigCommand;
import net.ultimatech.ucm.UCM;
import net.ultimatech.ucm.commands.CosmeticEquipCommand;
import net.ultimatech.ucm.commands.CosmeticUnequipAllCommand;
import net.ultimatech.ucm.commands.CosmeticUnequipTypeCommand;

@Mod.EventBusSubscriber(modid = UCM.MODID)
public class UCMEvents {

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        new CosmeticEquipCommand(event.getDispatcher());
        new CosmeticUnequipAllCommand(event.getDispatcher());
        new CosmeticUnequipTypeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
