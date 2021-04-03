package org.realitix.components;

import org.realitix.models.FakeUser;
import org.realitix.models.FakeUserFactory;
import org.realitix.models.FakerModel;

import java.util.concurrent.BlockingQueue;
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

    @Override
    public void run() {

        FakerModel fakeUser = FakeUserFactory.getFakeUserInstance();

        try {
            objects.offer(fakeUser, 2, TimeUnit.SECONDS);
            logger.info("Producer: I produced " + fakeUser);
        } catch (InterruptedException e) {
            logger.severe(e.getMessage());
        }

    }
}
