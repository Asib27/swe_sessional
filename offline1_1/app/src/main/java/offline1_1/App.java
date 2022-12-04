/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package offline1_1;

import offline1_1.cooler.CPUCooler;
import offline1_1.cooler.Cooler;
import offline1_1.cooler.LicquidCooler;
import offline1_1.graphics.Gb2GraphicsCard;
import offline1_1.graphics.Gb4GraphicsCard;
import offline1_1.graphics.GraphicsCard;

public class App {
    public static void main(String[] args) {
        Cooler cooler = new CPUCooler();
        System.out.println(cooler.getPrice()); 

        cooler = new LicquidCooler();
        System.out.println(cooler.getPrice()); 

        GraphicsCard card = new Gb2GraphicsCard();
        System.out.println(card.getName() + " " + card.getPrice());

        card = new Gb4GraphicsCard();
        System.out.println(card.getName() + " " + card.getPrice());
    }
}
