package dotsAndBoxes;

import AllAbstractClasses.Board;
import AllAbstractClasses.Player;

public class BoardDotsAndBoxes extends Board {

	public BoardDotsAndBoxes(int rows, int cols) {
		super((rows + rows - 1), (cols + cols - 1));

	}

	@Override
	public char[][] generateBoard(char[][] boardField, int rows, int cols, int mines) {

		for (int i = 0; i < this.getRows(); i += 2) {
			for (int j = 0; j < this.getCols(); j += 2) {
				boardField[i][j] = '.';
			}
		}

		return boardField;
	}

	@Override
	public void printBoard() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				System.out.print(" ");
				System.out.print(this.getBoardField()[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Override
	public void printClient() {
		System.out.println();
		for (int i = 0; i < getCols(); i++) {
			if (i % 2 == 0 && i / 2 <= 9) {
				System.out.print("   " + (i / 2 + 1));
			} else if (i % 2 == 0 && i / 2 > 9) {
				System.out.print("  " + (i / 2 + 1));

			} else {
				System.out.print("");
			}
		}

		System.out.println();

		for (int i = 0; i < getRows(); i++) {

			if (i % 2 == 0 && i / 2 <= 9) {
				System.out.print((i / 2 + 1) + " ");
			} else if (i % 2 == 0 && i / 2 > 9) {
				System.out.print((i / 2 + 1) + "");
			} else {
				System.out.print("  ");
			}

			for (int j = 0; j < getCols(); j++) {

				System.out.print(" " + this.getBoardField()[i][j]);
			}
			System.out.println();

			// for (int j = 0; j < getCols(); j++) {
			//
			// System.out.print("----");
			// }
			// System.out.println("-");
		}

	}

	@Override
	public void play(Player player) {
		changeField(player);
		printClient();
		this.setGameOver(checkGameOver(player));

	}

	private boolean checkGameOver(Player player) {

		int counterPlayer = 0;
		int counterGame = ((getCols() - 1) * (getRows() - 1)) / 4;

		for (int i = 1; i < getRows(); i += 2) {
			for (int j = 1; j < getCols(); j += 2) {
				if (getBoardField()[i][j] != 'A' && getBoardField()[i][j] != 'B') {
					return false;
				}
			}
		}

		for (int i = 1; i < getRows(); i += 2) {
			for (int j = 1; j < getCols(); j += 2) {
				if (getBoardField()[i][j] == player.getName().charAt(0)) {
					counterPlayer += 1;
				}
			}
		}

		if (counterPlayer > counterGame - counterPlayer) {
			if (player.getName().charAt(0) == 'A') {
				System.out.println("Pleyer YOU WIN!!!  Result " + counterPlayer + " from " + counterGame + "!");
			} else {
				System.out.println(
						"Player LOSE!!!  Result " + (counterGame - counterPlayer) + " from " + counterGame + "!");
			}
		} else if (counterPlayer < counterGame - counterPlayer) {
			if (player.getName().charAt(0) == 'A') {
				System.out.println("Pleyer YOU LOSE!!!  Result " + counterPlayer + " from " + counterGame + "!");
			} else {
				System.out.println(
						"Player YOU  WIN!!!  Result " + (counterGame - counterPlayer) + " from " + counterGame + "!");
			}

		} else {
			System.out.println("GAME OVER! EQUALS !  Player Result " + counterPlayer + " from " + counterGame + "!");
		}

		// TODO Auto-generated method stub
		return true;
	}

	public void changeField(Player player) {

		boolean helperHasleter = false; //
		// what marker to put "|" or "-"
		int helpRows = (player.getGamerRowOne() + player.getGamerRowTwo()) / 2;
		int helpCols = (player.getGamerColOne() + player.getGamerColTwo()) / 2;

		// System.out.println(helpRows + " / " + helpCols);

		if (helpRows % 2 == 0 && helpCols % 2 != 0) {
			this.getBoardField()[helpRows][helpCols] = '_';
		}
		if (helpRows % 2 != 0 && helpCols % 2 == 0) {
			this.getBoardField()[helpRows][helpCols] = '|';
		}

		// put letters

		if (helpRows == 0) {
			if (this.getBoardField()[helpRows + 2][helpCols] == '_'
					&& this.getBoardField()[helpRows + 1][helpCols + 1] == '|'
					&& this.getBoardField()[helpRows + 1][helpCols - 1] == '|') {
				this.getBoardField()[helpRows + 1][helpCols] = player.getName().charAt(0);
				helperHasleter = true;
			}
		}

		else if (helpRows == (getRows() - 1)) {
			if (this.getBoardField()[helpRows - 2][helpCols] == '_'
					&& this.getBoardField()[helpRows - 1][helpCols + 1] == '|'
					&& this.getBoardField()[helpRows - 1][helpCols - 1] == '|') {
				this.getBoardField()[helpRows - 1][helpCols] = player.getName().charAt(0);
				helperHasleter = true;
			}
		}

		if (helpCols == 0) {
			if (this.getBoardField()[helpRows - 1][helpCols + 1] == '_'
					&& this.getBoardField()[helpRows][helpCols + 2] == '|'
					&& this.getBoardField()[helpRows + 1][helpCols + 1] == '_') {
				this.getBoardField()[helpRows][helpCols + 1] = player.getName().charAt(0);
				helperHasleter = true;
			}
		}

		else if (helpCols == (getCols() - 1)) {
			if (this.getBoardField()[helpRows - 1][helpCols - 1] == '_'
					&& this.getBoardField()[helpRows][helpCols - 2] == '|'
					&& this.getBoardField()[helpRows + 1][helpCols - 1] == '_') {
				this.getBoardField()[helpRows][helpCols - 1] = player.getName().charAt(0);
				helperHasleter = true;
			}
		}

		if ((helpRows < getRows() - 1) && helpRows > 0 && helpCols > 0 && helpCols < (getCols() - 1)) {

			if (this.getBoardField()[helpRows][helpCols] == '_') {

				if (this.getBoardField()[helpRows - 2][helpCols] == '_'
						&& this.getBoardField()[helpRows - 1][helpCols + 1] == '|'
						&& this.getBoardField()[helpRows - 1][helpCols - 1] == '|') {
					this.getBoardField()[helpRows - 1][helpCols] = player.getName().charAt(0);
					helperHasleter = true;
				}

				if (this.getBoardField()[helpRows + 2][helpCols] == '_'
						&& this.getBoardField()[helpRows + 1][helpCols + 1] == '|'
						&& this.getBoardField()[helpRows + 1][helpCols - 1] == '|') {
					this.getBoardField()[helpRows + 1][helpCols] = player.getName().charAt(0);
					helperHasleter = true;
				}

			} else if (this.getBoardField()[helpRows][helpCols] == '|') {

				if (this.getBoardField()[helpRows - 1][helpCols - 1] == '_'
						&& this.getBoardField()[helpRows][helpCols - 2] == '|'
						&& this.getBoardField()[helpRows + 1][helpCols - 1] == '_') {
					this.getBoardField()[helpRows][helpCols - 1] = player.getName().charAt(0);
					helperHasleter = true;

				}

			}

			if (this.getBoardField()[helpRows - 1][helpCols + 1] == '_'
					&& this.getBoardField()[helpRows][helpCols + 2] == '|'
					&& this.getBoardField()[helpRows + 1][helpCols + 1] == '_') {
				this.getBoardField()[helpRows][helpCols + 1] = player.getName().charAt(0);
				helperHasleter = true;

			}
			if (helperHasleter) {
				if (!isGameOver()) {
					printClient();
				}
				player.play(player);
				this.play(player);
			}

		}
	}

}
