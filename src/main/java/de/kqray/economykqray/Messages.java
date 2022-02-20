package de.kqray.economykqray;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {
    public static String noPayer = ChatColor.RED+"Du darfst diesen Command nur als Spieler ausführen";
    public static String noPerm = ChatColor.RED+"Du hast nicht die nötigen Berechtigungen um diesen Command auszuführen";
    public static String playerNull = ChatColor.RED+"Der gewünschte Spieler ist nicht online oder ist nicht verfügbar";
    public static String noNumber = ChatColor.RED+"Du darfst als value nur eine zahl nehmen";
    public static String notEnoughtMoney = ChatColor.RED+"Du hast nicht genügend geld um diese Action durchzuführen";

    public static String playThatSend(Player target, int value, String action){
        return ChatColor.GREEN +"Du hast dem spieler "+ChatColor.GOLD+target.getName()+ChatColor.GREEN+" "+value+"$"+" "+action;
    }
    public static String playerThatTarget(Player send, int value, String action){
        return ChatColor.GOLD +"Der Spieler "+ChatColor.GREEN+send.getName()+ChatColor.GOLD+" hat dir "+ChatColor.GREEN +value+"$"+ChatColor.GOLD+" "+action;
    }
    public static String playerToPlayer(int value, String action){
        return ChatColor.GREEN+"Du hast dir "+ChatColor.GOLD+ value +"$"+ ChatColor.GREEN+" "+ action;
    }
    public static String senderMoney(int value){
        return ChatColor.GREEN+"Dein Kontostand beträgt "+ChatColor.GOLD+value+"$";
    }
    public static String targetMoney(Player target, int value){
        return ChatColor.GREEN+"Der Spieler "+ChatColor.GOLD+target.getName()+ChatColor.GREEN+" hat "+ChatColor.GOLD+value+"$";
    }
    public static String setMoneySenderTarget(Player target,int value){
        return ChatColor.GREEN+"Du hast den Kontostand von "+ChatColor.GOLD+ target.getName() +ChatColor.GREEN+" auf "+ChatColor.GOLD+value+"$"+ChatColor.GREEN+" gesetzt";
    }
    public static String setMoneySelfTo0(Player sender, int value){
        return ChatColor.GREEN+"Du hast deinen Kontostand auf "+ChatColor.GOLD+ value +"$"+ ChatColor.GREEN+" "+ "gesetzt";
    }
    public static String setMoneyToTarget(Player send, int value){
        return ChatColor.GREEN+"Der Spieler "+ChatColor.GOLD+send.getName()+ChatColor.GREEN+" hat deinen Kontostand auf "+ChatColor.GOLD+value+"$"+ChatColor.GREEN+" gesetzt";
    }
}
