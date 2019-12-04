package ru.job4j.queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleBlockingQueueTest {

    @Test
    public void whenInListContainsElementsThenAfterWorkOutListContainsSameElements() throws InterruptedException {
        List<Integer> inList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> outList = new ArrayList<>();
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);
        Thread producer = new Thread(() -> {
            int position = 0;
            while (inList.size() > position) {
                queue.offer(inList.get(position++));
            }
        });
        Thread consumer = new Thread(() -> {
            while (inList.size() != outList.size()) {
                outList.add(queue.poll());
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertThat(inList, is(outList));
    }

    @Test
    public void whenInListIsEmptyThenAfterWorkOutListContainsIsEmpty() throws InterruptedException {
        List<Integer> inList = new ArrayList<>();
        List<Integer> outList = new ArrayList<>();
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);
        Thread producer = new Thread(() -> {
            int position = 0;
            while (inList.size() > position) {
                queue.offer(inList.get(position++));
            }
        });
        Thread consumer = new Thread(() -> {
            while (inList.size() != outList.size()) {
                outList.add(queue.poll());
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertThat(inList, is(outList));
    }
}