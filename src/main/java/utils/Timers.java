package utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

public class Timers {
    private static final Map<String, Long> timestamps = new HashMap<>();

    public static void setTimestamp(final String timestampName){
        timestamps.put(timestampName, getCurrentTime());
    }

    public static long getDurationInMillisFrom(final String timestampName){
        return getCurrentTime() - Optional.ofNullable(timestamps.get(timestampName))
                .orElseThrow(() -> new RuntimeException(
                                format("timestamp %s does not exist", timestampName)
                        )
                );
    }

    private static long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }
}