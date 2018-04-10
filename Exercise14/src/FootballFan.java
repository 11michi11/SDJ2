import java.util.Observable;
import java.util.Observer;

public class FootballFan implements Observer {

	private Boolean homeTeamFan;
	private FootballGame game;

	public FootballFan(FootballGame game, Boolean homeTeamFan) {
		this.homeTeamFan = homeTeamFan;
		this.game = game;
		cheer();
	}

	public void cheer() {
		if (homeTeamFan == true)
			System.out.println("JUPI");
	}

	public void reactOnGoal(Boolean isHomeTeam) {
		if (isHomeTeam == true) {
			System.out.println("OH YES");
		} else
			System.out.println("NOOO");
	}

	@Override
	public void update(Observable o, Object arg) {
		String team = (String) arg;
		if ((team.equals(game.getHomeTeam()) && homeTeamFan) || (!team.equals(game.getHomeTeam()) && !homeTeamFan))
			reactOnGoal(true);
		else 
			reactOnGoal(false);
	}

}
