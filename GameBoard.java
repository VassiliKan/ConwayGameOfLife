import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class GameBoard {
	
	// Add Draw method cause updateBoard update immediately, not generation

	public static final int NB_ROWS = 80;
	public static final int NB_COLS = 80;
	Cells[][] gameboard;
	Cells currentCell;
		
	public GameBoard() {	
		this.gameboard = new Cells[NB_ROWS][NB_COLS];
	}

	public void init() {
		for (int x = 0; x <= NB_ROWS-1; x++) {
			for (int y = 0; y <= NB_COLS-1; y++) {
				this.gameboard[x][y] = new Cells();
			}
		}
		this.gameboard[20][15].setState(true);
		this.gameboard[21][15].setState(true);
		this.gameboard[22][15].setState(true);
		this.gameboard[23][16].setState(true);
		this.gameboard[22][17].setState(true);
		this.gameboard[21][17].setState(true);
		this.gameboard[20][17].setState(true);
	}
	
	
	public int countNeighboors(Cells cell, int currentCellX, int currentCellY) { //remove current cell cause useless
		int nbNeighboors = 0;
		for (int x = currentCellX - 1; x <= currentCellX + 1; x++) {
			for (int y = currentCellY - 1; y <= currentCellY + 1; y++) {
				if (y == -1 || y > NB_ROWS-1 || x == -1 || x > NB_COLS-1)
					nbNeighboors++;
				else if (this.gameboard[x][y].getState())
					nbNeighboors++;
			}
		}
		if (currentCell.getState()) {
			System.out.println(nbNeighboors-1);
			return nbNeighboors - 1;
		} else {
			System.out.println(nbNeighboors);
			return nbNeighboors;
		}
	}
	
	
	public void updateBoard(Graphics g) {
		int nbNeighboors;
		int side = 10;
		for (int x = 0; x <= NB_ROWS-1; x++) {
			for (int y = 0; y <= NB_COLS-1; y++) {
				currentCell = this.gameboard[x][y];
				System.out.println("x : "+ x + " y : "+y);
				nbNeighboors = countNeighboors(currentCell, x, y);
				if (nbNeighboors == 3 /*&& !currentCell.getState()*/) {
					currentCell.setState(true);
					g.setColor(Color.BLACK);
					g.fillRect(x*side, y*side, side, side);
					
				} else if ((nbNeighboors == 2 /*|| nbNeighboors == 3*/) && currentCell.getState()) {
						currentCell.setState(true);
						g.setColor(Color.BLACK);
						g.fillRect(x*side, y*side, side, side);
				} else {
						currentCell.setState(false);
						g.setColor(Color.WHITE);
						g.fillRect(x*side, y*side, side, side); }
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int x = 0; x < NB_ROWS; x++) {
			for (int y = 0; y < NB_COLS; y++) {
				if (this.gameboard[x][y].getState())
					str += "x ";
				else
					str += "* ";
			}
			str += "\n";
		}
		return str;
	}
	
	
}
