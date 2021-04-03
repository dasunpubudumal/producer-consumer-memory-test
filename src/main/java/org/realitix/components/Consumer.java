package org.realitix.components;

import org.realitix.models.FakerModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Consumes faker objects from the blocking queue.
 * @param <T> Faker model type
 */
public class Consumer<T extends FakerModel> implements Runnable{

    private static final Logger logger = Logger.getLogger(Consumer.class.getName());

    private BlockingQueue<T> objects;

    public Consumer(BlockingQueue<T> objects) {
        this.objects = objects;
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
