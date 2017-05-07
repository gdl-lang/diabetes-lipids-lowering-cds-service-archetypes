package se.cambio.cds.generated;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.gdl2.datatypes.DvCodedText;
import org.gdl2.datatypes.DvQuantity;
import org.gdl2.runtime.DataInstance;

@Data
public final class MedicationRequest {
  private DvCodedText genericName;

  private DvQuantity dose;

  public static MedicationRequest fromSingleDataInstance(DataInstance dataInstance) {
    MedicationRequest medicationRequest = new MedicationRequest();
    medicationRequest.setGenericName(dataInstance.getDvCodedText("/activities[at0001]/description[openEHR-EHR-ITEM_TREE.medication.v1]/items[at0012]"));
    medicationRequest.setDose(dataInstance.getDvQuantity("/activities[at0001]/description[openEHR-EHR-ITEM_TREE.medication.v1]/items[at0033]/items[at0035]/items[at0037]"));
    return medicationRequest;
  }

  public static List<MedicationRequest> fromDataInstances(List<DataInstance> dataInstances) {
    List<MedicationRequest> list = new ArrayList<>();
    List<DataInstance> selectedDataInstances = fetch("openEHR-EHR-INSTRUCTION.medication.v1", dataInstances);
    for (DataInstance dataInstance : selectedDataInstances) {
      list.add(fromSingleDataInstance(dataInstance));
    }
    return list;
  }

  private static List<DataInstance> fetch(String modelId, List<DataInstance> dataInstances) {
    List<DataInstance> list = new ArrayList<>();
    for (DataInstance dataInstance : dataInstances) {
      if (modelId.equals(dataInstance.modelId())) {
        list.add(dataInstance);
      }
    }
    return list;
  }
}
