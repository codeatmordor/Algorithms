
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.ArrayList;
import java.util.List;

public class ObjectGeneric {

    public static void solution(List<? extends Object> ob) {

    }

    public static void main(String[] args) {

        List<String> s = new ArrayList<>();
        ObjectGeneric.solution(s);
        System.out.println();
        // System.out.println(ABC.solution(1256987445));
    }
}
