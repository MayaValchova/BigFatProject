package AllAbstractClasses;

public abstract class Player implements IPlay, IPrint {

	protected String name;
	private Board game;
	
	
	private int gamerRowOne;
	private int gamerColOne;
	
	private int gamerRowTwo;
	private int gamerColTwo;

	
	
	public Player() {
	}
	
	public Player(String name) {
		setName(name);
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
//	public char[][] getBoardField() {
//		return getBoardField();
	//}

	
	public Board getGame() {
		return game;
	}
	public void setGame(Board game) {
		if(game!=null)
		this.game = game;
	}

	
	
	public int getGamerRowOne() {
		return gamerRowOne;
	}
	public void setGamerRowOne(int gamerRow) {
		this.gamerRowOne = gamerRow;
	}

	
	public int getGamerColOne() {
		return gamerColOne;
	}
	public void setGamerColOne(int gamerCol) {
		this.gamerColOne = gamerCol;
	}

	public int getGamerRowTwo() {
		return gamerRowTwo;
	}
	public void setGamerRowTwo(int gamerRow) {
		this.gamerRowTwo = gamerRow;
	}

	
	public int getGamerColTwo() {
		return gamerColTwo;
	}
	public void setGamerColTwo(int gamerCol) {
		this.gamerColTwo = gamerCol;
	}
	
	public static String enterName() {
		return "Anonymous";
	}

	
	

//	 
	

}
