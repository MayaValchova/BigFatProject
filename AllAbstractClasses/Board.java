package AllAbstractClasses;

public abstract class Board implements IGenerateBoard, IPrint, IPlay {

	private int rows;
	private int cols;
	private char[][] boardField;
	private Player playerPerson;
	private Player playerPC;

	// private static int rowsBoard=rows;
	
	
	

	public Board(int rows, int cols) {
		setRows(rows);
		setCols(cols);

		boardField = new char[getRows()][getCols()];

	}

	public Player getPlayerPerson() {
		return playerPerson;
	}

	public void setPlayerPerson(Player playerPerson) {
		if (playerPerson != null) {
			this.playerPerson = playerPerson;
		}
	}

	public Player getPlayerPC() {
		return playerPC;
	}
	
	

	public void setPlayerPC(Player playerPC) {
		if (playerPC != null) {
			this.playerPC = playerPC;
		}
	}
	

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public char[][] getBoardField() {
		return boardField;
	}

	public void setBoardField(char[][] board) {
		this.boardField = board;
	}

}
