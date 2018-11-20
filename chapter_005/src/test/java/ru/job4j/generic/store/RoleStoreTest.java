package ru.job4j.generic.store;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.generic.ContainerIsFullException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    private RoleStore<Role> roleStore = new RoleStore<>(3);
    private Role roleOne;
    private Role roleTwo;

    /**
     * Добавление общих элементов Role в контейнер.
     * @throws ContainerIsFullException Ошибка при переполнении контейнера.
     */
    @Before
    public void addRoleModels() throws ContainerIsFullException {
        roleOne = new Role("1");
        roleTwo = new Role("2");
        roleStore.add(roleOne);
        roleStore.add(roleTwo);
    }

    /**
     * Добавление элемента Role в контейнер.
     */
    @Test
    public void whenAddRoleModelInContainer() {
        Role roleThree = new Role("three");
        roleStore.add(roleThree);
        assertThat(roleStore.findById("three"), is(roleThree));
    }

    /**
     * Изменение элемента Role в контейнере по id.
     */
    @Test
    public void whenReplaceRoleModelInContainer() {
        boolean result = roleStore.replace("1", roleTwo);
        assertThat(result, is(true));
        assertThat(roleStore.findById("2"), is(roleTwo));
    }

    /**
     * Изменение элемента Role в контейнере не удалось из-за неверного id.
     */
    @Test
    public void whenIdIsInvalidForReplaceRoleModelInContainer() {
        boolean result = roleStore.replace("3", roleTwo);
        assertThat(result, is(false));
        assertThat(roleStore.findById("3"), is((User) null));
    }

    /**
     * Удаление элемента Role из контейнера по id.
     */
    @Test
    public void whenDeleteRoleModel() {
        boolean result = roleStore.delete("1");
        assertThat(result, is(true));
        assertThat(roleStore.findById("1"), is((User) null));
    }

    /**
     * Удаление элемента Role из контейнера не удалось из неверного id.
     */
    @Test
    public void whenIdIsInvalidForDeleteRoleModel() {
        boolean result = roleStore.delete("invalid");
        assertThat(result, is(false));
        assertThat(roleStore.findById("1"), is(roleOne));
        assertThat(roleStore.findById("2"), is(roleTwo));
    }

    /**
     * Выброс ошибки переполнения контейнера.
     */
    @Test(expected = ContainerIsFullException.class)
    public void whenContainerIsFullThenThrowException() {
        roleStore.add(new Role("3"));
        roleStore.add(new Role("4"));
    }
}