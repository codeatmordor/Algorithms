package org.gks.problems.systemdesign.callcenter;

/*
 * Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM).There can be multiple employees, but only one TL or PM.An incoming telephone call must be allocated to a fresher who is free.If a fresher can’t handle the call, he or she must escalate the call to technical lead.If the TL is not free or not able to handle it, then the call should be escalated to PM.Design the classes and data structures for this problem.Implement a method getCallHandler() 
 */

public class Employee {

	CallHandler callHandler;
	int rank; // 0 - Fresher, 1- TL, 2-PM
	boolean free;

	Employee(int r) {
		rank = r;
	}

	void receiveCall(Call c) {
	}

	void callHandled(Call c, String m) {
		c.reply(m);
		c.disconnect();
		callHandler.getNextCall(this);
	}

	// If the employee with the current rank cannot handle the call
	void cannotHandle(Call call) {
		// escalate the call to a higher rank
		call.rank = rank + 1;
		callHandler.dispatchCall(call);
		free = true;
		callHandler.getNextCall(this);
	}

}

class Fresher extends Employee {
	public Fresher() {
		super(0);
	}
}

class TechLead extends Employee {
	public TechLead() {
		super(1);
	}
}

class ProductManager extends Employee {
	public ProductManager() {
		super(2);
	}
}
