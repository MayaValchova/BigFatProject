package ticTacToe;

import java.util.Scanner;
import AllAbstractClasses.*;
import ticTacToe.BoardTicTacToe;

public class PlayerPerson extends Player {

	

	public PlayerPerson() {
		this((enterName()));
	}

	public PlayerPerson(String name) {
		super(name);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			this.name = "Anonymous";
		}
	}
	
	

	public void makeMoove(Board game) {

		

		Scanner sc = new Scanner(System.in);
		int r, c;
		do {
			System.out.println("Please, enter Row:");
			r = sc.nextInt();
		} while (r < 1|| r > this.getGame().getRows());
		setGamerRowOne(r-1);
		
		do {
			System.out.println("Please, enter Col:");
			c = sc.nextInt();
		} while (c < 1 || c > this.getGame().getCols());
		
		setGamerColOne(c-1);
		
		
		
	//	doMove(game.getBoardField(), getGamerRowOne(), getGamerColOne());
	//	printClient();
		
	}
	
	
	

//	public int getGamerRow() {
//		return gamerRow;
//	}
//
//	private void setGamerRow(int gamerRow) {
//		this.gamerRow = gamerRow;
//	}
//
//	public int getGamerCol() {
//		return gamerCol;
//	}
//
//	private void setGamerCol(int gamerCol) {
//		this.gamerCol = gamerCol;
//	}
//
//	public static String enterName() {
//		return "Anonymous";
//	}

	

//	@Override
//	public void printBoard() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void printClient() {
//		// TODO Auto-generated method stub
//		
//	}

	
	public void printClient() {
		System.out.println();
		for (int i = 0; i < getGame().getRows(); i++) {
			if (i <= 9) {
				System.out.print("   " + (i + 1));
			} else { 
				System.out.print("  " + (i + 1));
			}
		}
		System.out.println();
		System.out.print("  -");
		for (int i = 0; i < getGame().getCols(); i++) {
			System.out.print("----");
		}
		System.out.println();

		for (int i = 0; i < getGame().getRows(); i++) {
			if (i < 9) {
				System.out.print((i + 1) + " |");
			} else {
				System.out.print((i + 1) + "|");
			}

			for (int j = 0; j < getGame().getCols(); j++) {

				System.out.print(" " + getGame().getBoardField()[i][j] + " |");
			}
			System.out.println();
			System.out.print("  ");
			for (int j = 0; j <getGame().getCols(); j++) {

				System.out.print("----");
			}
			System.out.println("-");
		}
	}

	
	public void printBoard() {

		for (int i = 0; i < getGame().getRows(); i++) {
			for (int j = 0; j <getGame().getCols(); j++) {
				System.out.print(getGame().getBoardField()[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Override
	public void play(Player player) {
		
		makeMoove(this.getGame());
		
		
	//	char[][] doMove((char[][] boardField, int gamerRow, int gamerCol)) {
	//		boardField[gamerRow][gamerCol]=getName().charAt(0);
			
			
	//		return boardField;
	//	}
		// TODO Auto-generated method stub
		
	}



}
