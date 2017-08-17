package AllAbstractClasses;

public interface IGenerateBoard {

	char [] [] generateBoard(char [][] boardField, int rows, int cols, int mines);
	void setBoardField(char[][] board);
	char[][] getBoardField();
}
