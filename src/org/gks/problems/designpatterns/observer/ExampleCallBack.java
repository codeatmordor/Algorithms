package org.gks.problems.designpatterns.observer;

public class ExampleCallBack implements CallBack{

	@Override
	public void resolve(String str) {
		System.out.println("In Example Callback, " + str);
		
	}

}
