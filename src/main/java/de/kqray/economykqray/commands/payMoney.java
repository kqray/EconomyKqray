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

public class payMoney implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {


        Economy mm = new Economy();

        if (!sender.hasPermission("EconomyKqray.payMoney")) {
            sender.sendMessage(Messages.noPerm);
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.noPayer);
            return true;
        } else if (args.length == 2) {
            Player p = (Player) sender;


            try {
                int a = Integer.parseInt(args[1]);
                int money = Integer.parseInt(String.valueOf(mm.getMoney(p)));
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage(Messages.playerNull);
                    return true;
                }
                if (args[1].startsWith("-")) {
                    sender.sendMessage(ChatColor.RED + "CommandUsage: /pay <player> <value>");
                    return true;
                }

                if (!(money >= a)) {
                    sender.sendMessage(Messages.notEnoughtMoney);
                    return true;
                }

                mm.payMoney((Player) sender, target, a);
                sender.sendMessage(Messages.playThatSend(target, a, "gegeben"));
                target.sendMessage(Messages.playerThatTarget((Player) sender, a, "gegeben"));
            } catch (NumberFormatException e) {
                sender.sendMessage(Messages.noNumber);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            sender.sendMessage(ChatColor.RED + "commandUsage /pay <player> <value>");
            return true;
        }
        return false;
    }
}
