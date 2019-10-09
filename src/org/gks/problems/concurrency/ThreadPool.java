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
 * File Name:    ThreadPool.java
 *
 * Date Created: Aug 17, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gaurav_Singh3
 *
 */
public class ThreadPool {

    private BlockingQ tasks = null;
    private final List<PoolThread> ts = new ArrayList<>();
    private boolean isStopped;

    public ThreadPool(final int noofthreads, final int nooftasks) {
        tasks = new BlockingQ(noofthreads);

        for (int i = 0; i < nooftasks; i++) {
            ts.add(new PoolThread(tasks));
        }

    }

    public void invokeAll() {
        for (final PoolThread poolThread : ts) {
            poolThread.start();
        }
    }

    public synchronized void execute(final Runnable task) throws InterruptedException {
        if (this.isStopped) {
            throw new IllegalArgumentException("ThreadPool is stopped");
        }

        if (!isStopped) {
            tasks.enqueue(task);
        }
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (final PoolThread poolThread : ts) {
            poolThread.doStop();
        }
    }

}

class PoolThread extends Thread {

    private BlockingQ q = null;
    boolean isStopped = false;

    public PoolThread(final BlockingQ queue) {
        q = queue;
    }

    @Override
    public void run() {
        while (!isStopped) {
            try {
                final Runnable r = (Runnable) q.dequeue();
                r.run();
            } catch (final Exception e) {

            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }

}
