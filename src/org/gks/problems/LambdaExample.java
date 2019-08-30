
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

interface PerformOperation {
    int execute(int num);
}

class MyMaths {
    public int execute(PerformOperation op, int num) {
        return op.execute(num);
    }

    public static PerformOperation isOdd() {
        return (int a)->a%2!=0;
    }

    public static PerformOperation
}

public class LambdaExample {

}
