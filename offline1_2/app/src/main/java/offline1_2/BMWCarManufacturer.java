package offline1_2;

public class BMWCarManufacturer extends CarManufacturer{
    @Override
    protected Car getCar() {
        return new BMWCar();
    }
}
