package de.kqray.economykqray.util;

import org.bukkit.entity.Player;

import java.io.IOException;

public class Economy {
    ConfigHandler c = new ConfigHandler();

    public int getMoney(Player player) {
        return c.getInt((player.getUniqueId().toString() + "." + "Money"));
    }

    public void setMoney(Player player, int value) throws IOException {
        c.cfg.set(player.getUniqueId() + "." + "Money", value);
        c.save();
    }

    public void addMoney(Player player, int value) throws IOException {
        int mon = c.getInt(player.getUniqueId().toString() + "." + "Money");
        c.cfg.set((player.getUniqueId().toString() + "." + "Money"), mon + value);
        c.save();
    }

    public void removeMoney(Player player, int value) throws IOException {
        int mon = c.getInt(player.getUniqueId().toString() + "." + "Money");
        c.cfg.set((player.getUniqueId().toString() + "." + "Money"), mon - value);
        c.save();
    }

    public void payMoney(Player tosender, Player totarget, int value) throws IOException {
        int sendermoney = c.getInt(tosender.getUniqueId().toString() + "." + "Money");
        int targetmoney = c.getInt(totarget.getUniqueId().toString() + "." + "Money");

        c.cfg.set((tosender.getUniqueId().toString() + "." + "Money"), sendermoney - value);
        c.cfg.set((totarget.getUniqueId().toString() + "." + "Money"), targetmoney + value);
        c.save();
    }

    public Boolean isBankAccount(Player tocheckaccount) {
        return c.cfg.getBoolean(tocheckaccount.getUniqueId().toString() + "BankAccount");
    }

    public void toggleOnBankAccount(Player toactivate) throws IOException {
        c.cfg.set(toactivate.getUniqueId().toString() + ".BankAccount", true);
        c.save();
    }

    public void toggleOffBankAccount(Player todeactivate) throws IOException {
        c.cfg.set(todeactivate.getUniqueId().toString() + ".BankAccount", false);
        c.save();
    }

}
