package org.gks.problems.designpatters.observer;

public class Driver {
	
	public static void main(String[] args) {
		
		ExampleCallBack cb = new ExampleCallBack();
		CronJobService.getInstance().init(cb);
	}

}
