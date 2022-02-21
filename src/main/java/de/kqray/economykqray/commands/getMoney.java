package de.kqray.economykqray.commands;

import de.kqray.economykqray.Messages;
import de.kqray.economykqray.util.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getMoney implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //todo permmision und nachricht
        if (!(sender.hasPermission("EconomyKqray.getSelfMoney"))) {
            sender.sendMessage(Messages.noPerm);
            return true;
        }
        Economy mm = new Economy();
        if (args.length < 1) {
            sender.sendMessage(Messages.senderMoney(mm.getMoney((Player) sender)));
            return true;
        } else if (args.length == 1) {
            if (!(sender.hasPermission("EconomyKqray.getTargetMoney"))) {
                sender.sendMessage(Messages.noPerm);
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(Messages.playerNull);
                return true;
            }

            if (target.getName().equals(sender.getName())) {
                sender.sendMessage(Messages.senderMoney(mm.getMoney((Player) sender)));
                return true;
            }

            sender.sendMessage(Messages.targetMoney(target, mm.getMoney(target)));

        } else {
            sender.sendMessage(ChatColor.RED + "commandUsage /money , /money <player>");
        }


        return true;
    }
}

