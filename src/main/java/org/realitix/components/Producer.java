package org.realitix.components;

import org.realitix.models.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Enqueues faker models into the queue
 */
public class Producer implements Runnable {

    private static final Logger logger = Logger.getLogger(Producer.class.getName());

    private BlockingQueue<FakerModel> objects;

    public Producer(BlockingQueue<FakerModel> objects) {
        this.objects = objects;
    }

    /**
     * Randomly inserts fake users and/or fake quotes into the queue.
     */
    @Override
    public void run() {

        try {
            FakerModel model = FakeModelFactory.getFakerModelInstance();
            objects.offer(model, 2, TimeUnit.SECONDS);
            logger.info("Producer: I produced " + model);
        } catch (InterruptedException e) {
            logger.severe(e.getMessage());
        }

    }
}
