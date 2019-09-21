

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.chess;


public class Bishop extends Piece {

  public Bishop(boolean white) {
    super(white);
    // TODO Auto-generated constructor stub
  }

  @Override
  public boolean canMove(Board board, Spot start, Spot end) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  protected boolean isCastlingMove() {
    // TODO Auto-generated method stub
    return false;
  }



}

