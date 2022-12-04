package offline1_1;

import offline1_1.Builder.PCBuilder;
import offline1_1.graphics.GraphicsCard;
import offline1_1.ram.RAM;

public class Director {
    private PCBuilder pcBuilder;

    public Director(PCBuilder pcBuilder){
        this.pcBuilder = pcBuilder;
        pcBuilder.initPC();
    }

    public void setPCBuilder(PCBuilder pcBuilder){
        this.pcBuilder = pcBuilder;
        pcBuilder.initPC();
    }

    public void addRam(RAM ram){
        pcBuilder.addRam(ram);
    }

    public void addGraphicsCard(GraphicsCard card){
        pcBuilder.addGraphicsCard(card);
    }

    public PC getPC(){
        return pcBuilder.getPC();
    }
}
