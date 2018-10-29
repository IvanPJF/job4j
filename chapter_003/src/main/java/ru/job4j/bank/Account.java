package ru.job4j.bank;

/**
 * Аккаунт клиента.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.10.2018
 *@version 0.1
 */
public class Account {
    private String requisites;
    private double value;

    public Account(String requisites, double value) {
        this.setRequisites(requisites);
        this.setValue(value);
    }

    /**
     * Перевод денежных средств между счетами.
     * @param dest Аккаунт-получатель перевода.
     * @param amount Размер перевода.
     * @return Логический результат перевода.
     */
    public boolean transfer(Account dest, double amount) {
        boolean success = false;
        if (dest != null && !this.equals(dest) && amount > 0 && amount <= this.getValue()) {
            this.setValue(this.getValue() - amount);
            dest.setValue(dest.getValue() + amount);
            success = true;
        }
        return success;
    }

    @Override
    public String toString() {
        return String.format("Account[requisites = %s, value = %s]", this.getRequisites(), this.getValue());
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Account other = (Account) o;
            result = this.getRequisites().equals(other.getRequisites());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return this.getRequisites().hashCode();
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public Double getValue() {
        return this.value;
    }

    public String getRequisites() {
        return this.requisites;
    }
}
