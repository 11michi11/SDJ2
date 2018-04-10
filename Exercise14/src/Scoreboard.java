import java.util.Observable;
import java.util.Observer;

public class Scoreboard implements Observer{
	
	private FootballGame game;
	
	public Scoreboard(FootballGame game) {
		this.game = game;
		showScore();	
	}
	
	public void showScore() {
		System.out.println(game.getScore());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		showScore();
	}

}
