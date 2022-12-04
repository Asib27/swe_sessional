package offline1_1.Builder;

import offline1_1.PCBase;
import offline1_1.cooler.CPUCooler;
import offline1_1.processor.CoreI5;

public class Type1PCBuilder extends PCBuilder {
    @Override
    public void initPC() {
        pc.setPcbase(new PCBase());
        pc.setProcessor(new CoreI5());
        pc.setCooler(new CPUCooler());
    }
}
