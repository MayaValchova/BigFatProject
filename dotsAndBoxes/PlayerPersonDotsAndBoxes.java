package dotsAndBoxes;

import java.util.Scanner;

import AllAbstractClasses.*;

public class PlayerPersonDotsAndBoxes extends Player {

	public PlayerPersonDotsAndBoxes() {
		this((enterName()));
	}

	public PlayerPersonDotsAndBoxes(String name) {
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

	@Override
	public void play(Player player) {
		makeMoove(this.getGame());

	}

	public void makeMoove(Board game) {
		
		System.out.println("\nPlayer, it is your turn!");

		Scanner sc = new Scanner(System.in);
		int r1, c1, r2, c2;
		boolean isXYCorrect = false;

		while (!isXYCorrect) {

			do {
				System.out.println("Please, enter Row point One:");
				r1 = sc.nextInt();
			} while (r1 < 1 || r1 > (this.getGame().getRows() + 1) / 2);

			do {
				System.out.println("Please, enter Col Point One:");
				c1 = sc.nextInt();
			} while (c1 < 1 || c1 > (this.getGame().getCols() + 1) / 2);

			do {
				System.out.println("Please, enter Row point Two:");
				r2 = sc.nextInt();
			} while (r2 < 1 || r2 > (this.getGame().getRows() + 1) / 2);

			do {
				System.out.println("Please, enter Col Point Two:");
				c2 = sc.nextInt();
			} while (c2 < 1 || c2 > (this.getGame().getCols() + 1) / 2);

			if ((r1 == r2 && ((c1 == c2 + 1) || (c1 == c2 - 1))) || (c1 == c2 && ((r1 == r2 + 1) || (r1 == r2 - 1)))) {
				

				if (getGame().getBoardField()[r1 + r2 - 2][c1 + c2 - 2] == '|'
						|| getGame().getBoardField()[r1 + r2 - 2][c1 + c2 - 2] == '_') {
					isXYCorrect = false;
					System.out.println("The fild is not free!");
				}else {
					isXYCorrect = true;
				}
			} else {
				System.out.println("You entered incorrect values!");
				isXYCorrect = false;
			}
			
			
			if (isXYCorrect) {
				setGamerRowOne(r1 + r1 - 2);
				setGamerColOne(c1 + c1 - 2);
				setGamerRowTwo(r2 + r2 - 2);
				setGamerColTwo(c2 + c2 - 2);
			}

		}

	}

	@Override
	public void printBoard() {
	}

	@Override
	public void printClient() {
	}
}
