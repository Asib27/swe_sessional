/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package offline1_2;

public class App {
    public String getGreeting() {
        return "Hello World!";
        
    }

    public static void main(String[] args) {
        Car car =  new TeslaCar();
        car.buildDriveTrainSystem();
        car.buildEngine();
        car.paintCar();
        System.out.println(new App().getGreeting());
    }
}
