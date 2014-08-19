package com.sunset.framework;

public class HardWait {

    private static final long VERY_VERY_SHORT_SLEEP = 200;
    private static final long VERY_SHORT_SLEEP = 1000;
    private static final long SHORT_SLEEP = 2000;
    private static final long MID_SLEEP = 5000;
    private static final long LONG_SLEEP = 7000;
    private static final long VERY_LONG_SLEEP = 10000;

    // hard code sleep
    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public static void veryVeryShortSleep() {
        sleep(VERY_VERY_SHORT_SLEEP);
    }

    public static void veryShortSleep() {
        sleep(VERY_SHORT_SLEEP);
    }

    public static void shortSleep() {
        sleep(SHORT_SLEEP);
    }

    public static void midSleep() {
        sleep(MID_SLEEP);
    }

    public static void longSleep() {
        sleep(LONG_SLEEP);
    }

    public static void veryLongSleep() {
        sleep(VERY_LONG_SLEEP);
    }
}

