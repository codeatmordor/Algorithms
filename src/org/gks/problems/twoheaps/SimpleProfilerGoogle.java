// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.twoheaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class FuncNode {
  public String time;
  public String methodName;
  public String state;

  public FuncNode(String time, String name, String state) {

    this.time = time;
    this.methodName = name;
    this.state = state;

  }
}


public class SimpleProfilerGoogle {

  public static void main(String[] args) {
    Stack<FuncNode> st = new Stack<>();
    List<String> inputLines = new ArrayList<>();
    List<String> res = new ArrayList<>();//
    inputLines.add("t1 main enter");
    inputLines.add("t2 foo enter");
    inputLines.add("t3 foo enter");
    inputLines.add("t4 foo exit");
    inputLines.add("t5 foo exit");
    inputLines.add("t6 main exit");
    for (int i = 0; i < inputLines.size(); i++) {
      String[] tokens = inputLines.get(i).split(" ");
      // System.out.println(tokens[0]+ tokens[1]+ tokens[2]);
      if ("enter".equals(tokens[2])) {
        st.push(new FuncNode(tokens[0], tokens[1], tokens[2]));
      } else if (tokens[1].equals(st.peek().methodName)) {
        FuncNode n = st.pop();
        res.add(n.methodName + " " + tokens[0] + "-" + n.time);
      }
    }
    for (String string : res) {
      System.out.println(string);
    }


  }
}
