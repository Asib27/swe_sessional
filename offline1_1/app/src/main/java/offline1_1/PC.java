package offline1_1;

import java.util.ArrayList;

import offline1_1.cooler.Cooler;
import offline1_1.graphics.GraphicsCard;
import offline1_1.processor.Processor;
import offline1_1.ram.RAM;

public class PC {
    PCBase pcbase;
    Cooler cooler;
    DVDDrive drive;
    Processor processor;
    ArrayList<RAM> rams;
    ArrayList<GraphicsCard> graphicsCards;


    public PC() {
        rams = new ArrayList<>();
        graphicsCards = new ArrayList<>();
    }


    public PCBase getPcbase() {
        return this.pcbase;
    }

    public void setPcbase(PCBase pcbase) {
        this.pcbase = pcbase;
    }

    public Cooler getCooler() {
        return this.cooler;
    }

    public void setCooler(Cooler cooler) {
        this.cooler = cooler;
    }

    public DVDDrive getDrive() {
        return this.drive;
    }

    public void setDrive(DVDDrive drive) {
        this.drive = drive;
    }

    public Processor getProcessor() {
        return this.processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public ArrayList<RAM> getRams() {
        return this.rams;
    }

    public void setRams(ArrayList<RAM> rams) {
        this.rams = rams;
    }

    public ArrayList<GraphicsCard> getGraphicsCards() {
        return this.graphicsCards;
    }

    public void setGraphicsCards(ArrayList<GraphicsCard> graphicsCards) {
        this.graphicsCards = graphicsCards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(pcbase.getName() + " " + pcbase.getPrice() + "\n");
        sb.append(processor.getName() + " " + processor.getPrice() + "\n");

        if(cooler != null)
            sb.append(cooler.getName() + " " + cooler.getPrice() + "\n");

        if(drive != null)
            sb.append(drive.getName() + " " + drive.getPrice() + "\n");

        for(var ram : rams){
            sb.append(ram.getName() + " " + ram.getPrice() + "\n");
        }

        for(var card : graphicsCards){
            sb.append(card.getName() + " " + card.getPrice() + "\n");
        }

        return sb.toString();
    }
}
