package org.gks.designpatterns.callback;


import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GetConfigTask extends Task {

    private final ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
    private ScheduledFuture<?> scheduledFuture;
    private final Integer initialDelay = 10;
    private final Integer interval = 15;

    @Override
    public void execute(Callback cb) {
        Runnable fetchData = () -> {
            // Invoke endpoint and fetch config values, update global config object or write to a file
            System.out.println(new Date(System.currentTimeMillis()).toString() + " : Fetched Config");
            GlobalConfig.getInstance().setConfig("a", "b");
            Optional.ofNullable(cb).ifPresent(Callback::call);
        };
        scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(fetchData, initialDelay, interval, TimeUnit.SECONDS);
    }

    @Override
    public void stop() {
        System.out.println("Stop Now.");
        scheduledFuture.cancel(true);
        scheduledExecutorService.shutdown();
    }
}
