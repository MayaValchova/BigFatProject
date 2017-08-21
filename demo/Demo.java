package demo;

import java.util.Scanner;

import AllAbstractClasses.*;
import ticTacToe.*;
import dotsAndBoxes.*;


public class Demo {

	public static void main(String[] args) {
		
	

		char chosenGame = choseGame(); // izbor na igrata
		int minCount = 3;
		int maxCount = 20;

		int rowsCount = choseRowsCount(minCount, maxCount); // izbor broi redove
		int colsCount = choseColsCount(minCount, maxCount); // izbor broi koloni
		// int mineCount=chooseMinesCount(choosenGame, minCount, maxCount);//za towa posle
		

		Board board = null;
		Player gamerOne = null;
		Player gamerTwo = null;

		if (chosenGame == '1') {

			BoardTicTacToe boardTicTacToe = new BoardTicTacToe(rowsCount, colsCount);
			PlayerPerson gosho = new PlayerPerson("Gosho");
			PlayerPC gamerPC = new PlayerPC("CPU");
			
			board = boardTicTacToe;
			gamerOne = gosho;
			gamerTwo=gamerPC;

		}else if (chosenGame == '2') {
			BoardDotsAndBoxes boardBoardDotsAndBoxes  = new BoardDotsAndBoxes (rowsCount, colsCount);
			board = boardBoardDotsAndBoxes;
			PlayerPersonDotsAndBoxes gosho = new PlayerPersonDotsAndBoxes("A");
			gamerOne = gosho;
			
			PlayerPCDotsAndBoxes gamerPC = new PlayerPCDotsAndBoxes("B");
			gamerTwo=gamerPC;
		}// if za 2, 3, 4, 5
		
		//board.generateBoard(boardField, rows, cols, mines) za 3

		board.setPlayerPerson(gamerOne);
		gamerOne.setGame(board);
		gamerTwo.setGame(board);
		board.generateBoard(board.getBoardField(), board.getRows(), board.getCols(), 0);
		board.printClient();
		
		
		while(!board.isGameOver()) {
		
			gamerOne.play(gamerOne);
			board.play(gamerOne);
		
			if (!board.isGameOver()) {
				gamerTwo.play(gamerTwo);
				board.play(gamerTwo);
			}
		}
		


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

}
