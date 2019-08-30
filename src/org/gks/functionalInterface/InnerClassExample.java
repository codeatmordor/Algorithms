
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.functionalInterface;

class Outer {

    class Inner {
        void display() {
            System.out.println("Inner");
        }
    }
}

public class InnerClassExample {
    public static void main(String[] args) {
        Outer.Inner c = new Outer().new Inner();
        c.display();
    }
}
