package org.gks.designpatterns.callback;

public abstract class Task {

    public abstract void execute(Callback cb);
    public abstract void stop();
    final void executeWith(Callback cb){
         execute(cb);
    }
}
