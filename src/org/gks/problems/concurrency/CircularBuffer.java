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
 * File Name:    CircularBuffer.java
 *
 * Date Created: Aug 17, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.concurrency;

/**
 * @author Gaurav_Singh3
 *
 */
public class CircularBuffer {

    private int maxSize;
    private int front = 0;
    private int rear = 0;
    private int len;
    private char[] buf;

    /**
     * @param maxSize
     */
    public CircularBuffer(final int maxSize) {
        super();
        this.maxSize = maxSize;
        front = 0;
        len = 0;
        buf = new char[maxSize];
        rear = 0;
    }

    public boolean isFull() {
        return len == maxSize;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public int getSize() {
        return len;
    }

    public void clear() {
        front = rear = 0;
        len = 0;
        buf = new char[maxSize];

    }

    public void insert(char c) {
        if (!isFull()) {
            len++;
            rear = (rear + 1) % maxSize;
            buf[rear] = c;
        } else
            System.out.println("Underflow Exception");
    }

    public char delete() {
        if (!isEmpty()) {
            len--;
            front = (front + 1) % maxSize;
            return buf[front];
        } else {
            return ' ';
        }
    }

}
