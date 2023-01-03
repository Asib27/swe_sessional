package vending_machine;

public class AcceptMoneyState implements State
{
    private VendingMachine vending_machine;

    public AcceptMoneyState(VendingMachine vendingMachine){
        this.vending_machine = vendingMachine;
    }

    @Override
    public void insertMoney(int taka) {
        int money = vending_machine.getMoney() + taka;
        vending_machine.setMoney(money);
        if(money >= vending_machine.getObjectPrice()){
            vending_machine.setState(new ReleaseProductState(vending_machine));
        }
    }

    @Override
    public void release() {
        System.out.println("Insufficient money");
    }
    
}
