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
 * File Name:    GraphBFSDFS.java
 *
 * Date Created: Jul 12, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Gaurav_Singh3
 *
 */
public class GraphBFSDFS {
    private final HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {
        int id;
        LinkedList<Node> adjacent = new LinkedList<>();

        private Node(final int id) {
            this.id = id;
        }

        private Node getNode(final int id) {
            return this;
        }

        public void addEdge(final int source, final int destination) {
            final Node s = getNode(source);
            final Node d = getNode(destination);
            s.adjacent.add(d);
        }

        public boolean hasPathDFS(final int source, final int dest) {
            final Node s = getNode(source);
            final Node d = getNode(dest);
            final HashSet<Integer> visited = new HashSet<>();
            return hasPathDFS(s, d, visited);
        }

        private boolean hasPathDFS(final Node source, final Node dest, final HashSet<Integer> visited) {
            if (visited.contains(source.id))
                return false;
            visited.add(source.id);
            if (source == dest)
                return true;
            for (final Node n : source.adjacent) {
                if (hasPathDFS(n, dest, visited)) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasPathBFS(final Node source, final Node dest) {
            final LinkedList<Node> nextToVisit = new LinkedList<>();
            final HashSet<Integer> visited = new HashSet<>();
            nextToVisit.add(source);
            while (!nextToVisit.isEmpty()) {
                final Node n = nextToVisit.remove();
                if (n == dest)
                    return true;
                if (visited.contains(n.id))
                    continue;
                visited.add(n.id);
                nextToVisit.addAll(n.adjacent);
            }
            return false;
        }
    }
}
