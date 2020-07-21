import java.util.Arrays;

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
		this.gameboard[30][25].setState(true);
		this.gameboard[32][25].setState(true);
		this.gameboard[31][26].setState(true);
		this.gameboard[32][24].setState(true);
	}
	
	public void checkCell() {
		int nbNeighboors;
		for (int i = 0; i < NB_ROWS; i++) {
			for (int j = 0; j < NB_COLS; j++) {
				currentCell = this.gameboard[i][j];
				nbNeighboors = countNeighboors(currentCell, i, j);
				if (nbNeighboors == 3 && !currentCell.getState())
					currentCell.setState(true);
				else  if ((nbNeighboors == 2 || nbNeighboors == 3) && currentCell.getState())
						currentCell.setState(true);
					else
						currentCell.setState(false);
			}
		}
	}
	
	public int countNeighboors(Cells cell, int x, int y) {
		int nbNeighboors = 0;
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (this.gameboard[i][j].getState())
					nbNeighboors++;
			}
		}
		if (currentCell.getState())
			return nbNeighboors - 1;
		else 
			return nbNeighboors;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < NB_ROWS; i++) {
			for (int j = 0; j < NB_COLS; j++) {
				if (this.gameboard[i][j].getState())
					str += "* ";
				else
					str += "  ";
			}
			str += "\n";
		}
		return str;
	}
	
	
}
