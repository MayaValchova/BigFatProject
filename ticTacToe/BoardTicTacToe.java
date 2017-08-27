package ticTacToe;

import org.omg.Messaging.SyncScopeHelper;

import AllAbstractClasses.*;
import sun.net.www.content.text.plain;

public class BoardTicTacToe extends Board {
	
	private static int turn = 0;
	private boolean horizontal = false;
	private boolean vertical = false;
	private boolean diagonalOne = false;
	private boolean diagonalTwo = false;

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

		return boardField;
	}

	@Override
	public void play(Player player) {
		
		changeField(player);
		printClient();
		this.setGameOver(checkGameOver(player));
		turnsCounter();
	
	}

	private static void turnsCounter() {
		setTurn(1);
	}
	
	public void changeField(Player player) {
		
			this.getBoardField()[player.getGamerRowOne()][player.getGamerColOne()] = player.getName().charAt(0);
	}

	public boolean checkGameOver(Player player) {
		boolean isBoardFull = true;
		int row = player.getGamerRowOne();
		int col = player.getGamerColOne();
		int countToThree = 1;
		char winner = player.getName().charAt(0);
		
		//horizontal
		for (int i = 0; i < this.getBoardField()[player.getGamerRowOne()].length-1; i++) {
			if(this.getBoardField()[player.getGamerRowOne()][i] == this.getBoardField()[player.getGamerRowOne()][i+1] && this.getBoardField()[player.getGamerRowOne()][i] != 0) {
				countToThree++;
				if(countToThree == 3) {
					setHorizontal(true);
					break;
				}
			} else {
				countToThree = 1;
			}
		}
		 //vertical
		if(!horizontal) {
			countToThree = 1;
			for (int i = 0; i < this.getBoardField().length-1; i++) {
				if(this.getBoardField()[i][player.getGamerColOne()] == this.getBoardField()[i+1][player.getGamerColOne()] && this.getBoardField()[i][player.getGamerColOne()] != 0) {
					countToThree++;
					if(countToThree == 3) {
						setVertical(true);
						break;
					}
				} else {
					countToThree = 1;
				}
			}
		}
		//Diagonal One
		if(!(isHorizontal() && isVertical())) {
			//If the selection is not on the border
			if(player.getGamerRowOne() != 0 && player.getGamerRowOne() != getRows()-1 && player.getGamerColOne() != 0 && player.getGamerColOne() != getCols()-1) {
				diagonalOneIfNotOnBorder(player.getGamerRowOne(), player.getGamerColOne());
			}
			if(!isDiagonalOne()) {
				diagonalOne(row, col, winner, 2);
				diagonalOneBack(player.getGamerRowOne(), player.getGamerColOne(), winner, 2);
			}
		}
		//Diagonal Two
		if(!(isHorizontal() && isVertical() && isDiagonalOne())) {
			if(player.getGamerRowOne() != 0 && player.getGamerRowOne() != getRows()-1 && player.getGamerColOne() != 0 && player.getGamerColOne() != getCols()-1) {
				diagonalTwoIfNotOnBorder(player.getGamerRowOne(), player.getGamerColOne());
			}
			if(!isDiagonalTwo()) {
				diagonalTwo(row, col, winner, 2);
				diagonalTwoBack(player.getGamerRowOne(), player.getGamerColOne(), winner, 2);
			}
		}
		if(!(isDiagonalOne() || isDiagonalTwo() || isHorizontal() || isVertical())) {
			for (int i = 0; i < getBoardField().length; i++) {
				for(int j = 0; j < getBoardField()[i].length; j++) {
					if(getBoardField()[i][j] == 0) {
						isBoardFull = false;
						break;
					}
				}
			}
		}
		if(isDiagonalOne() || isDiagonalTwo() || isHorizontal() || isVertical()) {
			checkWhoWins(winner);
			return true;
			} 
		if(isBoardFull) {
			System.out.println("It's a draw!");
			System.out.println("No more empty spaces!");
			System.out.println("Better luck next time!");
			return true;
		}
		else {
				return false;
			}
		}
	//Recursively checking in diagonal one has 3 of the same 2 squares in a row for Diagonal One
	private void diagonalOne(int row, int col, char winner, int count) {
		if(row < 0 || row > getBoardField().length - 1 || col < 0 || col > getBoardField()[0].length - 1 
				|| getBoardField()[row][col] != winner) {
			return;
			}
		if(count == 0) {
			setDiagonalOne(true);
			} 
		if (getBoardField()[row][col] == winner) {
			diagonalOne(row+1, col+1, winner, count-1);
			}
		return;
	}
	//Recursively checking in diagonal one has 3 of the same 2 squares in a row for Diagonal One
	private void diagonalTwo(int row, int col, char winner, int count) {
		if(row < 0 || row > getBoardField().length - 1 || col < 0 || col > getBoardField()[0].length - 1 
				|| getBoardField()[row][col] != winner) {
			return;
			}
		if(count == 0) {
			setDiagonalTwo(true);
			} 
		if (getBoardField()[row][col] == winner) {
			diagonalTwo(row+1, col-1, winner, count-1);
			}
		return;
	}
	//Checking the previous and next square for when the selection is not on the border
	private void diagonalOneIfNotOnBorder(int row, int col) {
		if(getBoardField()[row][col] == getBoardField()[row-1][col-1] && getBoardField()[row][col] == getBoardField()[row+1][col+1]) {
			setDiagonalOne(true);
		}
	}
	//Recursively checking Diagonal One two squares back
	private void diagonalOneBack(int row, int col, char winner, int count) {
			if(row < 0 || row > getBoardField().length - 1 || col < 0 || col > getBoardField()[0].length - 1 
					|| getBoardField()[row][col] != winner) {
				return;
				}
			if(count == 0) {
				setDiagonalOne(true);
				} 
			if (getBoardField()[row][col] == winner) {
				diagonalOneBack(row-1, col-1, winner, count-1);
				}
			return;
	}
	//Checking the previous and next square for when the selection is not on the border
	private void diagonalTwoIfNotOnBorder(int row, int col) {
		if(getBoardField()[row][col] == getBoardField()[row-1][col+1] && getBoardField()[row][col] == getBoardField()[row+1][col-1]) {
			setDiagonalTwo(true);
		}
	}
	//Recursively checking Diagonal Two two squares back
	private void diagonalTwoBack(int row, int col, char winner, int count) {
			if(row < 0 || row > getBoardField().length - 1 || col < 0 || col > getBoardField()[0].length - 1 
					|| getBoardField()[row][col] != winner) {
				return;
				}
			if(count == 0) {
				setDiagonalTwo(true);
			} 
			if (getBoardField()[row][col] == winner) {
				diagonalTwoBack(row-1, col+1, winner, count-1);
				}
			return;
		}
	
	private void checkWhoWins(char c) {
		 if(c == 'G') {
			 System.out.println("Congratulations!");
			 System.out.println("You Won in " + getTurn() + " turns!");
			 System.out.println();
		 } else if(c != 0 && c != 'G'){
			 System.out.println("You Lose!");
			 System.out.println("Computer Wins!");
			 System.out.println("Turn number " + getTurn());
			 System.out.println();
		 }
	 }

	private boolean isHorizontal() {
		return horizontal;
	}
	private void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	private boolean isVertical() {
		return vertical;
	}
	private void setVertical(boolean vertical) {
		this.vertical = vertical;
	}
	private boolean isDiagonalOne() {
		return diagonalOne;
	}
	private void setDiagonalOne(boolean diagonalOne) {
		this.diagonalOne = diagonalOne;
	}
	private boolean isDiagonalTwo() {
		return diagonalTwo;
	}
	private void setDiagonalTwo(boolean diagonalTwo) {
		this.diagonalTwo = diagonalTwo;
	}

	private static int getTurn() {
		return turn;
	}

	private static void setTurn(int turn) {
		BoardTicTacToe.turn += turn;
	}
	
}
