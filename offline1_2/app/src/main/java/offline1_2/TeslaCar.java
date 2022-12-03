package offline1_2;

public class TeslaCar extends Car {
    TeslaCar(){
        super("US", "Tesla");
    }

    @Override
    void buildEngine() {
        System.out.println("Installing " + "Electric" + " engine");
    }

    @Override
    void buildDriveTrainSystem() {
        System.out.println("Installing " + "all wheel" + " drive trains");
    }

    @Override
    void paintCar() {
        System.out.println("Coloring it " + "white");
    }
}
