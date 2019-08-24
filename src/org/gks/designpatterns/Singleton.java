
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.designpatterns;

public class Singleton {

    private volatile static Singleton obj;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (obj == null) {
            // To make thread safe
            synchronized (Singleton.class) {
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    obj = new Singleton();
            }
        }
        return obj;
    }

}

// Java code for Bill Pugh Singleton Implementaion
class GFG {

    private GFG() {
        // private constructor
    }

    // Inner class to provide instance of class
    private static class BillPughSingleton {
        private static final GFG INSTANCE = new GFG();
    }

    public static GFG getInstance() {
        return BillPughSingleton.INSTANCE;
    }
}
