package org.gks.problems.designpatters.observer;

public class ExampleCallBack implements CallBack{

	@Override
	public void resolve(String str) {
		System.out.println("In Example Callback, " + str);
		
	}

}
