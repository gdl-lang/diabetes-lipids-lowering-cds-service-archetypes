package se.cambio.cds.generated;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.gdl2.runtime.DataInstance;

@Data
public final class CdsResponse {
  @NotNull
  private List<Request> requests;

  @NotNull
  private List<Goal> goals;

  @NotNull
  private List<MedicationRequest> medicationRequests;

  public static CdsResponse fromSingleDataInstance(DataInstance dataInstance) {
    CdsResponse cdsResponse = new CdsResponse();
    return cdsResponse;
  }

  public static List<CdsResponse> fromDataInstances(List<DataInstance> dataInstances) {
    List<CdsResponse> list = new ArrayList<>();
    List<DataInstance> selectedDataInstances = fetch(null, dataInstances);
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

  public static CdsResponse buildCdsResponse(List<DataInstance> dataInstances) {
    CdsResponse cdsResponse = new CdsResponse();
    cdsResponse.setRequests(Request.fromDataInstances(dataInstances));
    cdsResponse.setGoals(Goal.fromDataInstances(dataInstances));
    cdsResponse.setMedicationRequests(MedicationRequest.fromDataInstances(dataInstances));
    return cdsResponse;
  }
}
