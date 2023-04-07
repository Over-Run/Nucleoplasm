package org.overrun.nucleoplasm_nuclide.decay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BaseDecay {
    Map<Integer, List<OutRecord>> map();
    String name();

}
