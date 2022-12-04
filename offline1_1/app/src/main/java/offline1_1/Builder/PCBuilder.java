package offline1_1.Builder;

import offline1_1.PC;
import offline1_1.graphics.GraphicsCard;
import offline1_1.ram.RAM;

public abstract class PCBuilder {
    protected PC pc;

    protected PCBuilder(){
        pc = new PC();
    }

    public abstract void initPC();
    public void addRam(RAM ram){
        pc.getRams().add(ram);
    }
    public void addGraphicsCard(GraphicsCard card){
        pc.getGraphicsCards().add(card);
    }

    public PC getPC(){
        return pc;
    }
}
