package org.gks.problems.designpatterns.observer;

public class Driver {
	
	public static void main(String[] args) {		
		ExampleCallBack cb = new ExampleCallBack();
		CronJobService.getInstance();
		CronJobService.init(cb);
	}
}
