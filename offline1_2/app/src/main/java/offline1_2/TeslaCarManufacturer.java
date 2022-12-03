package offline1_2;

public class TeslaCarManufacturer extends CarManufacturer {
    @Override
    protected Car getCar() {
        return new ToyotaCar();
    }
}
