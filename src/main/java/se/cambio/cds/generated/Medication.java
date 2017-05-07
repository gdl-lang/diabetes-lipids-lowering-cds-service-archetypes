package se.cambio.cds.generated;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.gdl2.datatypes.DvCodedText;
import org.gdl2.datatypes.DvDateTime;
import org.gdl2.datatypes.DvQuantity;
import org.gdl2.runtime.DataInstance;
import org.gdl2.runtime.DataInstance.Builder;

@Data
public final class Medication {
  @NotNull
  private DvCodedText genericName;

  @NotNull
  private DvQuantity dose;

  private DvDateTime lastAdministration;

  private DvDateTime firstAdministration;

  public boolean isGenericNameRequired() {
    return true;
  }

  public boolean isDoseRequired() {
    return true;
  }

  public boolean isLastAdministrationRequired() {
    return false;
  }

  public boolean isFirstAdministrationRequired() {
    return false;
  }

  public List<DataInstance> toDataInstances() {
    List<DataInstance> dataInstances = new ArrayList<>();
    dataInstances.add(new DataInstance.Builder()
        .modelId("openEHR-EHR-INSTRUCTION.medication.v1")
        .addValue("/activities[at0001]/description[openEHR-EHR-ITEM_TREE.medication.v1]/items[at0012]", this.genericName)
        .addValue("/activities[at0001]/description[openEHR-EHR-ITEM_TREE.medication.v1]/items[at0033]/items[at0035]/items[at0037]", this.dose)
        .addValue("/activities[at0001]/description[openEHR-EHR-ITEM_TREE.medication.v1]/items[at0018]/items[at0032]", this.lastAdministration)
        .addValue("/activities[at0001]/description[openEHR-EHR-ITEM_TREE.medication.v1]/items[at0018]/items[at0019]", this.firstAdministration)
        .build());
    return dataInstances;
  }
}
