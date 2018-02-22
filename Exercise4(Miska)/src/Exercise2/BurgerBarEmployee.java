package Exercise2;

public class BurgerBarEmployee implements Runnable{
	
	private String name;
	private Burgerbar burgerbar;

	public BurgerBarEmployee(String name, Burgerbar burgerbar) {
		this.name = name;
		this.burgerbar = burgerbar;
	}

	@Override
	public void run() {
		for(;;) {
			burgerbar.makeBurger(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
			
		
	}

}
