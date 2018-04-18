
public class User {

	private String login;
	private int pwd;

	public User(String login, int pwd) {
		this.login = login;
		this.pwd = pwd;
	}

	public boolean authenticate(String login, int pwd) {
		return this.login.equals(login) && this.pwd == pwd;
	}
	
}
