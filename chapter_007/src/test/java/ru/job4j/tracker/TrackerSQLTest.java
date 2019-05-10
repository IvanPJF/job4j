package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {

    @Test
    public void checkConnection() {
        try (TrackerSQL sql = new TrackerSQL()) {
            assertThat(sql.init(), is(true));
        }
    }

    @Test
    public void whenAddItemToTracker() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            Item item = tracker.add(new Item("Ivan", "IvanDesc", System.currentTimeMillis()));
            Item result = tracker.findById(item.getId());
            assertThat(result, is(item));
            tracker.delete(result.getId());
        }
    }

    @Test
    public void whenReplaceItemToTracker() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            Item itemAdd = tracker.add(new Item("Ivan", "IvanDesc", System.currentTimeMillis()));
            Item itemReplace = new Item("Sam", "SamDesc", System.currentTimeMillis());
            tracker.replace(itemAdd.getId(), itemReplace);
            Item result = tracker.findById(itemAdd.getId());
            assertThat(result.getId(), is(itemAdd.getId()));
            assertThat(result.getName(), is(itemReplace.getName()));
            assertThat(result.getDescription(), is(itemReplace.getDescription()));
            assertThat(result.getCreate(), is(itemReplace.getCreate()));
            tracker.delete(result.getId());
        }
    }

    @Test
    public void whenDeleteItemFromTracker() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            Item itemAdd = tracker.add(new Item("Ivan", "IvanDesc", System.currentTimeMillis()));
            tracker.delete(itemAdd.getId());
            Item result = tracker.findById(itemAdd.getId());
            assertThat(result, is((Item) null));
        }
    }

    @Test
    public void whenFindAllToTracker() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            Item itemOne = tracker.add(new Item("Ivan", "IvanDesc", System.currentTimeMillis()));
            Item itemTwo = tracker.add(new Item("Sam", "SamDesc", System.currentTimeMillis()));
            List<Item> expected = new LinkedList<>(Arrays.asList(itemOne, itemTwo));
            List<Item> result = tracker.findAll();
            assertThat(result, is(expected));
            tracker.delete(itemOne.getId());
            tracker.delete(itemTwo.getId());
        }
    }

    @Test
    public void whenFindByNameToTracker() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            Item itemOne = tracker.add(new Item("Ivan", "IvanDesc", System.currentTimeMillis()));
            Item itemTwo = tracker.add(new Item("Sam", "SamDesc", System.currentTimeMillis()));
            Item itemThree = tracker.add(new Item("Sam", "SamTwoDesc", System.currentTimeMillis()));
            List<Item> expected = new LinkedList<>(Arrays.asList(itemTwo, itemThree));
            List<Item> result = tracker.findByName("Sam");
            assertThat(result, is(expected));
            tracker.delete(itemOne.getId());
            tracker.delete(itemTwo.getId());
            tracker.delete(itemThree.getId());
        }
    }

    @Test
    public void whenFindByIdToTracker() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            Item itemOne = tracker.add(new Item("Ivan", "IvanDesc", System.currentTimeMillis()));
            Item itemTwo = tracker.add(new Item("Sam", "SamDesc", System.currentTimeMillis()));
            Item result = tracker.findById(itemTwo.getId());
            assertThat(result, is(itemTwo));
            tracker.delete(itemOne.getId());
            tracker.delete(itemTwo.getId());
        }
    }
}