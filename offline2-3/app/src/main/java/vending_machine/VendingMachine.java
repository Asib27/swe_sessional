package vending_machine;

public class VendingMachine{
    private int money;
    private State state;

    private int objectPrice;
    private int quantity;

    public VendingMachine(){
        objectPrice = 20;
        quantity = 2;
        money = 0;
        state = new AcceptMoneyState(this);
    }

    int getObjectPrice(){
        return objectPrice;
    }

    int getQuantity(){
        return quantity;
    }
    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    void setState(State state){
        this.state = state;
    }

    void setMoney(int money){
        this.money = money;
    }

    int getMoney(){
        return money;
    }

    public void insertMoney(int taka) {
        state.insertMoney(taka);        
    }

    public void release() {
        state.release();        
    }
}
