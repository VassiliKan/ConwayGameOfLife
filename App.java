import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App { 
	
	static GameBoard game = new GameBoard();
	
	public static void main(String[] args) {
		game.init();
		Window win = new Window();
		win.update(game);
	}
}

