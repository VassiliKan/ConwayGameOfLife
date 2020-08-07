import java.awt.Graphics;

import javax.swing.JPanel;

public class Paint extends JPanel {
		
		private GameBoard game;
		private Maze maze;
		
		public void update(GameBoard currentGame) {
			this.game = currentGame;
		}
		
		public void paintComponent (Graphics g) {
			
			super.paintComponent(g);
			
			game.nextGen(g);
			game.draw(g);
			game.updateBoard();
			//maze.draw(g);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace(); }
				
			this.repaint();
		}

	
		/*public void drawMaze(Maze maze) {
			this.maze = maze;
		}*/
		
}
