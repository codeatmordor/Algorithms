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
 * File Name:    CyclicBarrier.java
 *
 * Date Created: Aug 17, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Gaurav_Singh3
 *
 */
public class CyclicBar {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(4);
        final Party first = new Party(1000, barrier, "PARTY-1");
        final Party second = new Party(2000, barrier, "PARTY-2");
        final Party third = new Party(3000, barrier, "PARTY-3");
        final Party fourth = new Party(4000, barrier, "PARTY-4");

        first.start();
        second.start();
        third.start();
        fourth.start();

        System.out.println(Thread.currentThread().getName() + " has finished");

    }

}

class Party extends Thread {

    private final int duration;

    /**
     * @param duration
     * @param bar
     */
    public Party(final int duration, final CyclicBarrier bar, final String name) {
        super(name);
        this.duration = duration;
        this.bar = bar;
    }

    private final CyclicBarrier bar;

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " is calling await()");
            bar.await();
            System.out.println(Thread.currentThread().getName() + " has started running again");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
