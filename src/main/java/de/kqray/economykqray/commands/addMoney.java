package de.kqray.economykqray.commands;

import de.kqray.economykqray.Messages;
import de.kqray.economykqray.util.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class addMoney implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {



        Economy mm = new Economy();
        if (!sender.hasPermission("EconomyKqray.addMoney")) {
            sender.sendMessage(Messages.noPerm);
            return true;
        }
        //todo permissuon/ message
        if (args.length == 1) {
            try {
                if (args[0].startsWith("-")) {
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
            } catch (IOException e) {
                e.printStackTrace();
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

            } else if (target.getName().equals(sender.getName())) {
                if (args[1].startsWith("-")) {
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                try {
                    mm.addMoney((Player) sender, mon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sender.sendMessage(Messages.playerToPlayer(mon, "hinzugefügt"));
                return true;
            } else {
                if (args[0].startsWith("-")) {
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                try {
                    mm.addMoney(target, mon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sender.sendMessage(Messages.playThatSend(target, mon, "hinzugefügt"));
                target.sendMessage(Messages.playerThatTarget((Player) sender, mon, "hinzugefügt"));
            }


        } else {
            sender.sendMessage(ChatColor.RED + "commandUsage /addmoney <value>, /addmoney <value> <player>");
        }
        return true;
    }
}

