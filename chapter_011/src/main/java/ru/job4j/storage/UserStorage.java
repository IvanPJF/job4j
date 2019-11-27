package ru.job4j.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class user storage.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 27.11.2019
 */
@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private final Map<Integer, IUser> storage = new HashMap<>();

    /**
     * Add user to storage.
     *
     * @param user
     * @return
     */
    public synchronized boolean add(IUser user) {
        boolean result = false;
        if (!isExistUser(user.getId())) {
            this.storage.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    /**
     * Update user in the storage.
     * A user with the same id should be in the storage.
     *
     * @param user The new user value.
     * @return
     */
    public synchronized boolean update(IUser user) {
        boolean result = false;
        if (isExistUser(user.getId())) {
            this.storage.replace(user.getId(), user);
            result = true;
        }
        return result;
    }

    /**
     * Deletes the user.
     *
     * @param user
     * @return
     */
    public synchronized boolean delete(IUser user) {
        boolean result = false;
        if (isExistUser(user.getId())) {
            this.storage.remove(user.getId());
            result = true;
        }
        return result;
    }

    /**
     * It transfers the amount from one user to another user.
     *
     * @param fromId The id of the user from whom we withdraw the amount.
     * @param toId   The id of the user to whom we transfer the amount.
     * @param amount The amount of the amount.
     * @return
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if (isExistUser(fromId) && isExistUser(toId)) {
            IUser fromUser = this.storage.get(fromId);
            IUser toUser = this.storage.get(toId);
            if (fromUser.getAmount() >= amount) {
                fromUser.minus(amount);
                toUser.plus(amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Checks for the presence of the user with the specified id.
     *
     * @param userId User id to search.
     * @return
     */
    private synchronized boolean isExistUser(int userId) {
        return this.storage.containsKey(userId);
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserStorage storage1 = (UserStorage) o;
        return Objects.equals(storage, (storage1).storage);
    }

    @Override
    public synchronized int hashCode() {
        return Objects.hash(storage);
    }
}
