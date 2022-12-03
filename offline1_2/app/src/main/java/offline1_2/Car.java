package offline1_2;

public abstract class Car {
    private String companyName;
    private String manufacturingCountry;

    Car(String country, String companyName){
        this.manufacturingCountry = country;
        this.companyName = companyName;
    }

    abstract void buildEngine();
    abstract void buildDriveTrainSystem();
    abstract void paintCar();

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getManufacturingCountry() {
        return this.manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

}
