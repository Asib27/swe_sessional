package vending_machine;

public interface State {
    void insertMoney(int taka);
    void release();
}
