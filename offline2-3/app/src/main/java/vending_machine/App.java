/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package vending_machine;

public class App {
    public static void main(String[] args) {
        VendingMachine vending_machine = new VendingMachine();

        vending_machine.insertMoney(15);
        vending_machine.release();

        vending_machine.insertMoney(10);
        vending_machine.release();

        vending_machine.insertMoney(20);
        vending_machine.release();

        vending_machine.insertMoney(15);
        vending_machine.release();
    }
}