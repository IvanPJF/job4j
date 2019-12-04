package ru.job4j.queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
                try {
                    outList.add(queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
                try {
                    outList.add(queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertThat(inList, is(outList));
    }

    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);
        Thread producer = new Thread(
                () -> {
                    for (int i = 0; i < 4; i++) {
                        queue.offer(i);
                    }
                }
        );
        Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        try {
                            buffer.add(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        producer.start();
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3)));
    }
}