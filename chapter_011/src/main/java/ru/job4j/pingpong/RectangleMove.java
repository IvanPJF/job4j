package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Class rectangle movement.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 07.11.2019
 */
public class RectangleMove implements Runnable {

    private final Rectangle rect;
    private final double limitX;
    private final double limitY;
    private final Random random = new Random();

    public RectangleMove(Rectangle rect, double limX, double limY) {
        this.rect = rect;
        limitX = limX;
        limitY = limY;
    }

    /**
     * Starting a thread with rectangle moving logic.
     */
    @Override
    public void run() {
        int trendX = random.nextInt(3) + 3;
        int trendY = random.nextInt(3) + 3;
        while (true) {
            double newPositionX = rect.getX() + trendX;
            double newPositionY = rect.getY() + trendY;
            rect.setX(newPositionX);
            rect.setY(newPositionY);
            if (newPositionX + rect.getWidth() >= limitX || newPositionX <= 0) {
                trendX *= -1;
            }
            if (newPositionY + rect.getHeight() >= limitY || newPositionY <= 0) {
                trendY *= -1;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
