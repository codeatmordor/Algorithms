package org.gks.problems.designpatterns.observer;

public interface Cron extends Runnable{
	
	int getDelayInSeconds();
	
	int getInitDelayInSeconds();

}
