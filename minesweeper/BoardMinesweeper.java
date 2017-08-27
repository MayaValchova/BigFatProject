package minesweeper;

import java.util.Random;
import AllAbstractClasses.*;

public class BoardMinesweeper extends Board {

	private boolean[][] fieldBoolean = new boolean[getRows()][getCols()];
	private int falseChekCount;
	private int mines;

	public BoardMinesweeper(int rows, int cols, int mines) {
		super(rows, cols);
		this.mines = mines;
	}

	@Override
	public void play(Player player) {

		changeBooleanFields(player);
		printClient();

		falseChekCount = falseCheckCount(fieldBoolean, getRows(), getCols());
		System.out.println("Fields Left: " + falseChekCount + ".");
		setGameOver(checkGameOver());

	}

	private boolean checkGameOver() {

		if (falseChekCount == 0) {
			System.out.println("Game Over! You are dead Minesweeper!\n");
			return true;
		} else if (falseChekCount == mines) {
			System.out.println("Congratulations! You WIN!");
			return true;
		} else {

			return false;
		}
	}

	void changeBooleanFields(Player player) {
		if (getBoardField()[player.getGamerRowOne()][player.getGamerColOne()] == '9') {
			for (int i = 0; i < getRows(); i++) {
				for (int j = 0; j < getCols(); j++) {
					fieldBoolean[i][j] = true;
				}
			}
		}

		else if (getBoardField()[player.getGamerRowOne()][player.getGamerColOne()] > '0'
				&& getBoardField()[player.getGamerRowOne()][player.getGamerColOne()] < '9') {
			fieldBoolean[player.getGamerRowOne()][player.getGamerColOne()] = true;
		}

		else {
			fieldBoolean[player.getGamerRowOne()][player.getGamerColOne()] = checkZeroField(player, getBoardField(),
					fieldBoolean, player.getGamerRowOne(), player.getGamerColOne());
		}

	}

	private boolean checkZeroField(Player player, char[][] boardField, boolean[][] fieldBoolean, int r, int c) {
		if (r < 0 || r > getRows() - 1 || c < 0 || c > getCols() - 1) {
			return false;
		} else {
			if (!fieldBoolean[r][c] && (getBoardField()[r][c] > '0' && getBoardField()[r][c] < '9')) {
				fieldBoolean[r][c] = true;
				return fieldBoolean[r][c];
			} else if (!fieldBoolean[r][c] && (getBoardField()[r][c] == '0')) {
				fieldBoolean[r][c] = true;
				checkZeroField(player, getBoardField(), fieldBoolean, r - 1, c);
				checkZeroField(player, getBoardField(), fieldBoolean, r - 1, c + 1);
				checkZeroField(player, getBoardField(), fieldBoolean, r, c + 1);
				checkZeroField(player, getBoardField(), fieldBoolean, r + 1, c + 1);
				checkZeroField(player, getBoardField(), fieldBoolean, r + 1, c);
				checkZeroField(player, getBoardField(), fieldBoolean, r + 1, c - 1);
				checkZeroField(player, getBoardField(), fieldBoolean, r, c - 1);
				checkZeroField(player, getBoardField(), fieldBoolean, r - 1, c - 1);
			}
		}
		return fieldBoolean[r][c];

	}

