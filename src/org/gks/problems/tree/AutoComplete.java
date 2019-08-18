/** SYMANTEC: Copyright 2019 Symantec Corporation. All rights reserved.
 * THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION AND TRADE SECRETS OF
 * SYMANTEC CORPORATION.USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED
 * WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF SYMANTEC CORPORATION.
 * The Licensed Software and Documentation are deemed to be commercial
 * computer software as defined in FAR 12.212 and subject to restricted
 * rights as defined in FAR Section 52.227-19 "Commercial Computer Software
 * - Restricted Rights" and DFARS 227.7202, "Rights in Commercial Computer
 * Software or Commercial Computer Software Documentation", as applicable,
 * and any successor regulations.  Any use, modification, reproduction
 * release, performance, display or disclosure of the Licensed Software
 * and Documentation by the U.S. Government shall be solely in accordance
 * with the terms of this Agreement.
 */
/********************************************************************
 * File Name:    AutoComplete.java
 *
 * Date Created: Aug 18, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Gaurav_Singh3
 *
 */
public class AutoComplete {

    class Node {
        private String prefix;
        HashMap<Character, Node> children;
        boolean isWord;

        /**
         * @param prefix
         */
        public Node(String prefix) {
            super();
            this.prefix = prefix;
            this.children = new HashMap<>();
        }

    }

    private Node trie;

    AutoComplete(String[] dict) {
        trie = new Node("");
        for (String string : dict) {
            insertWord(string);
        }
    }

    private void insertWord(String str) {
        Node curr = trie;
        for (int i = 0; i < str.length(); i++) {
            if (!curr.children.containsKey(str.charAt(i))) {
                curr.children.put(str.charAt(i), new Node(str.substring(0, i + 1)));
            }
            curr = curr.children.get(str.charAt(i));
            if (i == str.length() - 1)
                curr.isWord = true;
        }
    }

    public List<String> getWordsForPrefix(String pref) {
        List<String> res = new LinkedList<>();
        Node curr = trie;

        for (char c : pref.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return res;
            }
        }

        findAllWordsForPref(curr, res);
        return res;

    }

    public void findAllWordsForPref(Node n, List<String> res) {
        if (n.isWord)
            res.add(n.prefix);
        for (char c : n.children.keySet()) {
            findAllWordsForPref(n.children.get(c), res);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] dict = new String[] { "abc", "acd", "bcd", "def", "a", "aba" };
        AutoComplete a = new AutoComplete(dict);
        a.getWordsForPrefix("d").stream().forEach(s -> System.out.println(s));
    }

}
