package org.realitix;

import org.realitix.components.Consumer;
import org.realitix.components.MetricDisplay;
import org.realitix.components.Producer;
import org.realitix.constants.Constants;
import org.realitix.models.FakeUser;

import java.util.concurrent.*;

/**
 * Producer-Consumer memory consumption test
 */
public class App 
{
    public static void main(String[] args) {

        // Try a blocking queue without size
        final BlockingQueue<FakeUser> blockingQueue = new LinkedBlockingQueue<>();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Constants.THREAD_POOL_SIZE);

        executorService.scheduleAtFixedRate(
                new Producer<>(blockingQueue),
                Constants.PRODUCER_DELAY,
                Constants.PRODUCER_PERIOD ,
                TimeUnit.SECONDS
        );
        executorService.scheduleAtFixedRate(
                new Consumer<>(blockingQueue),
                Constants.CONSUMER_DELAY,
                Constants.CONSUMER_PERIOD,
                TimeUnit.SECONDS
        );
        executorService.scheduleAtFixedRate(
                new MetricDisplay<>(blockingQueue),
                Constants.METRIC_DELAY,
                Constants.METRIC_PERIOD,
                TimeUnit.SECONDS
        );
    }
}
