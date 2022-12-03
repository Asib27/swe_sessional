package offline1_2;

public abstract class CarManufacturer {
    Car car = null;

    CarManufacturer(){
        car = getCar();
    }

    abstract protected Car getCar();
    public void manufacture(){
        System.out.println("Creating " + car.getCompanyName() + " car");
        System.out.println("=======================");

        System.out.println("The car is made in " + car.getManufacturingCountry());
        car.buildEngine();
        car.buildDriveTrainSystem();
        car.paintCar();
        System.out.println("Build Finished.");
    }
    
}
