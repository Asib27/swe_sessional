package vending_machine;

public class StockOutState implements State{

    private VendingMachine vending_machine;

    public StockOutState(VendingMachine vendingMachine){
        this.vending_machine = vendingMachine;
    }

    @Override
    public void insertMoney(int taka) {
        System.out.println("Stocked out. No purchase.");        
    }

    @Override
    public void release() {
        System.out.println("Stocked out. No release.");        
    }
    
}
