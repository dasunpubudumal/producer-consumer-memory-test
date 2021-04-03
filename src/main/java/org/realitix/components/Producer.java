package org.realitix.components;

import org.realitix.models.FakeUser;
import org.realitix.models.FakeUserFactory;
import org.realitix.models.FakerModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Enqueues faker models into the queue
 * @param <T> faker model type
 */
public class Producer<T extends FakerModel> implements Runnable {

    private static final Logger logger = Logger.getLogger(Producer.class.getName());

    private BlockingQueue<T> objects;

    public Producer(BlockingQueue<T> objects) {
        this.objects = objects;
    }

    @Override
    public void run() {

        FakeUser fakeUser = FakeUserFactory.getFakeUserInstance();

        try {
            objects.offer((T) fakeUser, 2, TimeUnit.SECONDS);
            logger.info("Producer: I produced " + fakeUser);
        } catch (InterruptedException e) {
            logger.severe(e.getMessage());
        }

    }
}
