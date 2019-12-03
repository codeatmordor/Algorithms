package org.gks.problems.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ScheduleExecutorTest {

	  public static void main(String[] args) {
		  
		ScheduledExecutorService  _cronExecutor = Executors.newScheduledThreadPool(2);
		
		
		
		Future<?> f = _cronExecutor.scheduleWithFixedDelay(new PeriodicRunnable(), 0, 5, TimeUnit.SECONDS);
		  
		
	/*ScheduledFuture<String> future = _cronExecutor.schedule(new Callable<String>() {
          @Override
          public String call() throws Exception {
              System.out.println("Gaurav Singh");
			return "NewYork";
          }
      }, 0, TimeUnit.SECONDS);*/
	
	  
	  try {
		System.out.println(f.get(1000, TimeUnit.SECONDS));
	} catch (InterruptedException | ExecutionException | TimeoutException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  }
	
}
