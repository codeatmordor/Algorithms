package org.gks.designpatterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class CommandDesignPattern {

    /*
     * Complete the 'getFirstTwoItemsWithoutPair' function below.
     *
     * The function is expected to return an INTEGER_ARRAY. The function accepts
     * INTEGER_ARRAY list as parameter.
     */

    public static List<Integer> getFirstTwoItemsWithoutPair(List<Integer> list)
    {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Integer> mp = new LinkedHashMap<>();
         for (int i = 0; i < list.size(); i++) {
            if(mp.containsKey(list.get(i))) {
                mp.put(list.get(i), mp.get(list.get(i)) + 1);
            }else {              
                mp.put(list.get(i), 0);
            }
            
        }
        int count =0;
        for(Map.Entry<Integer, Integer> i : mp.entrySet()) {
            System.out.println(i.getKey()+" "+i.getValue());
            if(i.getValue()==1 ) {
                res.add(i.getKey());
                count++;
                if(count>=2)
                {
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        CommandDesignPattern.getFirstTwoItemsWithoutPair();
    }

}
