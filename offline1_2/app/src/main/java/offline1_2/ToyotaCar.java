package offline1_2;

public class ToyotaCar extends Car {
    ToyotaCar(){
        super("Japan", "Toyota");
    }

    @Override
    void buildEngine() {
        System.out.println("Installing " + "Hydrozen fuel cell" + " engine");
    }

    @Override
    void buildDriveTrainSystem() {
        System.out.println("Installing " + "rear-wheel" + " drive trains");
    }

    @Override
    void paintCar() {
        System.out.println("Coloring it " + "red");
    }
}
