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
 * File Name:    BlockingQ.java
 *
 * Date Created: Aug 17, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.concurrency;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Gaurav_Singh3
 * @param <E>
 *
 */
public class BlockingQ<E> {
    private final List q = new LinkedList<E>();
    private int limit = 10;

    public BlockingQ(final int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(final Object e) throws InterruptedException {
        if (q.size() == limit) {
            wait();
        }

        if (q.size() == 0) {
            notifyAll();
        }

        q.add(e);
    }

    public synchronized Object dequeue() throws InterruptedException {
        if (q.size() == 0) {
            wait();
        }
        if (q.size() == limit) {
            notifyAll();
        }

        return q.remove(0);

    }

}
