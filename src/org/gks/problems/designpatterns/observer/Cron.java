package org.gks.problems.designpatters.observer;

public interface Cron extends Runnable{
	
	int getDelayInSeconds();
	
	int getInitDelayInSeconds();

}
