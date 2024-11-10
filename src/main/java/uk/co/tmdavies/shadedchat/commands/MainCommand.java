package uk.co.tmdavies.shadedchat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import uk.co.tmdavies.shadedchat.enums.Messages;
import uk.co.tmdavies.shadedchat.enums.Permissions;
import uk.co.tmdavies.shadedchat.managers.ConfigManager;
import uk.co.tmdavies.shadedchat.managers.PlayerManager;

import java.util.List;

public class MainCommand implements ShadowCommand {

    @Override
    public String getName() {
        return "shadedchat";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (!sender.hasPermission(Permissions.MAIN_COMMAND.getPermission())) {
            sender.sendMessage(String.format(Messages.NO_PERMISSION.getMessage(), Permissions.MAIN_COMMAND.getPermission()));

            return true;
        }

        switch (args.length) {
            case 1:
                if (args[0].equalsIgnoreCase("reload")) {
                    ConfigManager.reloadConfigs();
                    PlayerManager.reloadPlayerFormats();

                    sender.sendMessage(Messages.RELOADED.getMessage());
                }

                break;

            default:
                sender.sendMessage(Messages.MAIN_COMMAND_USAGE.getMessage());

                break;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String string, String[] args) {
        return switch(args.length) {
            case 1 -> List.of("reload");
            default -> null;
        };
    }

}
