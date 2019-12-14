package ru.job4j.bank;

public class Account {

    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.requisites.equals(account.getRequisites());
    }

    public int hashCode() {
        return this.requisites.hashCode();
    }

    public boolean transfer(Account srcAccount, double amount) {
        boolean result = false;
        if (srcAccount != null && srcAccount.getValue() >= amount) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            this.setValue(this.getValue() + amount);
            result = true;
        }
        return result;
    }
}
