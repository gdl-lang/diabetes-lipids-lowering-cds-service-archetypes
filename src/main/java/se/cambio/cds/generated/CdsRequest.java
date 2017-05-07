package se.cambio.cds.generated;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.gdl2.runtime.DataInstance;

@Data
public final class CdsRequest {
  @NotNull
  private List<Diagnosis> diagnoses;

  private List<Medication> medications;

  private Height height;

  private Weight weight;

  private Qrisk qrisk;

  private List<LipidsLabTest> lipidsLabTests;

  public List<DataInstance> toDataInstances() {
    List<DataInstance> dataInstances = new ArrayList<>();
    if(diagnoses != null) {
      for(Diagnosis diagnosis : diagnoses) {
        dataInstances.addAll(diagnosis.toDataInstances());
      }
    }
    if(medications != null) {
      for(Medication medication : medications) {
        dataInstances.addAll(medication.toDataInstances());
      }
    }
    if(height != null) {
      dataInstances.addAll(height.toDataInstances());
    }
    if(weight != null) {
      dataInstances.addAll(weight.toDataInstances());
    }
    if(qrisk != null) {
      dataInstances.addAll(qrisk.toDataInstances());
    }
    if(lipidsLabTests != null) {
      for(LipidsLabTest lipidsLabTest : lipidsLabTests) {
        dataInstances.addAll(lipidsLabTest.toDataInstances());
      }
    }
    return dataInstances;
  }
}
