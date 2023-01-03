package vending_machine;

public class ReleaseProductState implements State{
    private VendingMachine vending_machine;

    public ReleaseProductState(VendingMachine vendingMachine){
        this.vending_machine = vendingMachine;
    }

    @Override
    public void insertMoney(int taka) {
        System.out.println("You can only release product now");
    }

    @Override
    public void release() {
        int surplas = vending_machine.getMoney() - vending_machine.getObjectPrice();
        vending_machine.setMoney(0);

        if(surplas != 0){
            System.out.println("Giving back " + surplas + " Taka");
        }
        System.out.println("Releasing the product");
        vending_machine.setQuantity(vending_machine.getQuantity()-1);
        
        if(vending_machine.getQuantity() != 0){
            vending_machine.setState(new AcceptMoneyState(vending_machine));
        }else{
            vending_machine.setState(new StockOutState(vending_machine));
        }
    }
    
}
