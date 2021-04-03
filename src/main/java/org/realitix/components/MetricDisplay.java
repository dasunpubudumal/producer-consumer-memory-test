package org.realitix.components;

import java.util.logging.Logger;

public class MetricDisplay implements Runnable {

    private static final Logger logger = Logger.getLogger(MetricDisplay.class.getName());

    @Override
    public void run() {
        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory() / (1024 * 1024);

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.
        // Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory() / (1024 * 1024);

        // Get amount of free memory within the heap in bytes. This size will increase /
        // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory() / (1024 * 1024);

        logger.info(String.format("Maximum heap size: %d MB, Current Heap Size: %d MB, Used Heap Size: %d MB",
                heapMaxSize, heapSize, heapSize - heapFreeSize)
        );
    }
}
