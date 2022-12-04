package offline1_1.Builder;

import offline1_1.PCBase;
import offline1_1.cooler.LicquidCooler;
import offline1_1.processor.CoreI7;

public class Type2PCBuilder extends PCBuilder {
    @Override
    public void initPC() {
        pc.setPcbase(new PCBase());
        pc.setProcessor(new CoreI7());
        pc.setCooler(new LicquidCooler());
    }
}
