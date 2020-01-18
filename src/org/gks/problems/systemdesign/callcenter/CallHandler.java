package org.gks.problems.systemdesign.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CallHandler {
	static final int LEVELS = 3;
	static final int NUM_FRESHERS = 5; // assume we have 5 freshers
	Map<Integer, List<Employee>> employees;
	Map<Integer, Queue<Call>> callQueues;// enqueue waiting calls

	public CallHandler(int NUM_FRESHERS) {
		employees.put(0, new ArrayList<>());
		employees.put(1, new ArrayList<>());
		employees.put(2, new ArrayList<>());
		callQueues.put(0, new LinkedList<>());
		callQueues.put(1, new LinkedList<>());
		callQueues.put(2, new LinkedList<>());
	}

	// return the first available person equal or higher than
	// current call rank
	Employee getCallHandler(Call call) {
		for (int level = call.rank; level < LEVELS - 1; level++) {
			List<Employee> employeeLevel = employees.get(level);
			for (Employee emp : employeeLevel) {
				if (emp.free)
					return emp;
			}
		}
		return null;
	}

	void dispatchCall(Call call) {
		// try to route the call to an employee with minimal rank
		Employee emp = getCallHandler(call);
		if (emp != null)
			emp.receiveCall(call);
		// if no one is available for the call, put the call on the queue
		// waiting for the next available employee
		else
			callQueues.get(call.rank).add(call);
	}

	// look for call at e's rank
	void getNextCall(Employee e) {
		if (callQueues.get(e.rank).size() != 0) {
			Call next = callQueues.get(e.rank).poll();
			e.receiveCall(next);
		}
	}

}
