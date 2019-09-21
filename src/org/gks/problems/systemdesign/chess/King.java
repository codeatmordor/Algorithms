

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.chess;


public class King extends Piece {

  private boolean castlingDone = false;

  public King(boolean white) {
    super(white);
  }

  public boolean isCastlingDone() {
    return this.castlingDone == true;
  }

  public void setCastlingDone(boolean castlingDone) {
    this.castlingDone = castlingDone;
  }

  @Override
  public boolean canMove(Board board, Spot start, Spot end) {
    // we can't move the piece to a Spot that
    // has a piece of the same color
    if (end.getPiece().isWhite() == this.isWhite()) {
      return false;
    }

    int x = Math.abs(start.getX() - end.getX());
    int y = Math.abs(start.getY() - end.getY());
    if (x + y == 1) {
      // check if this move will not result in the king
      // being attacked if so return true
      return true;
    }

    return this.isValidCastling(board, start, end);
  }

  private boolean isValidCastling(Board board, Spot start, Spot end) {

    if (this.isCastlingDone()) {
      return false;
    }
    return castlingDone;

    // Logic for returning true or false
  }



  @Override
  protected boolean isCastlingMove() {
    // TODO Auto-generated method stub
    return false;
  }

}

