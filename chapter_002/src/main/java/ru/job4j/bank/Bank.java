package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {

    private Map<User, List<Account>> users = new TreeMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = this.users.get(new User(null, passport));
        if (accounts != null) {
            accounts.add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = this.users.get(new User(null, passport));
        if (accounts != null) {
            accounts.remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        return this.users.get(new User(null, passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        List<Account> src = this.getUserAccounts(srcPassport);
        List<Account> dest = this.getUserAccounts(destPassport);
        if (src != null && dest != null) {
            int srcIndex = src.indexOf(new Account(0, srcRequisite));
            int destIndex = dest.indexOf(new Account(0, destRequisite));
            if (srcIndex >= 0 && destIndex >= 0) {
                Account srcAccount = src.get(srcIndex);
                Account destAccount = dest.get(destIndex);
                if (srcAccount.getValue() != 0.0 && srcAccount.getValue() <= amount) {
                        srcAccount.setValue(srcAccount.getValue() - amount);
                        destAccount.setValue(destAccount.getValue() + amount);
                        result = true;
                }
            }
        }
        return result;
    }
}
