package de.kqray.economykqray.util;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Economy {
    ConfigHandler c = new ConfigHandler();

    public int getMoney(@NotNull Player player) {
        return c.cfg.getInt((player.getUniqueId() + "." + "Money"));
    }

    public void setMoney(@NotNull Player player, int value) throws IOException {
        c.cfg.set(player.getUniqueId() + "." + "Money", value);
        c.save();
    }

    public void addMoney(@NotNull Player player, int value) throws IOException {
        int mon = c.cfg.getInt(player.getUniqueId() + "." + "Money");
        c.cfg.set((player.getUniqueId() + "." + "Money"), mon + value);
        c.save();
    }

    public void removeMoney(@NotNull Player player, int value) throws IOException {
        int mon = c.getInt(player.getUniqueId() + "." + "Money");
        c.cfg.set((player.getUniqueId() + "." + "Money"), mon - value);
        c.save();
    }

    public void payMoney(@NotNull Player tosender, @NotNull Player totarget, int value) throws IOException {
        int sendermoney = c.getInt(tosender.getUniqueId() + "." + "Money");
        int targetmoney = c.getInt(totarget.getUniqueId() + "." + "Money");

        c.cfg.set((tosender.getUniqueId() + "." + "Money"), sendermoney - value);
        c.cfg.set((totarget.getUniqueId() + "." + "Money"), targetmoney + value);
        c.save();
    }

    public Boolean BankAccountExist(@NotNull Player tocheckaccount) {
        return c.cfg.getBoolean(tocheckaccount.getUniqueId() + "BankAccount");
    }

    public void BankAccountToggleOn(@NotNull Player toactivate) throws IOException {
        c.cfg.set(toactivate.getUniqueId() + ".BankAccount", true);
        c.save();
    }

    public void BankAccountToggleOff(@NotNull Player todeactivate) throws IOException {
        c.cfg.set(todeactivate.getUniqueId() + ".BankAccount", false);
        c.save();
    }

    public Boolean hasEnoughtMoney(Player tocheckmoney, int value){
        return getMoney(tocheckmoney) >= value;
    }

    public int BankAccountGetMoney(@NotNull Player tocheck){
        return c.cfg.getInt(tocheck.getUniqueId() + ".BankAccount." + "Money");
    }

    public Boolean BankAccountHasEnoughtMoney(Player tocheckmoney, int value){
        return BankAccountGetMoney(tocheckmoney) >= value;
    }

    public void BankAccountSetMoney(@NotNull Player toset, int value) throws IOException {
        c.cfg.set(toset.getUniqueId() + ".BankAccount." + "Money", value);
        c.save();
    }

    public void BankAccountAddMoney(@NotNull Player toadd, int value){
        int getint = c.cfg.getInt(toadd.getUniqueId() + ".BankAccount." + "Money");
        c.cfg.set(toadd.getUniqueId() + ".BankAccount." + "Money", getint + value);
        try {
            c.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BankAccountRemoveMoney(@NotNull Player toremove, int value){
        int getint = c.cfg.getInt(toremove.getUniqueId() + ".BankAccount." + "Money");
        c.cfg.set(toremove.getUniqueId() + ".BankAccount." + "Money", getint - value);
    }

}
