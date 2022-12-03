package offline1_2;

public abstract class Car {
    private String companyName;
    private String manufacturingCountry;

    Car(String country, String companyName){
        this.manufacturingCountry = country;
    }

    abstract void buildEngine();
    abstract void buildDriveTrainSystem();
    abstract void paintCar();

    void manufacture(){
        // System.out.println("Created by : " + companyName);
        // System.out.println("Created in : " + manufacturingCountry);
        // System.out.println("Installing " + engine + " engine");
        // System.out.println("Installing " + driveTrainSystem + " drive trains");
        // System.out.println("Coloring it " + color);
    }
}
