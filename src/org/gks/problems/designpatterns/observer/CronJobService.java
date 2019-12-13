package org.gks.problems.designpatters.observer;

public class CronJobService {
	
	 private CronJobService() {
	    }

	    public static final CronJobService getInstance() {
	        return CronJobService.LazyHolder.instance;
	    }
	    
	    private static class LazyHolder {
	        private static final CronJobService instance = new CronJobService();
	        private LazyHolder() {
	        }
	    }
	    
	    public static void init(CallBack cb) {
	    	CronJobManager.getInstance().start(cb);
	    }
	    
	    public static void shutdown()
	    {
	    	CronJobManager.getInstance().shutdown();
	    }

}
