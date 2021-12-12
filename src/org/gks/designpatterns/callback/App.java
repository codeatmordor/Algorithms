package org.gks.designpatterns.callback;

public class App {

    public static void main(String[] args)  {
        Task task = new GetConfigTask();
        task.executeWith(()-> {
            // Do some more tasks
            System.out.println("Config Update is Done.");
        });

        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown SimpleTask during graceful shutdown of application.
        task.stop();
    }
}
