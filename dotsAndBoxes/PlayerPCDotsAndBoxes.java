package dotsAndBoxes;

import AllAbstractClasses.*;

public class PlayerPCDotsAndBoxes extends Player {

	public PlayerPCDotsAndBoxes(String name) {
		super(name);
	}

	@Override
	public void play(Player player) {
		
		System.out.println("\nPC maked move!");

		boolean helpPosition = false;

		for (int i = 1; i < getGame().getRows(); i += 2) {
			for (int j = 1; j < getGame().getCols(); j += 2) {
				int counterBords = 0;
				if (getGame().getBoardField()[i][j] != 'A' && getGame().getBoardField()[i][j] != 'B') {

					if (getGame().getBoardField()[i - 1][j] == '_') {
						counterBords++;
					}

					if (getGame().getBoardField()[i + 1][j] == '_') {
						counterBords++;
					}

					if (getGame().getBoardField()[i][j - 1] == '|') {
						counterBords++;
					}

					if (getGame().getBoardField()[i][j + 1] == '|') {
						counterBords++;
					}
				}

				if (counterBords == 3) {
					if (getGame().getBoardField()[i - 1][j] != '_') {
						player.setGamerRowOne(i-1);
						player.setGamerColOne(j-1);
						player.setGamerRowTwo(i-1);
						player.setGamerColTwo(j+1);
						
					} else if (getGame().getBoardField()[i + 1][j] != '_') {
						player.setGamerRowOne(i+1);
						player.setGamerColOne(j-1);
						player.setGamerRowTwo(i+1);
						player.setGamerColTwo(j+1);

					} else if (getGame().getBoardField()[i][j - 1] != '|') {
						player.setGamerRowOne(i-1);
						player.setGamerColOne(j-1);
						player.setGamerRowTwo(i+1);
						player.setGamerColTwo(j-1);
						
					} else {
						player.setGamerRowOne(i-1);
						player.setGamerColOne(j+1);
						player.setGamerRowTwo(i+1);
						player.setGamerColTwo(j+1);
					}
					helpPosition = true;
					break;
				}
			}
		}

		if (!helpPosition) {
			for (int i = 0; i < getGame().getRows(); i += 2) {
				for (int j = 1; j < getGame().getCols(); j += 2) {
					
					if (getGame().getBoardField()[i][j] != '_') {
						
						player.setGamerRowOne(i);
						player.setGamerColOne(j-1);
						player.setGamerRowTwo(i);
						player.setGamerColTwo(j+1);
						
						helpPosition = true;
						break;
					}
				}
			}
		}
		if (!helpPosition) {
			for (int i = 1; i < getGame().getRows(); i += 2) {
				for (int j = 0; j <= getGame().getCols(); j += 2) {
									
					if (getGame().getBoardField()[i][j] != '|') {
						
						player.setGamerRowOne(i-1);
						player.setGamerColOne(j);
						player.setGamerRowTwo(i+1);
						player.setGamerColTwo(j);
						
						helpPosition = true;
						break;
					}
				}
			}
		}
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
