import java.util.ArrayList;
import java.util.List;

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
 * File Name:    LinkList.java
 *
 * Date Created: Aug 18, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------

/**
 * @author Gaurav_Singh3
 *
 */
public class LinkList {

    private class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node start;
    private int length;

    /**
     * @param start
     * @param length
     */
    public LinkList(String value) {
        super();
        this.start = new Node(value);
        start.next = null;
        this.length = 1;
    }

    public void add(String value) {
        Node curr = start;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node n = new Node(value);
        n.next = null;
        curr.next = n;
        length++;
    }

    public String getNthToLastNode(int n) {
        if (n > length)
            throw new IllegalArgumentException();
        int frombegin = (length - n) + 1;
        int count = 1;
        Node curr = start;
        while (count < frombegin) {
            curr = curr.next;
            count++;
        }
        return curr.value;
    }

    public List<Node> split() {
        Node list = this.start;
        // runner will be the fast moving pointer
        Node runner = list.next;
        List<Node> toReturn = new ArrayList<>();

        while (runner != null) {
            runner = runner.next;
            if (runner == null)
                break;
            runner = runner.next;
            list = list.next;
        }
        toReturn.add(list.next);
        list.next = null;
        toReturn.add(this.start);
        return toReturn;
    }
}
