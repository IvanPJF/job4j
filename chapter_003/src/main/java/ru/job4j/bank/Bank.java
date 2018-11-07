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
        this.users.keySet().stream().filter(
                user -> user != null && user.getPassport().equals(passport) && !duplicate
        ).findFirst().ifPresent(
                user -> this.users.get(user).add(account)
        );
    }

    /**
     * Удаление счёта клиента.
     * @param passport Паспорт клиента.
     * @param account Удаляемый счёт.
     */
    public void deleteAccount(String passport, Account account) {
        boolean duplicate = isAddAccount(account);
        this.users.keySet().stream().filter(
                user -> user != null && user.getPassport().equals(passport) && duplicate
        ).findFirst().ifPresent(
                user -> this.users.get(user).remove(account)
        );
    }

    /**
     * Проверка на наличие в базе счетов искомого счёта.
     * @param account Искомый счёт.
     * @return Результат проверки.
     */
    private boolean isAddAccount(Account account) {
        return this.users.values().stream().anyMatch(
                element -> element != null && element.contains(account)
        );
    }

    /**
     * Получить список счетов клиента.
     * @param passport Паспорт клиента.
     * @return Список счетов клиента.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.users.keySet().stream().filter(
                user -> user != null && user.getPassport().equals(passport)
        ).findFirst().map(
                user -> this.users.get(user)
        ).orElse(null);
    }

    /**
     * Поиск счёта по паспорту и реквизитам.
     * @param passport Паспорт.
     * @param requisites Реквизиты.
     * @return Найденный счёт(null - если счёт не найден).
     */
    public Account activeAccount(String passport, String requisites) {
        return getUserAccounts(passport).stream().filter(
                element -> element != null && element.getRequisites().equals(requisites)
        ).findFirst().orElse(null);
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
