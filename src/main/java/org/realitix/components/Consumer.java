package org.realitix.components;

import org.realitix.models.FakerModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Consumer<T extends FakerModel> implements Runnable{

    private static final Logger logger = Logger.getLogger(Consumer.class.getName());

    BlockingQueue<T> objects;

    public Consumer(BlockingQueue<T> integers) {
        this.objects = integers;
    }

    @Override
    public void run() {
        try {
            logger.info("Consumer: I consumed: " + objects.poll(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            logger.severe(e.getMessage());
        }
    }
}
