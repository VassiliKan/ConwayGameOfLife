
public class GameBoard {

	
	public static final int NB_ROWS = 40;
	public static final int NB_COLS = 40;
	Cells[][] gameboard;
	Cells currentCell;
	
	public GameBoard() {	
		this.gameboard = new Cells[NB_ROWS][NB_COLS];
	}

	public void init() {
		for (int i = 0; i < NB_ROWS; i++) {
			for (int j = 0; j < NB_COLS; j++) {
				this.gameboard[i][j] = new Cells();
			}
		}
	}
	
	public void checkCell() {
		for (int i = 0; i < NB_ROWS; i++) {
			for (int j = 0; j < NB_COLS; j++) {
				currentCell = this.gameboard[i][j];
				
			}
		}
	}
	
	public int countNeighboors(Cells cell) {
		int nbNeighboors;
		
		return nbNeighboors;
	}
}
