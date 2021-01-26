package com.epam.jwd_online_book_store.domain;

import java.util.Objects;

public class UserBankAccount {
    private String iban;
    private String cvv;

    public UserBankAccount() {
    }

    public UserBankAccount(String iban, String cvv) {
        this.iban = iban;
        this.cvv = cvv;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBankAccount that = (UserBankAccount) o;
        return iban.equals(that.iban) &&
                cvv.equals(that.cvv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, cvv);
    }

    @Override
    public String toString() {
        return "UserBankAccount{" +
                "iban='" + iban + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
