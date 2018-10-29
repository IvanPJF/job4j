package ru.job4j.bank;

import java.util.*;

/**
 * Банк.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.10.2018
 *@version 0.1
 */
public class Bank {
    private Map<User, List<Account>> users = new TreeMap<>();

    /**
     * Показать всех клиентов.
     * @return Множество клиентов.
     */
    public Set<User> showUsers() {
        return this.users.keySet();
    }

    /**
     * Добавление клиента.
     * @param user Клиент.
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаление клиента.
     * @param user Клиент.
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Добавление счёта клиента.
     * @param passport Паспорт клиента.
     * @param account Новый счёт.
     */
    public void addAccount(String passport, Account account) {
        boolean duplicate = isAddAccount(account);
        for (User user : this.users.keySet()) {
            if (user != null && user.getPassport().equals(passport) && !duplicate) {
                this.users.get(user).add(account);
                break;
            }
        }
    }

    /**
     * Удаление счёта клиента.
     * @param passport Паспорт клиента.
     * @param account Удаляемый счёт.
     */
    public void deleteAccount(String passport, Account account) {
        boolean duplicate = isAddAccount(account);
        for (User user : this.users.keySet()) {
            if (user != null && user.getPassport().equals(passport) && duplicate) {
                this.users.get(user).remove(account);
                break;
            }
        }
    }

    /**
     * Проверка на наличие в базе счетов искомого счёта.
     * @param account Искомый счёт.
     * @return Результат проверки.
     */
    private boolean isAddAccount(Account account) {
        boolean result = false;
        for (List<Account> element : this.users.values()) {
            if (element != null && element.contains(account)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получить список счетов клиента.
     * @param passport Паспорт клиента.
     * @return Список счетов клиента.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = null;
        for (User user : this.users.keySet()) {
            if (user != null && user.getPassport().equals(passport)) {
                result = this.users.get(user);
                break;
            }
        }
        return result;
    }

    /**
     * Поиск счёта по паспорту и реквизитам.
     * @param passport Паспорт.
     * @param requisites Реквизиты.
     * @return Найденный счёт(null - если счёт не найден).
     */
    public Account activeAccount(String passport, String requisites) {
        Account result = null;
        for (Account element : getUserAccounts(passport)) {
            if (element != null && element.getRequisites().equals(requisites)) {
                result = element;
                break;
            }
        }
        return result;
    }

    /**
     * Перевод денежных средств с одного счёта на другой.
     * @param srcPassport Паспорт клиента, со счёта которого переводятся средства.
     * @param srcRequisites Реквизиты счёта с которого переводятся средства.
     * @param destPassport Паспорт клиента, на счёт которого переводятся средства.
     * @param destRequisites Реквизиты счёта на который переводятся средства.
     * @param amount Объём средств для перевода.
     * @return Логический результат перевода.
     */
    public boolean transferMoney(String srcPassport, String srcRequisites,
                                 String destPassport, String destRequisites,
                                 double amount) {
        Account srcAccount = activeAccount(srcPassport, srcRequisites);
        Account destAccount = activeAccount(destPassport, destRequisites);
        return srcAccount != null
                && !srcAccount.equals(destAccount)
                && srcAccount.transfer(destAccount, amount);
    }
}
