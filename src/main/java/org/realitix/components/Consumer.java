package org.realitix.components;

import org.realitix.models.FakerModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Consumes faker objects from the blocking queue.
 */
public class Consumer implements Runnable{

    private static final Logger logger = Logger.getLogger(Consumer.class.getName());

    private BlockingQueue<FakerModel> objects;

    public Consumer(BlockingQueue<FakerModel> objects) {
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
