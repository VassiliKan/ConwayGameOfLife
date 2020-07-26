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
		for (int i = 0; i <= NB_ROWS-1; i++) {
			for (int j = 0; j <= NB_COLS-1; j++) {
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
		//System.out.println(this.gameboard[0][0]);
		//System.out.println(this.gameboard[NB_ROWS-1][NB_COLS-1]);
		for (int i = 0; i <= NB_ROWS-1; i++) {
			for (int j = 0; j <= NB_COLS-1; j++) {
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
		for (int i = x-1; i <= x + 1; i++) {
			for (int j = y-1; j <= y + 1; j++) {
				//System.out.println("x : "+x+"| y : "+y+ "| i : "+i+"| j : "+j);
				if (j==-1 || j > NB_ROWS-1 || i == -1 || i > NB_COLS-1)
					nbNeighboors++;
				else if (this.gameboard[i][j].getState())
				//	System.out.println(this.gameboard[i][j]);
					//System.out.println("i : "+i+" j : "+j);
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
					str += "x ";
				else
					str += "* ";
			}
			str += "\n";
		}
		return str;
	}
	
	
}
