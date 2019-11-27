package ru.job4j.storage;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {

    @Test
    public void whenAddUserThenTrue() {
        UserStorage storage = new UserStorage();
        boolean result = storage.add(new User(1, 100));
        assertThat(result, is(true));
    }

    @Test
    public void whenAddUserTwiceThenFalse() {
        UserStorage storage = new UserStorage();
        IUser user = new User(1, 100);
        storage.add(user);
        boolean result = storage.add(user);
        assertThat(result, is(false));
    }

    @Test
    public void whenUpdateUserThenTrueAndNewAmount() {
        UserStorage storage = new UserStorage();
        IUser user = new User(1, 100);
        IUser userUpdate = new User(1, 200);
        storage.add(user);
        boolean result = storage.update(userUpdate);
        UserStorage expectedStorage = new UserStorage();
        expectedStorage.add(userUpdate);
        assertThat(result, is(true));
        assertThat(storage, is(expectedStorage));
    }

    @Test
    public void whenDeleteUserThenTrueAndEmptyStorage() {
        UserStorage storage = new UserStorage();
        IUser user = new User(1, 100);
        storage.add(user);
        boolean result = storage.delete(user);
        UserStorage expectedStorage = new UserStorage();
        assertThat(result, is(true));
        assertThat(storage, is(expectedStorage));
    }

    @Test
    public void whenAddUserTwiceInTwoThreadsThen1User() throws InterruptedException {
        UserStorage storage = new UserStorage();
        IUser user = new User(1, 100);
        Runnable runnable = () -> storage.add(user);
        Thread threadFirst = new Thread(runnable);
        Thread threadSecond = new Thread(runnable);
        threadFirst.start();
        threadSecond.start();
        threadFirst.join();
        threadSecond.join();
        UserStorage expectedStorage = new UserStorage();
        expectedStorage.add(user);
        assertThat(storage, is(expectedStorage));
    }

    @Test
    public void whenTransferAmountFromUserOneToUserTwoInTwoThreadThenUserOneAmountDecreaseAndUserTwoAmountIncrease() throws InterruptedException {
        UserStorage storage = new UserStorage();
        final int idFrom = 1;
        final int idTo = 2;
        final int userAmount = 100;
        final int transferAmount = 10;
        final int countThread = 2;
        IUser userOne = new User(idFrom, userAmount);
        IUser userTwo = new User(idTo, userAmount);
        storage.add(userOne);
        storage.add(userTwo);
        Runnable transfer = () -> storage.transfer(idFrom, idTo, transferAmount);
        Thread threadFirst = new Thread(transfer);
        Thread threadSecond = new Thread(transfer);
        threadFirst.start();
        threadSecond.start();
        threadFirst.join();
        threadSecond.join();
        UserStorage expectedStorage = new UserStorage();
        expectedStorage.add(new User(idFrom, userAmount - transferAmount * countThread));
        expectedStorage.add(new User(idTo, userAmount + transferAmount * countThread));
        assertThat(storage, is(expectedStorage));
    }
}