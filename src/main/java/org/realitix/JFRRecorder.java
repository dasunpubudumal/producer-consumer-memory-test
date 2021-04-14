package org.realitix;

import com.microsoft.jfr.*;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class JFRRecorder {

    private static final Logger logger = Logger.getLogger(JFRRecorder.class.getName());

    public static void main(String[] args) {
        MBeanServerConnection mBeanServerConnection = ManagementFactory.getPlatformMBeanServer();
        try {
            FlightRecorderConnection frConnection = FlightRecorderConnection.connect(mBeanServerConnection);
            RecordingOptions recordingOptions = new RecordingOptions.Builder().disk("true").build();
            RecordingConfiguration recordingConfiguration = RecordingConfiguration.PROFILE_CONFIGURATION;

            try (Recording recording = frConnection.newRecording(recordingOptions, recordingConfiguration)) {
                logger.info("Starting JFR process...");
                recording.start();
                TimeUnit.SECONDS.sleep(10);
                recording.stop();

                recording.dump(Paths.get("recording.jfr").toString());
                logger.info("JFR ready..");
            } catch (InterruptedException e) {
                logger.severe(e.getMessage());
            }

        } catch (IOException | InstanceNotFoundException | JfrStreamingException e) {
            logger.severe(e.getMessage());
        }
    }

}
