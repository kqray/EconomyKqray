package de.kqray.economykqray.commands;

import de.kqray.economykqray.Messages;
import de.kqray.economykqray.util.MoneyManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class removeMoney implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        MoneyManager mm = new MoneyManager();

        if (args.length == 1){
            if (args[0].startsWith("-")){
                sender.sendMessage(Messages.noNumber);
                return true;
            }
            try {
                int a = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                sender.sendMessage(Messages.noNumber);
                return true;
            }
            int a = Integer.parseInt(args[0]);
            try {
                mm.removeMoney((Player) sender, a);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sender.sendMessage(Messages.playerToPlayer(a, "entfernt"));

            return true;

        }else if (args.length == 2){
            if (args[1].startsWith("-")){
                sender.sendMessage(Messages.noNumber);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(Messages.playerNull);
                return true;
            }
            if (target.getName() == sender.getName()){
                if (args[1].startsWith("-")){
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                try {
                    int a = Integer.parseInt(args[1]);
                }catch (NumberFormatException e){
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                int a = Integer.parseInt(args[1]);
                try {
                    mm.removeMoney((Player) sender, a);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sender.sendMessage(Messages.playerToPlayer(a, "entfernt"));
            }
            try {
                if (mm.getMoney(target) <= 0){
                    sender.sendMessage(ChatColor.RED+"Der ausgewählte Spieler hat nichts mehr zu entfernen");
                    return true;
                }
                if (args[1].startsWith("-")){
                    sender.sendMessage(Messages.noNumber);
                    return true;
                }
                int a = Integer.parseInt(args[1]);
                mm.removeMoney(target, a);
                sender.sendMessage(Messages.playThatSend(target, a, "entfernt"));
                target.sendMessage(Messages.playerThatTarget((Player) sender, a, "entfernt"));
            } catch (NumberFormatException e) {
                sender.sendMessage(Messages.noNumber);
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            sender.sendMessage(ChatColor.RED+"CommandUsage: /removemoney <value>, /removemoney <player> <value>");
        }
        return false;
    }
}

