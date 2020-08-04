import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class GameBoard {
	
	// Need to combine draw and update method to optimize use of for loop
	// Need to review countNeighboors method

	public static final int NB_ROWS = 60;
	public static final int NB_COLS = 60;
	Cells[][] gameboard;
	Cells[][] stepGameboard;
	Cells currentCell;
		
	public GameBoard() {	
		this.gameboard = new Cells[NB_ROWS][NB_COLS];
		this.stepGameboard = new Cells[NB_ROWS][NB_COLS];
	}

	public void init() {
		for (int x = 0; x <= NB_ROWS-1; x++) {
			for (int y = 0; y <= NB_COLS-1; y++) {
				this.gameboard[x][y] = new Cells();
				this.stepGameboard[x][y] = new Cells();
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
				System.out.println("x2 : "+ x + " y2 : "+y);
				if (y == -1 || y > NB_ROWS-1 || x == -1 || x > NB_COLS-1) {
					if (this.gameboard[Math.abs(x-NB_COLS-1)][Math.abs(y-NB_ROWS-1)].getState())
						nbNeighboors++;
				} else if (this.gameboard[x][y].getState())
					nbNeighboors++;
			}
		}
		if (currentCell.getState()) 
			return nbNeighboors - 1;
		else 
			return nbNeighboors;
		}
	
	
	public void nextGen(Graphics g) {
		int nbNeighboors;
		for (int x = 0; x <= NB_ROWS-1; x++) {
			for (int y = 0; y <= NB_COLS-1; y++) {
				currentCell = this.gameboard[x][y];
				System.out.println("x : "+ x + " y : "+y);
				nbNeighboors = countNeighboors(currentCell, x, y);
				if (nbNeighboors == 3 )
					this.stepGameboard[x][y].setState(true);					
				else if ((nbNeighboors == 2) && currentCell.getState()) 
						this.stepGameboard[x][y].setState(true);
					else 
						this.stepGameboard[x][y].setState(false);
			}
		}
	}
	
	public void draw(Graphics g) {
		int size = 10;
		for (int x = 0; x <= NB_ROWS-1; x++) {
			for (int y = 0; y <= NB_COLS-1; y++) {
				if(this.gameboard[x][y].getState()) {
					g.setColor(Color.BLACK);
					g.fillRect(x*size, y*size, size, size);
				} else {
					g.setColor(Color.WHITE);
					g.fillRect(x*size, y*size, size, size);
				}
					
			}
		}
	}
	public void updateBoard() {
		for (int x = 0; x < NB_ROWS-1; x++) {
			for (int y = 0; y < NB_COLS-1; y++) {
				if (this.stepGameboard[x][y].getState())
					this.gameboard[x][y].setState(true);
				else
					this.gameboard[x][y].setState(false);
			}
		}
	}
	
	/*@Override
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
		str += "\n\n";
		for (int x = 0; x < NB_ROWS; x++) {
			for (int y = 0; y < NB_COLS; y++) {
				if (this.stepGameboard[x][y].getState())
					str += "x ";
				else
					str += "* ";
			}
			str += "\n";
		}
		return str;
	} */
	
	
}
