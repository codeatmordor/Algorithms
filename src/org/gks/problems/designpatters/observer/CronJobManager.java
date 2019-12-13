package org.gks.problems.designpatters.observer;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CronJobManager {
	
	private ArrayList<Future<?>> crons = null;
	private static final CronJobManager INSTANCE = new CronJobManager();
	private ScheduledExecutorService cronExecutor = null;
	
	
	private CronJobManager() {
		
	}
	
	public static CronJobManager getInstance() { return INSTANCE;}
	
	
	public synchronized void start(CallBack cb) {
		if(this.crons == null) {
			this.crons = new ArrayList<Future<?>>();
			this.cronExecutor = Executors.newScheduledThreadPool(2);
		}
		this.schedule(new PeriodicCron(cb));
		
	}
		
	public void shutdown() {
		if(this.cronExecutor!=null) {
			this.cronExecutor.shutdown();
			
			try {
				if(!this.cronExecutor.awaitTermination(1L, TimeUnit.SECONDS)) {
					this.cronExecutor.shutdownNow();
				}
			}catch(InterruptedException e) {
				this.cronExecutor.shutdownNow();
			}
		}
	}
	
	public synchronized void schedule(Cron cron) {
		Future<?> f = this.cronExecutor.scheduleWithFixedDelay(cron, cron.getInitDelayInSeconds(),cron.getDelayInSeconds(), TimeUnit.SECONDS);
		this.crons.add(f);
	}

}
