package demo;

import java.util.Scanner;

import AllAbstractClasses.*;
import SeaChess.*;

public class Demo {

	public static void main(String[] args) {

		char choosenGame = chooseGame(); // izbor na igrata
		int minCount = 3;
		int maxCount = 20;

		int rowsCount = chooseRowsCount(minCount, maxCount); // izbor broi redove
		int colsCount = chooseColsCount(minCount, maxCount); // izbor broi koloni
		// int mineCount=chooseMinesCount(choosenGame, minCount, maxCount);//za towa posle
		

		Board board = null;
		Player gamerOne = null;
		Player gamerTwo = null;

		if (choosenGame == '1') {

			BoardSeaChess boardSeaChess = new BoardSeaChess(rowsCount, colsCount);
			PlayerPerson gosho = new PlayerPerson("Gosho");
			PlayerPC gamerPC = new PlayerPC("PC");
			
			board = boardSeaChess;
			gamerOne = gosho;
			gamerTwo=gamerPC;

		}else if (choosenGame == '2') {

			
		}// if za 2, 3, 4, 5
		
	//	board.generateBoard(boardField, rows, cols, mines)

		board.setPlayerPerson(gamerOne);
		gamerOne.setGame(board);
		gamerTwo.setGame(board);
		board.generateBoard(board.getBoardField(), board.getRows(), board.getCols(), 0);
		board.printClient();
		
		
		gamerOne.play(gamerOne);
		board.play(gamerOne);
		//board.printClient();
		
		gamerTwo.play(gamerTwo);
		board.play(gamerTwo);
		
		
		// }

	}

	private static int chooseColsCount(int minCount, int maxCount) {

		Scanner sc = new Scanner(System.in);
		int colsCount = 0;
		do {
			System.out.println("Please, enter number of Cols (from 3 to 20): ");
			colsCount = sc.nextInt();
		} while (colsCount < minCount || colsCount > maxCount);
		return colsCount;
	}

	private static int chooseRowsCount(int minCount, int maxCount) {

		Scanner sc = new Scanner(System.in);
		int rowsCount = 0;
		do {
			System.out.println("Please, enter number of Rows (from 3 to 20): ");
			rowsCount = sc.nextInt();
		} while (rowsCount < minCount || rowsCount > maxCount);
		return rowsCount;

	}

	private static char chooseGame() {

		Scanner sc = new Scanner(System.in);
		char choosenGame = '0';
		System.out.println("Welcome!!! Lets Play!!! ");
		System.out.println();
		System.out.println("1. Seà chess");
		System.out.println("2. Dots and Boxes");
		System.out.println("3. Minesweeper");
		System.out.println("4. Fox and Hounds");
		System.out.println("5. Amazing Quest");
		System.out.println();
		System.out.println("To quit: q.");
		System.out.println();
		do {
			System.out.println("Choose your Game: ");
			choosenGame = sc.next().charAt(0);
		
		} while ((choosenGame < 49 || choosenGame > 53) && (choosenGame != 113 && choosenGame != 81));
		return choosenGame;
	}

}
