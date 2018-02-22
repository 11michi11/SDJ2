package Exercise2;

public class MainBurgerbar {
	
	public static void main(String[] args) {
	
	Burgerbar burgerbar = new Burgerbar(50);
	BurgerBarEmployee employeeOne = new BurgerBarEmployee("Adam", burgerbar);
	BurgerBarEmployee employeeTwo = new BurgerBarEmployee("Matej", burgerbar);
	BurgerBarCustomer customerOne = new BurgerBarCustomer(2, "Miška", burgerbar);
	BurgerBarCustomer customerTwo = new BurgerBarCustomer(5, "Michal", burgerbar);
	BurgerBarCustomer customerThree = new BurgerBarCustomer(3, "Timotej", burgerbar);
	BurgerBarCustomer customerFour = new BurgerBarCustomer(4, "Oliver", burgerbar);
	BurgerBarCustomer customerFive = new BurgerBarCustomer(10, "Veronika", burgerbar);
	
	Thread one = new Thread(employeeOne);
	one.start();
	
	Thread two = new Thread(employeeTwo);
	two.start();
	
	Thread three = new Thread(customerOne);
	three.start();
	
	Thread four = new Thread(customerTwo);
	four.start();
	
	Thread five = new Thread(customerThree);
	five.start();
	
	Thread six = new Thread(customerFour);
	six.start();
	
	Thread seven = new Thread(customerFive);
	seven.start();
	
	}
}
