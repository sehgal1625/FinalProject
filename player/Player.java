package player;

import pieces.*;
import board.*;
import java.util.*;

public abstract class Player {

	protected Board board;
	protected King playerKing;
	protected ArrayList<Move> legalMoves;
	
	public Player(Board board, ArrayList<Move> allowedMoves, ArrayList<Move> enemyMoves) {
		this.board = board;
		this.playerKing = createKing();
		this.legalMoves = legalMoves;
	}

	//Makes sure the king is still alive
	private King createKing() {
		for(Piece piece: getAlivePieces()) {
			if(piece.getPieceType().isKing()) {
				return (King) piece;
			}
		}
		throw new RuntimeException("Should not reach here because board doesn't exist anymore");
	}

	public abstract ArrayList<Piece> getAlivePieces();
}
