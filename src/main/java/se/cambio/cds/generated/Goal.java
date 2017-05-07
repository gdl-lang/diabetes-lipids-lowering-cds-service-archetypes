package se.cambio.cds.generated;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.gdl2.datatypes.DvText;
import org.gdl2.runtime.DataInstance;

@Data
public final class Goal {
  private DvText name;

  public static Goal fromSingleDataInstance(DataInstance dataInstance) {
    Goal goal = new Goal();
    goal.setName(dataInstance.getDvText("/data[at0001]/items[at0002]"));
    return goal;
  }

  public static List<Goal> fromDataInstances(List<DataInstance> dataInstances) {
    List<Goal> list = new ArrayList<>();
    List<DataInstance> selectedDataInstances = fetch("openEHR-EHR-EVALUATION.goal.v1", dataInstances);
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
