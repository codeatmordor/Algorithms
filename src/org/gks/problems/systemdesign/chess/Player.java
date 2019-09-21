

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.chess;


public abstract class Player {

  public boolean whiteSide;
  public boolean humanPlayer;

  public boolean isWhiteSide() {
    return this.whiteSide == true;
  }

  public boolean isHumanPlayer() {
    return this.humanPlayer == true;
  }

}

