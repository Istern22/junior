package ru.job4j.bank;

import org.junit.Test;

import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("petr0", "000"));
        bank.addAccountToUser("000", new Account(0.0, "0"));
        assertThat(bank.getUserAccounts("000").get(0).getValue(), is(0.0));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        bank.addUser(new User("petr1", "001"));
        bank.addAccountToUser("001", new Account(0.1, "1"));
        bank.addUser(new User("petr0", "000"));
        bank.addAccountToUser("000", new Account(0.0, "0"));
        bank.deleteUser(new User("petr1", "001"));
        assertThat(bank.getUserAccounts("000").get(0).getValue(), is(0.0));
    }

    @Test
    public void whenDeleteExistedAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("petr0", "000"));
        Account account0 = new Account(0.0, "0");
        bank.addAccountToUser("000", account0);
        bank.deleteAccountFromUser("000", new Account(0.0, "0"));
        assertThat(bank.getUserAccounts("000").size(), is(0));
    }

    @Test
    public void whenDeleteNotExistedAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("petr0", "000"));
        Account account0 = new Account(0.0, "0");
        bank.deleteAccountFromUser("000", account0);
        assertThat(bank.getUserAccounts("000").size(), is(0));
    }

    @Test
    public void whenDeleteAccountByRequisites() {
        Bank bank = new Bank();
        bank.addUser(new User("petr0", "000"));
        bank.addAccountToUser("000", new Account(0.0, "0"));
        bank.deleteAccountFromUser("000", new Account(0.0, "0"));
        assertThat(bank.getUserAccounts("000").size(), is(0));
    }

    @Test
    public void whenBothAccountsExistAndOperationPossible() {
        Bank bank = new Bank();
        bank.addUser(new User("petr1", "001"));
        bank.addAccountToUser("001", new Account(10, "1"));
        bank.addUser(new User("petr0", "000"));
        bank.addAccountToUser("000", new Account(11, "0"));
        bank.transferMoney("001", "1", "000", "0", 10);
        assertThat(bank.getUserAccounts("000").get(0).getValue(), is(21.0));
        assertThat(bank.getUserAccounts("001").get(0).getValue(), is(0.0));
    }

    @Test
    public void whenBothAccountsExistAndOperationImpossible() {
        Bank bank = new Bank();
        bank.addUser(new User("petr1", "001"));
        bank.addAccountToUser("001", new Account(0, "1"));
        bank.addUser(new User("petr0", "000"));
        bank.addAccountToUser("000", new Account(11, "0"));
        bank.transferMoney("001", "1", "000", "0", 10);
        assertThat(bank.getUserAccounts("000").get(0).getValue(), is(11.0));
    }

    @Test
    public void whenAccountNotExist() {
        Bank bank = new Bank();
        bank.addUser(new User("petr1", "001"));
        bank.addAccountToUser("001", new Account(0, "1"));
        bank.addUser(new User("petr0", "000"));
        bank.addAccountToUser("000", new Account(11, "0"));
        bank.transferMoney("001", "2", "000", "0", 10);
        assertThat(bank.getUserAccounts("000").get(0).getValue(), is(11.0));
    }

    @Test
    public void whenTransferBetweenOneUser() {
        Bank bank = new Bank();
        bank.addUser(new User("petr1", "001"));
        bank.addAccountToUser("001", new Account(10, "1"));
        bank.addAccountToUser("001", new Account(11, "0"));
        bank.transferMoney("001", "1", "001", "0", 10);
        assertThat(bank.getUserAccounts("001").get(1).getValue(), is(21.0));
    }
}
