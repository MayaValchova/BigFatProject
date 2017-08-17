package SeaChess;

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
		this.name = "*PC";
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

}
