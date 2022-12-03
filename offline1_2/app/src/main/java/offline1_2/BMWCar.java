package offline1_2;

public class BMWCar extends Car {
    BMWCar(){
        super("Germany", "BMW");
    }

    @Override
    void buildEngine() {
        System.out.println("Installing " + "Electric" + " engine");
    }

    @Override
    void buildDriveTrainSystem() {
        System.out.println("Installing " + "rear-wheel" + " drive trains");
    }

    @Override
    void paintCar() {
        System.out.println("Coloring it " + "black");
    }
}
