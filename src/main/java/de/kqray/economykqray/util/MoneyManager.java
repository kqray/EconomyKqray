package de.kqray.economykqray.util;

import org.bukkit.entity.Player;

public class MoneyManager {
    ConfigHandler c = new ConfigHandler();
    public int getMoney(Player player){
        return c.getConfig().getInt((player.getUniqueId().toString()+"."+"Money"));
    }

    public void setMoney(Player player, int value){
        c.setInt(player.getUniqueId()+"."+"Money", value);
        c.save();
    }

    public void addMoney(Player player, int value){
        int mon = c.getInt(player.getUniqueId().toString()+"."+"Money");
        c.getConfig().set((player.getUniqueId().toString()+"."+"Money"), mon + value);
        c.save();
    }

    public void removeMoney(Player player, int value){
        int mon = c.getInt(player.getUniqueId().toString()+"."+"Money");
        c.getConfig().set((player.getUniqueId().toString()+"."+"Money"), mon - value);
        c.save();
    }

    public void payMoney(Player tosender, Player totarget, int value){
        int sendermoney = c.getInt(tosender.getUniqueId().toString()+"."+"Money");
        int targetmoney = c.getInt(totarget.getUniqueId().toString()+"."+"Money");

        c.getConfig().set((tosender.getUniqueId().toString()+"."+"Money"), sendermoney - value);
        c.getConfig().set((totarget.getUniqueId().toString()+"."+"Money"), targetmoney + value);
        c.save();
    }
}