	private int falseCheckCount(boolean[][] fieldBoolean, int rows, int cols) {
		int number = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!fieldBoolean[i][j]) {
					number++;
				}
			}
		}
		return number;
	}

	private boolean[][] generateFieldBoolean(int rows, int cols) {
		boolean[][] result = new boolean[rows][cols];
		return result;
	}

	@Override
	public char[][] generateBoard(char[][] boardField, int rows, int cols, int mines) {

		Random r = new Random();

		for (int i = 0; i < mines; i++) {
			int row = r.nextInt(rows);
			int col = r.nextInt(cols);
			if (getBoardField()[row][col] != '9') {
				getBoardField()[row][col] = '9';
			} else {
				mines++;
			}
		}

		for (int j = 1; j < cols - 1; j++) {
			int counter = 0;
			if (getBoardField()[0][0] != '9') {
				if (getBoardField()[0][1] == '9') {
					counter++;
				}
				if (getBoardField()[1][0] == '9') {
					counter++;
				}
				if (getBoardField()[1][1] == '9') {
					counter++;
				}
				getBoardField()[0][0] = (char) (48 + counter);
			}
			counter = 0;
			if (getBoardField()[0][cols - 1] != '9') {
				if (getBoardField()[0][cols - 2] == '9') {
					counter++;
				}
				if (getBoardField()[1][cols - 2] == '9') {
					counter++;
				}
				if (getBoardField()[1][cols - 1] == '9') {
					counter++;
				}
				getBoardField()[0][cols - 1] = (char) (48 + counter);
			}
			counter = 0;
			if (getBoardField()[0][j] != '9') {
				if (getBoardField()[0][j - 1] == '9') {
					counter++;
				}
				if (getBoardField()[0][j + 1] == '9') {
					counter++;
				}
				if (getBoardField()[1][j - 1] == '9') {
					counter++;
				}
				if (getBoardField()[1][j] == '9') {
					counter++;
				}
				if (getBoardField()[1][j + 1] == '9') {
					counter++;
				}
				getBoardField()[0][j] = (char) (48 + counter);
			}

			counter = 0;
			if (getBoardField()[rows - 1][0] != '9') {
				if (getBoardField()[rows - 1][1] == '9') {
					counter++;
				}
				if (getBoardField()[rows - 2][0] == '9') {
					counter++;
				}
				if (getBoardField()[rows - 2][1] == '9') {
					counter++;
				}
				getBoardField()[rows - 1][0] = (char) (48 + counter);
			}
			counter = 0;
			if (getBoardField()[rows - 1][cols - 1] != '9') {
				if (getBoardField()[rows - 1][cols - 2] == '9') {
					counter++;
				}
				if (getBoardField()[rows - 2][cols - 2] == '9') {
					counter++;
				}
				if (getBoardField()[rows - 2][cols - 1] == '9') {
					counter++;
				}
				getBoardField()[rows - 1][cols - 1] = (char) (48 + counter);
			}
			counter = 0;
			if (getBoardField()[rows - 1][j] != '9') {
				if (getBoardField()[rows - 1][j - 1] == '9') {
					counter++;
				}
				if (getBoardField()[rows - 1][j + 1] == '9') {
					counter++;
				}
				if (getBoardField()[rows - 2][j - 1] == '9') {
					counter++;
				}
				if (getBoardField()[rows - 2][j] == '9') {
					counter++;
				}
				if (getBoardField()[rows - 2][j + 1] == '9') {
					counter++;
				}
				getBoardField()[rows - 1][j] = (char) (48 + counter);
			}
		}

		for (int i = 1; i < rows - 1; i++) {
			int counter = 0;
			if (getBoardField()[i][0] != '9') {
				if (getBoardField()[i - 1][0] == '9') {
					counter++;
				}
				if (getBoardField()[i + 1][0] == '9') {
					counter++;
				}

				if (getBoardField()[i - 1][1] == '9') {
					counter++;
				}
				if (getBoardField()[i][1] == '9') {
					counter++;
				}
				if (getBoardField()[i + 1][1] == '9') {
					counter++;
				}
				getBoardField()[i][0] = (char) (48 + counter);
			}
			counter = 0;
			if (getBoardField()[i][cols - 1] != '9') {

				if (getBoardField()[i - 1][cols - 1] == '9') {
					counter++;
				}
				if (getBoardField()[i + 1][cols - 1] == '9') {
					counter++;
				}
				if (getBoardField()[i][cols - 2] == '9') {
					counter++;
				}
				if (getBoardField()[i - 1][cols - 2] == '9') {
					counter++;
				}
				if (getBoardField()[i + 1][cols - 2] == '9') {
					counter++;
				}
				getBoardField()[i][cols - 1] = (char) (48 + counter);
			}
		}

		for (int i = 1; i < rows - 1; i++) {
			for (int j = 1; j < cols - 1; j++) {
				int counter = 0;
				if (getBoardField()[i][j] != '9') {
					if (getBoardField()[i - 1][j] == '9') {
						counter++;
					}
					if (getBoardField()[i - 1][j + 1] == '9') {
						counter++;
					}
					if (getBoardField()[i][j + 1] == '9') {
						counter++;
					}
					if (getBoardField()[i + 1][j + 1] == '9') {
						counter++;
					}
					if (getBoardField()[i + 1][j] == '9') {
						counter++;
					}
					if (getBoardField()[i + 1][j - 1] == '9') {
						counter++;
					}
					if (getBoardField()[i][j - 1] == '9') {
						counter++;
					}
					if (getBoardField()[i - 1][j - 1] == '9') {
						counter++;
					}

					getBoardField()[i][j] = (char) (48 + counter);
				}
			}
		}
		return boardField;

	}

	@Override
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

				if (fieldBoolean[i][j] && getBoardField()[i][j] == '9') {
					System.out.print(" * |");
				}

				else if (!fieldBoolean[i][j] && getBoardField()[i][j] == '9' && mines == falseChekCount) {
					System.out.print(" $ |");
				}

				else if (fieldBoolean[i][j] && getBoardField()[i][j] == '0') {
					System.out.print(" 0 |");
				}

				else if (fieldBoolean[i][j] && (getBoardField()[i][j] > 0 && getBoardField()[i][j] < '9')) {
					System.out.print(" " + getBoardField()[i][j] + " |");
				}

				else {
					System.out.print("   |");
				}

			}
			System.out.println();
			System.out.print("  ");
			for (int j = 0; j < getCols(); j++) {

				System.out.print("----");
			}
			System.out.println("-");

		}
	}

	@Override
	public void printBoard() {

		// System.out.println();
		//
		// System.out.println();
		// for (int i = 0; i < getCols(); i++) {
		// if (i <= 9) {
		// System.out.print(" " + (i + 1));
		// } else {
		// System.out.print(" " + (i + 1));
		// }
		// }
		// System.out.println();
		// System.out.print(" -");
		// for (int i = 0; i < getCols(); i++) {
		// System.out.print("----");
		// }
		// System.out.println();
		//
		// for (int i = 0; i < getRows(); i++) {
		// if (i < 9) {
		// System.out.print((i + 1) + " |");
		// } else {
		// System.out.print((i + 1) + "|");
		// }
		//
		// for (int j = 0; j < getCols(); j++) {
		//
		// System.out.print(" " + this.getBoardField()[i][j] + " |");
		// }
		// System.out.println();
		// System.out.print(" ");
		// for (int j = 0; j < getCols(); j++) {
		//
		// System.out.print("----");
		// }
		// System.out.println("-");
		// }
		//
	}

}
