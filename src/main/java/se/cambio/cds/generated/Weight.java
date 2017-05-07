package se.cambio.cds.generated;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.gdl2.datatypes.DvDateTime;
import org.gdl2.datatypes.DvQuantity;
import org.gdl2.runtime.DataInstance;
import org.gdl2.runtime.DataInstance.Builder;

@Data
public final class Weight {
  @NotNull
  private DvQuantity weight;

  @NotNull
  private DvDateTime time;

  public boolean isWeightRequired() {
    return true;
  }

  public boolean isTimeRequired() {
    return true;
  }

  public List<DataInstance> toDataInstances() {
    List<DataInstance> dataInstances = new ArrayList<>();
    dataInstances.add(new DataInstance.Builder()
        .modelId("openEHR-EHR-OBSERVATION.body_weight.v1")
        .addValue("/data[at0002]/events[at0003]/data[at0001]/items[at0004]", this.weight)
        .addValue("/data/events/time", this.time)
        .build());
    return dataInstances;
  }
}
