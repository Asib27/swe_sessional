package offline1_1.Builder;

import offline1_1.PCBase;
import offline1_1.processor.Ryzen5700X;

public class GamingPCBuilder extends PCBuilder {
    @Override
    public void initPC() {
        pc.setPcbase(new PCBase());
        pc.setProcessor(new Ryzen5700X());
    }
}
