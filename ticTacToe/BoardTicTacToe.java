package ticTacToe;

import AllAbstractClasses.*;

public class BoardTicTacToe extends Board {

	public BoardTicTacToe(int rows, int cols) {
		super(rows, cols);

	}

	public void printClient() {
		System.out.println();
		for (int i = 0; i < getCols(); i++) {
			if (i <= 9) {
				System.out.print("   " + (i + 1));
			} else {
				System.out.print("  " + (i + 1));
			}
		}
		System.out.println();
		System.out.print("  -");
		for (int i = 0; i < getCols(); i++) {
			System.out.print("----");
		}
		System.out.println();

		for (int i = 0; i < getRows(); i++) {
			if (i < 9) {
				System.out.print((i + 1) + " |");
			} else {
				System.out.print((i + 1) + "|");
			}

			for (int j = 0; j < getCols(); j++) {

				System.out.print(" " + this.getBoardField()[i][j] + " |");
			}
			System.out.println();
			System.out.print("  ");
			for (int j = 0; j < getCols(); j++) {

				System.out.print("----");
			}
			System.out.println("-");
		}
	}

	public void printBoard() {

		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				System.out.print(this.getBoardField()[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Override
	public char[][] generateBoard(char[][] boardField, int rows, int cols, int mines) {

		printClient();
		return boardField;
	}

	@Override
	public void play(Player player) {
		changeField(player);

		// checkGameOver();

		printClient();

	}

	public void changeField(Player player) {

		this.getBoardField()[player.getGamerRowOne()][player.getGamerColOne()] = player.getName().charAt(0);

	}

	// boolean checkGameOver() {

	// }

	// printira poleto chisto, bez linii za red i kolona

	// public char[][] getBoardField() {
	// return boardField;
	// }
	//
	// public void setBoardField(char[][] board) {
	// this.boardField = board;
	// }

}
