package mineSweeper;

import java.util.Scanner;
import AllAbstractClasses.*;

public class PlayerPersonMinesweeper extends Player{
	
	public PlayerPersonMinesweeper(String name) {
		super(name);
	}
	

	@Override
	public void play(Player player) {
		
		int row = 0;
		int col = 0;
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Please, enter Row:");
			row = sc.nextInt();
			row -= 1;
		} while (row < 0 || row > getGame().getRows() - 1);

		do {
			System.out.println("Please, enter Col:");
			col = sc.nextInt();
			col -= 1;
		} while (col < 0 || col > getGame().getCols() - 1);
		
		setGamerRowOne(row);
		setGamerColOne(col);
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printClient() {
		// TODO Auto-generated method stub
		
	}

}
