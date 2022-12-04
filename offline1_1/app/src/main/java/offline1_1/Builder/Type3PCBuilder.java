package offline1_1.Builder;

import offline1_1.DVDDrive;
import offline1_1.PCBase;
import offline1_1.processor.CoreI9;

public class Type3PCBuilder extends PCBuilder{
    @Override
    public void initPC() {
        pc.setPcbase(new PCBase());
        pc.setProcessor(new CoreI9());
        pc.setDrive(new DVDDrive());
    }
}
