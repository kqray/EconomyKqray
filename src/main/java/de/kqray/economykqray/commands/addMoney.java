package de.kqray.economykqray.commands;

import de.kqray.economykqray.Messages;
import de.kqray.economykqray.util.MoneyManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addMoney implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        MoneyManager mm = new MoneyManager();
        //todo permissuon/ message
        if (args.length == 1) {
            try {
                if (args[0].startsWith("-")){
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }


                int val = Integer.parseInt(args[0]);
                mm.addMoney((Player) sender, val);
                sender.sendMessage(Messages.playerToPlayer(val, "hinzugefügt"));
                return true;
            } catch (NumberFormatException e) {
                sender.sendMessage(Messages.noNumber);
                return true;
            }


        } else if (args.length == 2) {
            try {
                int mon = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                sender.sendMessage(Messages.noNumber);
                return true;
            }
            int mon = Integer.parseInt(args[1]);
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(Messages.playerNull);
                return true;

            } else if (target.getName() == sender.getName()) {
                if (args[1].startsWith("-")){
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                mm.addMoney((Player) sender, mon);
                sender.sendMessage(Messages.playerToPlayer(mon, "hinzugefügt"));
                return true;
            } else {
                if (args[0].startsWith("-")){
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                mm.addMoney(target, mon);
                sender.sendMessage(Messages.playThatSend(target, mon, "hinzugefügt"));
                target.sendMessage(Messages.playerThatTarget((Player) sender, mon, "hinzugefügt"));
            }


        } else {
            sender.sendMessage(ChatColor.RED+"comamnd usage /addmoney <value>, /addmoney <value> <player>");
        }
        return true;
    }
}

