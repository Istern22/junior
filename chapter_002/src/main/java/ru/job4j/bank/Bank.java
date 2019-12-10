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
        List<Account> accounts = new ArrayList<>();
        for (User user : users.keySet()) {
            if (passport == user.getPassport()) {
                accounts = users.get(user);
                break;
            }
        }
        return accounts;
    }

    public Account findAccount(String passport, String requisite) {
        List<Account> accounts = getUserAccounts(passport);
        Account userAccount = null;
        for (Account account : accounts) {
            if (requisite == account.getRequisites()) {
                userAccount = account;
                break;
            }
        }
        return userAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findAccount(srcPassport, srcRequisite);
        Account destAccount = findAccount(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getValue() >= amount) {
                srcAccount.setValue(srcAccount.getValue() - amount);
                destAccount.setValue(destAccount.getValue() + amount);
                result = true;
            }
        return result;
    }
}