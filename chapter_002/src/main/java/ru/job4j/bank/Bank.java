package ru.job4j.bank;

import java.util.*;

public class Bank {

    private Map<User, List<Account>> users = new TreeMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public User findUser(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = this.users.get(this.findUser(passport));
        if (accounts != null) {
            accounts.add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = this.users.get(this.findUser(passport));
        if (accounts != null) {
            accounts.remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        User user = this.findUser(passport);
        if (user != null) {
            accounts = users.get(user);
        }
        return accounts;
    }

    public Account findAccount(String passport, String requisite) {
        return getUserAccounts(passport)
                .stream()
                .filter(account -> requisite == account.getRequisites())
                .findFirst()
                .orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findAccount(srcPassport, srcRequisite);
        Account destAccount = findAccount(destPassport, destRequisite);
        if (destAccount != null) {
            destAccount.transfer(srcAccount, amount);
        }
        return result;
    }
}