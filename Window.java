import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{

	private final int width = 650;
	private final int height = 650;
	private static Paint background, background2;
	
	public Window() {
		this.setTitle("Conway game of life");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		background = new Paint();
		this.setContentPane(background);
		//background2 = new Paint();
		//this.setContentPane(background2);
	}
	
	public static void update(GameBoard game) {
		background.update(game);
	}

	/*public void drawMaze(Maze maze) {
		background.drawMaze(maze);
	}*/
}
