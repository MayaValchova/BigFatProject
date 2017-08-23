package demo;

import java.util.Scanner;

import AllAbstractClasses.*;
import ticTacToe.*;
import dotsAndBoxes.*;
import mineSweeper.*;

public class Demo {

	public static void main(String[] args) {
		
		char chosenGame = '0';

		do {
			chosenGame = choseGame(); // izbor na igrata
			int minCount = 3;
			int maxCount = 20;
			int rowsCount = 0;
			int colsCount = 0;
			int minesCount = 0;
			
			if(chosenGame == 'q' || chosenGame == 'Q') {
				System.out.println("Good Bye!");
				return;
			}


			if (chosenGame != '3') {
				rowsCount = choseRowsCount(minCount, maxCount); // izbor broi redove
				colsCount = choseColsCount(minCount, maxCount); // izbor broi koloni
			}

			if (chosenGame == '3') {
				int level = choseMinesweeperLevel();
				rowsCount = choseRowsCount(level);
				colsCount = choseColsCount(level);
				minesCount = choseMinesCount(level);
			}

			
			Board board = null;
			Player gamerOne = null;
			Player gamerTwo = null;
			
			if(chosenGame == 'q' || chosenGame == 'Q') {
				return;
			}

			if (chosenGame == '1') {

				BoardTicTacToe boardTicTacToe = new BoardTicTacToe(rowsCount, colsCount);
				PlayerPerson gosho = new PlayerPerson("Gosho");
				PlayerPC gamerPC = new PlayerPC("CPU");

				board = boardTicTacToe;
				gamerOne = gosho;
				gamerTwo = gamerPC;

			} else if (chosenGame == '2') {
				BoardDotsAndBoxes boardBoardDotsAndBoxes = new BoardDotsAndBoxes(rowsCount, colsCount);
				PlayerPersonDotsAndBoxes gosho = new PlayerPersonDotsAndBoxes("A");
				PlayerPCDotsAndBoxes gamerPC = new PlayerPCDotsAndBoxes("B");

				board = boardBoardDotsAndBoxes;
				gamerOne = gosho;
				gamerTwo = gamerPC;

			} else if (chosenGame == '3') {
				BoardMinesweeper boardMinesweeper = new BoardMinesweeper(rowsCount, colsCount, minesCount);
				PlayerPersonMinesweeper gosho = new PlayerPersonMinesweeper("A");

				board = boardMinesweeper;
				gamerOne = gosho;
			}

			board.setPlayerPerson(gamerOne);
			gamerOne.setGame(board);

			if (chosenGame != '3') {
				board.setPlayerPC(gamerTwo);
				gamerTwo.setGame(board);
			}

			board.generateBoard(board.getBoardField(), board.getRows(), board.getCols(), minesCount);
			board.printClient();
			if (chosenGame != '3') {
				while (!board.isGameOver()) {
					gamerOne.play(gamerOne);
					board.play(gamerOne);
					if (!board.isGameOver()) {
						gamerTwo.play(gamerTwo);
						board.play(gamerTwo);
					}
				}
			} else {
				while (!board.isGameOver()) {
					gamerOne.play(gamerOne);
					board.play(gamerOne);
				}
			}
		} while (chosenGame != 113 && chosenGame != 81);
	}

	private static int choseColsCount(int minCount, int maxCount) {

		Scanner sc = new Scanner(System.in);
		int colsCount = 0;
		do {
			System.out.println("Please, enter number of Cols (from 3 to 20): ");
			colsCount = sc.nextInt();
		} while (colsCount < minCount || colsCount > maxCount);
		return colsCount;
	}

	private static int choseRowsCount(int minCount, int maxCount) {

		Scanner sc = new Scanner(System.in);
		int rowsCount = 0;
		do {
			System.out.println("Please, enter number of Rows (from 3 to 20): ");
			rowsCount = sc.nextInt();
		} while (rowsCount < minCount || rowsCount > maxCount);
		return rowsCount;

	}

	private static char choseGame() {

		Scanner sc = new Scanner(System.in);
		char chosenGame = '0';
		System.out.println("Welcome!!! Lets Play!!! ");
		System.out.println();
		System.out.println("1. Tic Tac Toe");
		System.out.println("2. Dots and Boxes");
		System.out.println("3. Minesweeper");
		System.out.println("4. Fox and Hounds");
		System.out.println("5. Amazing Quest");
		System.out.println();
		System.out.println("To quit: q.");
		System.out.println();
		do {
			System.out.println("Choose your Game: ");
			chosenGame = sc.next().charAt(0);

		} while ((chosenGame < 49 || chosenGame > 53) && (chosenGame != 113 && chosenGame != 81));
		return chosenGame;
	}

	private static int choseColsCount(int level) {
		int cols = 0;
		switch (level) {
		case 1:
			cols = 8;
			return cols;
		case 2:
			cols = 16;
			return cols;

		case 3:
			cols = 30;
			return cols;
		case 4:
			cols = 30;
			return cols;
		default:
			System.out.println("Don't you want to play?!");
			return cols;
		}
	}

	private static int choseRowsCount(int level) {
		Scanner sc = new Scanner(System.in);
		int rows = 0;
		switch (level) {
		case 1:
			rows = 8;
			return rows;
		case 2:
			rows = 16;
			return rows;
		case 3:
			rows = 16;
			break;
		case 4:
			rows = 16;
			return rows;
		default:
			System.out.println("Don't you want to play?!");
			return rows;
		}
		return rows;
	}

	static int choseMinesweeperLevel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome! Lets play Minesweeper!");
		System.out.println();
		System.out.println("Choose the level!!!");
		System.out.println();
		System.out.println("1. Beginer.");
		System.out.println("2. Intermediate.");
		System.out.println("3. Expert.");
		System.out.println("4. Custom.");
		System.out.println();
		int level = 0;
		do {
			System.out.println("Please, enter level from 1 to 4:");
			level = sc.nextInt();
		} while (level < 1 || level > 4);
		return level;
	}

	static int choseMinesCount(int level) {
		Scanner sc = new Scanner(System.in);
		int mines = 0;
		switch (level) {
		case 1:
			mines = 10;
			break;
		case 2:
			mines = 49;
			break;
		case 3:
			mines = 99;
			break;
		case 4:
			do {
				System.out.println("Please, enter the number of the mines from 1 to 99:");
				mines = sc.nextInt();
			} while (mines < 1 || mines > 99);
			break;
		default:
			System.out.println("Don't you want to play?!");
			break;
		}
		return mines;
	}

}
