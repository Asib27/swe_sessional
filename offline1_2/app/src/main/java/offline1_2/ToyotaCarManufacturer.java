package offline1_2;

public class ToyotaCarManufacturer extends CarManufacturer{
    @Override
    protected Car getCar() {
        return new ToyotaCar();
    }
}
