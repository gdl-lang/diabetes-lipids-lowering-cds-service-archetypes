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
public final class LipidsLabTest {
  @NotNull
  private DvQuantity ldlCholesterol;

  @NotNull
  private DvDateTime time;

  public boolean isLdlCholesterolRequired() {
    return true;
  }

  public boolean isTimeRequired() {
    return true;
  }

  public List<DataInstance> toDataInstances() {
    List<DataInstance> dataInstances = new ArrayList<>();
    dataInstances.add(new DataInstance.Builder()
        .modelId("openEHR-EHR-OBSERVATION.lab_test-lipids.v1")
        .addValue("/data[at0001]/events[at0002]/data[at0003]/items[at0078.2]", this.ldlCholesterol)
        .addValue("/data/events/time", this.time)
        .build());
    return dataInstances;
  }
}
