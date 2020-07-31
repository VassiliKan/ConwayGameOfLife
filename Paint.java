import java.awt.Graphics;

import javax.swing.JPanel;

public class Paint extends JPanel {
		
		private GameBoard game;
		
		public void update(GameBoard currentGame) {
			this.game = currentGame;
		}
		
		public void paintComponent (Graphics g) {
			
			super.paintComponent(g);
			
			game.updateBoard(g);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace(); }
			
			this.repaint();
		}
		
}
