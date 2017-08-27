package ticTacToe;

import java.util.Random;
import java.util.Scanner;

import AllAbstractClasses.*;
public class PlayerPC extends Player {
	
	

	public PlayerPC(String name) {
		super(name);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "CPU";
	}
	
	
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		
		makeMoove(this.getGame());
		
		printClient();
		
	}
	
	
	
	

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
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
	
	
	
	
		
		
		public void makeMoove(Board game) {

			Random r = new Random();
			int row = r.nextInt(getGame().getRows());
			int col = r.nextInt(getGame().getCols());		
			do{
				setGamerRowOne(row);
				setGamerColOne(col);
			} while(getGame().getBoardField()[row][col] != 0);
	
	}

}
