package ru.job4j.bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест.
 * Банк.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.10.2018
 *@version 0.1
 */
public class BankTest {

    /**
     * Тест Добавление клиента.
     */
    @Test
    public void whenAddUserThenUserAddToBank() {
        Bank bank = new Bank();
        User user = new User("Ivan", "1234567890");
        Map<User, List<Account>> expect = new TreeMap<>();
        expect.put(user, null);
        bank.addUser(user);
        assertThat(bank.showUsers(), is(expect.keySet()));
    }

    /**
     * Тест Удаление клиента.
     */
    @Test
    public void whenDeleteUserThenUserRemoveFromBank() {
        Bank bank = new Bank();
        User user = new User("Ivan", "1234567890");
        Map<User, List<Account>> expect = new TreeMap<>();
        bank.addUser(user);
        bank.deleteUser(user);
        assertThat(bank.showUsers(), is(expect.keySet()));
    }

    /**
     * Тест Добавление счёта клиента.
     */
    @Test
    public void whenAddAccountThenAccountAddToUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "1234567890");
        Account account = new Account("1", 1000.0);
        bank.addUser(user);
        bank.addAccount("1234567890", account);
        Map<User, List<Account>> expect = new TreeMap<>();
        List<Account> list = new ArrayList<>();
        list.add(account);
        expect.put(user, list);
        assertThat(bank.getUserAccounts("1234567890"), is(expect.get(user)));
    }

    /**
     * Тест Добавление счёта клиента не удалось.
     */
    @Test
    public void whenAddAccountFailedThenAccountNotAddToUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "1234567890");
        Account account = new Account("1", 1000.0);
        bank.addUser(user);
        bank.addAccount("98765432", account);
        Map<User, List<Account>> expect = new TreeMap<>();
        expect.put(user, new ArrayList<>());
        assertThat(bank.getUserAccounts("1234567890"), is(expect.get(user)));
    }

    /**
     * Тест Удаление счёта клиента.
     */
    @Test
    public void whenDeleteAccountThenAccountRemoveFromUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "1234567890");
        Account account = new Account("1", 1000.0);
        bank.addUser(user);
        bank.addAccount("1234567890", account);
        bank.deleteAccount("1234567890", account);
        Map<User, List<Account>> expect = new TreeMap<>();
        expect.put(user, new ArrayList<>());
        assertThat(bank.getUserAccounts("1234567890"), is(expect.get(user)));
    }

    /**
     * Тест Удаление счёта клиента не удалось.
     */
    @Test
    public void whenDeleteAccountFailedThenAccountNotRemoveFromUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "1234567890");
        Account account = new Account("1", 1000.0);
        bank.addUser(user);
        bank.addAccount("1234567890", account);
        bank.deleteAccount("98765432", account);
        Map<User, List<Account>> expect = new TreeMap<>();
        List<Account> list = new ArrayList<>();
        list.add(account);
        expect.put(user, list);
        assertThat(bank.getUserAccounts("1234567890"), is(expect.get(user)));
    }

    /**
     * Тест Перевод денег между счетами одного клиента.
     */
    @Test
    public void whenTransferMoneyBetweenAccountsOneUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "1234567890");
        Account accountOne = new Account("1", 1000.0);
        Account accountTwo = new Account("2", 200.0);
        bank.addUser(user);
        bank.addAccount("1234567890", accountOne);
        bank.addAccount("1234567890", accountTwo);
        bank.transferMoney(
                "1234567890", "1",
                "1234567890", "2",
                200
        );
        assertThat(
                bank.getUserAccounts("1234567890").get(0).getValue(),
                is(800.0)
        );
    }

    /**
     * Тест Перевод денег между счетами разных клиентов.
     */
    @Test
    public void whenTransferMoneyBetweenAccountsUserOneAndUserTwo() {
        Bank bank = new Bank();
        User userOne = new User("Ivan", "1234567890");
        User userTwo = new User("Pavel", "987654321");
        Account accountOne = new Account("1", 1000.0);
        Account accountTwo = new Account("2", 200.0);
        bank.addUser(userOne);
        bank.addAccount("1234567890", accountOne);
        bank.addUser(userTwo);
        bank.addAccount("987654321", accountTwo);
        bank.transferMoney(
                "1234567890", "1",
                "987654321", "2",
                200
        );
        assertThat(
                bank.getUserAccounts("987654321").get(0).getValue(),
                is(400.0)
        );
    }
}
