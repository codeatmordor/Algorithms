package org.gks.problems.designpatterns.observer;

import java.time.LocalDateTime;

public class PeriodicCron implements Cron{
	
	private CallBack cb;
	
	public  PeriodicCron(CallBack cb) {
		this.cb =cb;
	}

	@Override
	public void run() {
		System.out.println(LocalDateTime.now().toString());
		System.out.println("In PeriodicCron.");
		cb.resolve("from PriodicCron");
	}

	@Override
	public int getDelayInSeconds() {
		
		return 10;
	}

	@Override
	public int getInitDelayInSeconds() {
		
		return 0;
	}

}
