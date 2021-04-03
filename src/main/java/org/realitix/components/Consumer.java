package org.realitix.components;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Consumer<T> implements Runnable{

    private static final Logger logger = Logger.getLogger(Consumer.class.getName());

    BlockingQueue<T> integers;

    public Consumer(BlockingQueue<T> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        try {
            logger.info("Consumer: I consumed: " + integers.poll(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            logger.severe(e.getMessage());
        }
    }
}
