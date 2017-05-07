package se.cambio.cds.generated;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.gdl2.datatypes.DvText;
import org.gdl2.runtime.DataInstance;

@Data
public final class Request {
  private DvText service;

  private DvText Description;

  public static Request fromSingleDataInstance(DataInstance dataInstance) {
    Request request = new Request();
    request.setService(dataInstance.getDvText("/activities[at0001]/description[at0009]/items[at0121]"));
    request.setDescription(dataInstance.getDvText("/activities[at0001]/description[at0009]/items[at0135]"));
    return request;
  }

  public static List<Request> fromDataInstances(List<DataInstance> dataInstances) {
    List<Request> list = new ArrayList<>();
    List<DataInstance> selectedDataInstances = fetch("openEHR-EHR-INSTRUCTION.request.v0", dataInstances);
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
