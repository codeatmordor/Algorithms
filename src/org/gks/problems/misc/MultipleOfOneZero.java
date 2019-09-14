
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.misc;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MultipleOfOneZero {
    public static String multiple(int A) {
        Map<Long, String> map = new HashMap<>();
        for (int i = 1; i <= A; i++) {
            String s = makeStringOfOne(i);
            long ch = checkModulo(s, A);
            System.out.println("Module of " + s + " with " + A + " is " + ch);
            if (ch == 0)
                return s;

            if (map.containsKey(ch)) {
                System.out.println("#Same Modulo " + ch + " Presnt" + map.get(ch));
                return returnResult(map.get(ch), s);
            } else {
                // System.out.println("Ch - " + ch + " Number -" + s);
                map.put(ch, s);
            }
        }
        return "";
    }

    public static String makeStringOfOne(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            s.append("1");
        }
        return s.toString();
    }

    public static long checkModulo(String val, int n) {
        BigInteger t = new BigInteger(val);
        BigInteger va = t.mod(BigInteger.valueOf(n));
        return va.longValue();
    }

    public static String returnResult(String l, String r) {
        if (l.length() < r.length()) {
            String temp = l;
            l = r;
            r = temp;
        }
        StringBuilder s = new StringBuilder();
        for (int i = r.length() - 1; i >= 0; i--) {
            s.append("0");
        }
        s = s.reverse();
        int outerBound = l.length() - r.length();
        l = l.substring(0, outerBound) + s.toString();
        return l;
    }

    public static void main(String[] args) {
        MultipleOfOneZero.multiple(337);
    }
}
