

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.chess;


public class Move {

  private Player player;
  private Spot start;
  private Spot end;
  private Piece pieceMoved;
  private Piece pieceKilled;
  private boolean castlingMove = false;

  public Move(Player player, Spot start, Spot end) {
    this.player = player;
    this.start = start;
    this.end = end;
    this.pieceMoved = start.getPiece();
  }

  public boolean isCastlingMove() {
    return this.castlingMove == true;
  }

  public void setCastlingMove(boolean castlingMove) {
    this.castlingMove = castlingMove;
  }

  /**
   * @return the player
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * @param player the player to set
   */
  public void setPlayer(Player player) {
    this.player = player;
  }

  /**
   * @return the start
   */
  public Spot getStart() {
    return start;
  }

  /**
   * @param start the start to set
   */
  public void setStart(Spot start) {
    this.start = start;
  }

  /**
   * @return the end
   */
  public Spot getEnd() {
    return end;
  }

  /**
   * @param end the end to set
   */
  public void setEnd(Spot end) {
    this.end = end;
  }

  /**
   * @return the pieceMoved
   */
  public Piece getPieceMoved() {
    return pieceMoved;
  }

  /**
   * @param pieceMoved the pieceMoved to set
   */
  public void setPieceMoved(Piece pieceMoved) {
    this.pieceMoved = pieceMoved;
  }

  /**
   * @return the pieceKilled
   */
  public Piece getPieceKilled() {
    return pieceKilled;
  }

  /**
   * @param pieceKilled the pieceKilled to set
   */
  public void setPieceKilled(Piece pieceKilled) {
    this.pieceKilled = pieceKilled;
  }

}

