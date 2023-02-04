import java.util.ArrayList;
import java.util.Scanner;

interface Coffee{
	int price();
	void print();
}

class Cup implements Coffee{
	private Coffee wrapped;

	public Cup(Coffee w){this.wrapped = w;}

	@Override
	public int price(){ return 100 + wrapped.price();}

	@Override
	public void print(){ wrapped.print(); System.out.println("Coffee mug : 100");}
}


class BlackCoffee implements Coffee{
	private Coffee wrapped;

	public BlackCoffee(Coffee w){this.wrapped = w;}

	@Override
	public int price(){ return 30 + wrapped.price();}

	@Override
	public void print(){  wrapped.print(); System.out.println("Black Coffee : 30");}
}



class MilkCoffee implements Coffee{
	private Coffee wrapped;

	public MilkCoffee(Coffee w){this.wrapped = w;}
	@Override
	public int price(){ return 80 + wrapped.price();}
	@Override
	public void print(){  wrapped.print(); System.out.println("Milk coffee : 80");}
}


class CoffeeBeans implements Coffee{
	private Coffee wrapped;

	CoffeeBeans(Coffee w){this.wrapped = w;}
	@Override
	public int price(){ return 30 + wrapped.price();}

	@Override
	public void print(){  wrapped.print(); System.out.println("Coffee beans : 30");}
}


class DairyCream implements Coffee{
	private Coffee wrapped;

	public DairyCream(Coffee w){this.wrapped = w;}
	public int price(){ return 40 + wrapped.price();}
	public void print(){  wrapped.print(); System.out.println("Coffee mug : 40");}
}


class CinnamonPowder implements Coffee{
	private Coffee wrapped;

	public CinnamonPowder(Coffee w){this.wrapped = w;}

	@Override
	public int price(){ return 50 + wrapped.price();}
	@Override
	public void print(){  wrapped.print(); System.out.println("Coffee mug : 50");}
}


class ChocolateSauce implements Coffee{
	private Coffee wrapped;

	public ChocolateSauce(Coffee w){this.wrapped = w;}
	@Override
	public int price(){ return 60 + wrapped.price();}

	@Override
	public void print(){  wrapped.print(); System.out.println("Coffee mug : 60");}
}


class Base implements Coffee{
	private String name;
	Base(String name){this.name = name;}

	@Override
	public int price(){ return 0;}
	@Override
	public void print(){
		System.out.println("1 cup " + name);
		System.out.println("Ingredient : Price");
	}
}


class CoffeeCup implements Coffee{
	private Coffee wrapped;
	public CoffeeCup(Coffee w){this.wrapped = w;}

	@Override
	public int price(){ return 100 + wrapped.price();}
	@Override
	public void print(){  wrapped.print(); System.out.println("Coffee Cup : 100");}
}


/**
 * offline3-2
 */
class Main {
	public static Coffee getAmericano() {
		return new CoffeeCup(new CoffeeBeans(new BlackCoffee(new Base("Americano"))));
	}
	public static Coffee getEspresso() {
		return new CoffeeCup(new DairyCream(new BlackCoffee(new Base("Espresso"))));
	}
	public static Coffee getCappuccino() {
		return new CoffeeCup(new CinnamonPowder(new MilkCoffee(new Base("Cappucino"))));
	}
	public static Coffee getMocha() {
		return new CoffeeCup(new ChocolateSauce(new MilkCoffee(new Base("Mocha"))));
	}

	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Coffee> coffees = new ArrayList<>();
		while(true){
			System.out.println("Your choice : ");
			System.out.println("[1] Americano");
			System.out.println("[2] Espresso");
			System.out.println("[3] Cappuccino");
			System.out.println("[4] Mocha");
			System.out.println("[0] Finish order");

			int choice =  scn.nextInt();
			if(choice == 1){
				coffees.add(getAmericano());
			}
			else if(choice == 2){
				coffees.add(getEspresso());
			}
			else if(choice == 3){
				coffees.add(getCappuccino());
			}
			else if(choice == 4){
				coffees.add(getMocha());
			}
			else if(choice == 0){
				break;
			}
			else{
				System.out.println("Invalid Command");
			}
		}

		int grandTotal = 0;
		for(Coffee i: coffees){
			System.out.println("----------------------------------");
			i.print();
			System.out.println("Total : " + i.price());
			grandTotal += i.price();
		}
		System.out.println("=================================");
		System.out.println("Grand total : " + grandTotal);
	}	
}