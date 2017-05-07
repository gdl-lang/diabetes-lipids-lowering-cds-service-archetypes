package se.cambio.cds.generated;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.gdl2.datatypes.DvCodedText;
import org.gdl2.datatypes.DvDateTime;
import org.gdl2.runtime.DataInstance;
import org.gdl2.runtime.DataInstance.Builder;

@Data
public final class Diagnosis {
  @NotNull
  private DvCodedText diagnosis;

  @NotNull
  private DvDateTime dateOfInitialOnset;

  public boolean isDiagnosisRequired() {
    return true;
  }

  public boolean isDateOfInitialOnsetRequired() {
    return true;
  }

  public List<DataInstance> toDataInstances() {
    List<DataInstance> dataInstances = new ArrayList<>();
    dataInstances.add(new DataInstance.Builder()
        .modelId("openEHR-EHR-EVALUATION.problem-diagnosis.v1")
        .addValue("/data[at0001]/items[at0002.1]", this.diagnosis)
        .addValue("/data[at0001]/items[at0003]", this.dateOfInitialOnset)
        .build());
    return dataInstances;
  }
}
