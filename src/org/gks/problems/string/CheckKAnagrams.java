
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

//https://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/
public class CheckKAnagrams {

    static boolean arekAnagrams(String str1, String str2, int k) {
        int[] char1Count = new int[26];
        int[] char2Count = new int[26];

        if(str1.length()!=str2.length())
            return false;

        for(int i=0;i<str1.length();i++) {
            char
        }

    }

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "grammar";
        int k = 2;
        if (arekAnagrams(str1, str2, k))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
