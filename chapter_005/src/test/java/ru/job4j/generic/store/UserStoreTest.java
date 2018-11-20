package ru.job4j.generic.store;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.generic.ContainerIsFullException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStoreTest {

    private UserStore<User> userStore = new UserStore<>(3);
    private User userOne;
    private User userTwo;

    /**
     * Добавление общих элементов User в контейнер.
     * @throws ContainerIsFullException Ошибка при переполнении контейнера.
     */
    @Before
    public void addUserModels() throws ContainerIsFullException {
        userOne = new User("1");
        userTwo = new User("2");
        userStore.add(userOne);
        userStore.add(userTwo);
    }

    /**
     * Добавление элемента User в контейнер.
     */
    @Test
    public void whenAddUserModelInContainer() {
        User userThree = new User("three");
        userStore.add(userThree);
        assertThat(userStore.findById("three"), is(userThree));
    }

    /**
     * Изменение элемента User в контейнере по id.
     */
    @Test
    public void whenReplaceUserModelInContainer() {
        boolean result = userStore.replace("1", userTwo);
        assertThat(result, is(true));
        assertThat(userStore.findById("2"), is(userTwo));
    }

    /**
     * Изменение элемента User в контейнере не удалось из-за неверного id.
     */
    @Test
    public void whenIdIsInvalidForReplaceUserModelInContainer() {
        boolean result = userStore.replace("3", userTwo);
        assertThat(result, is(false));
        assertThat(userStore.findById("3"), is((User) null));
    }

    /**
     * Удаление элемента User из контейнера по id.
     */
    @Test
    public void whenDeleteUserModel() {
        boolean result = userStore.delete("1");
        assertThat(result, is(true));
        assertThat(userStore.findById("1"), is((User) null));
    }

    /**
     * Удаление элемента User из контейнера не удалось из неверного id.
     */
    @Test
    public void whenIdIsInvalidForDeleteUserModel() {
        boolean result = userStore.delete("invalid");
        assertThat(result, is(false));
        assertThat(userStore.findById("1"), is(userOne));
        assertThat(userStore.findById("2"), is(userTwo));
    }

    /**
     * Выброс ошибки переполнения контейнера.
     */
    @Test(expected = ContainerIsFullException.class)
    public void whenContainerIsFullThenThrowException() {
        userStore.add(new User("3"));
        userStore.add(new User("4"));
    }
}