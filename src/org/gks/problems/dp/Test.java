

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.dp;


public class Test {

  public static void f(int n) {
    if (n == 0)
      return;
    f(n - 1);
    System.out.println(n);
  }

  public static void main(String[] args) {
    f(3);
  }

}

