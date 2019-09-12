
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

import java.util.Stack;

// https://www.geeksforgeeks.org/simplify-directory-path-unix-like/
public class UnixLikeDirectoryPath {

    static String simplify(String path) {

        Stack<String> st = new Stack<>();
        String res = "/";
        int len = path.length();

        for (int i = 0; i < len; i++) {
            String str = "";

            while (i < len && path.charAt(i) == '/')
                i++;

            while (i < len && path.charAt(i) != '/') {
                str += path.charAt(i);
                i++;
            }

            if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (str.equals(".")) {
                continue;
            } else if (str.length() != 0) {
                st.push(str);
            }
        }

        Stack<String> tempStack = new Stack<>();
        while (!st.isEmpty()) {
            tempStack.push(st.pop());
        }

        while (!tempStack.isEmpty()) {
            if (tempStack.size() != 1) {
                res += tempStack.pop() + "/";
            } else {
                res += tempStack.pop();
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String str = new String("/a/./b/../../c/");
        String res = simplify(str);
        System.out.println(res);
    }
}
