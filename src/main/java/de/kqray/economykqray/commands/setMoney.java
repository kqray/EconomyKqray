package de.kqray.economykqray.commands;

import de.kqray.economykqray.Messages;
import de.kqray.economykqray.util.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class setMoney implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Economy mm = new Economy();
        if (!sender.hasPermission("EconomyKqray.setMoney")) {
            sender.sendMessage(Messages.noPerm);
            return true;
        }
        if (args.length == 1) {

            try {
                if (args[0].startsWith("-")) {
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                int a = Integer.parseInt(args[0]);
                mm.setMoney((Player) sender, a);
                sender.sendMessage(Messages.setMoneySelfTo0((Player) sender, a));
            } catch (NumberFormatException e) {
                sender.sendMessage(Messages.noNumber);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (args.length == 2) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(Messages.playerNull);
                return true;
            }
            if (target.getName() == sender.getName()) {
                try {
                    if (args[1].startsWith("-")) {
                        sender.sendMessage(Messages.noNumber);
                        return true;
                    }
                    int b = Integer.parseInt(args[1]);
                    mm.setMoney((Player) sender, b);
                    sender.sendMessage(Messages.setMoneySelfTo0((Player) sender, b));
                } catch (NumberFormatException e) {
                    sender.sendMessage(Messages.noNumber);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (args[1].startsWith("-")) {
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                int b = Integer.parseInt(args[1]);
                mm.setMoney(target, b);
                sender.sendMessage(Messages.setMoneySenderTarget(target, b));
                target.sendMessage(Messages.setMoneyToTarget((Player) sender, b));
            } catch (NumberFormatException e) {
                sender.sendMessage(Messages.noNumber);
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            sender.sendMessage(ChatColor.RED + "commandUsage /setmoney <player> <value>, /setmoney <value>");
        }
        return true;
    }
}

