package se.cambio.cds.generated;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.gdl2.datatypes.DvQuantity;
import org.gdl2.runtime.DataInstance;
import org.gdl2.runtime.DataInstance.Builder;

@Data
public final class Qrisk {
  @NotNull
  private DvQuantity score;

  public boolean isScoreRequired() {
    return true;
  }

  public List<DataInstance> toDataInstances() {
    List<DataInstance> dataInstances = new ArrayList<>();
    dataInstances.add(new DataInstance.Builder()
        .modelId("openEHR-EHR-OBSERVATION.qrisk2_2015_score.v0")
        .addValue("/data[at0001]/events[at0002]/data[at0003]/items[at0004]", this.score)
        .build());
    return dataInstances;
  }
}
