import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App { // implements Runnable {

	static GameBoard game = new GameBoard();

	public static void main(String[] args) {
		game.init();
		game.checkCell();
		System.out.println(game);
       /*ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable task = new App();
        int initialDelay = 500;
        int periodicDelay = 2000;
        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay, TimeUnit.MILLISECONDS);	
       */ 
	}

	/*@Override
	public void run() {
		System.out.println(game);
		game.checkCell();
	}
*/
}
