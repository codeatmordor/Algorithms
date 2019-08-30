
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.designpatterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        // Insert some sample values.
        list.add("Value1");
        list.add("Value2");
        list.add("Value3");

        // Get two iterators.
        Iterator<String> ite = list.iterator();
        Iterator<String> ite2 = list.iterator();

        // Point to the first object of the list and then, remove it.
        ite.next();
        ite.remove();

        /*
         * The second iterator tries to remove the first object as well. The
         * object does not exist and thus, a ConcurrentModificationException is
         * thrown.
         */
        ite2.next();
        ite2.remove();

    }

}
