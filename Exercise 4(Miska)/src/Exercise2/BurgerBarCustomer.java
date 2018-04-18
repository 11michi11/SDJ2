package Exercise2;

public class BurgerBarCustomer implements Runnable{
	
	private int burgersToEat;
	private String who;
	private Burgerbar burgerbar;

	public BurgerBarCustomer(int burgersToEat, String who, Burgerbar burgerbar) {
		this.burgersToEat = burgersToEat;
		this.who = who;
		this.burgerbar = burgerbar;
	}

	@Override
	public void run() {
		for(int i = 0; i <= burgersToEat; i++) {
			burgerbar.eatBurger(who);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
