package org.gks.problems.stack;

import java.util.Stack;

/* A class that supports all the stack operations and one additional 
operation getMin() that returns the minimum element from stack at 
any time. This class inherits from the stack class and uses an 
auxiliary stack that holds minimum elements */

public class SpecialStack extends Stack<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547459374566248720L;
	Stack<Integer> minSt = new Stack<>();

	void push(int x) {

		if (isEmpty()) {
			super.push(x);
			minSt.push(x);
		} else {
			super.push(x);
			int y = minSt.pop();
			minSt.push(y);
			if( x <= y ) 
	            minSt.push(x); 
		}
	}

	public Integer pop() {
		int x = super.pop();
		int y = minSt.pop();
		
		if ( y != x ) 
	        minSt.push(y); 
		return x;
	}

	/* SpecialStack's member method to get minimum element from it. */
	int getMin() {
		int x = minSt.pop();
		minSt.push(x);
		return x;
	}

	public static void main(String[] args) {
		SpecialStack s = new SpecialStack();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.getMin());
		s.push(5);
		System.out.println(s.getMin());
	}

}
