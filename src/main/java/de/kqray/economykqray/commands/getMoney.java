package de.kqray.economykqray.commands;

import de.kqray.economykqray.Messages;
import de.kqray.economykqray.util.MoneyManager;
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

        MoneyManager mm = new MoneyManager();
        if (args.length < 1) {
            sender.sendMessage(Messages.senderMoney(mm.getMoney((Player) sender)));
            return true;
        } else if (args.length == 1) {

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
            sender.sendMessage(ChatColor.RED +"comamnd Usage /money , /money <player>");
        }


        return true;
    }
}

