package se.cambio.cds;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Value(value = "classpath:cds_request_expected_request_increased_statin_dose.json")
    private Resource inputRequestIncreasedDose;

    @Value(value = "classpath:cds_request_expected_continue_statin_treatment_annual_follow_up.json")
    private Resource inputRequestContinueTreatment;

    @Value(value = "classpath:cds_request_expected_request_qrisk2.json")
    private Resource inputRequestQrisk2;

    @Value(value = "classpath:cds_request_expected_request_low_dose_statin_treatment.json")
    private Resource inputRequestLowDoseStatin;

    @Value(value = "classpath:cds_request_expected_request_high_dose_statin_treatment.json")
    private Resource inputRequestHighDoseStatin;

    @Test()
    public void should_request_increased_dose() throws Exception {
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(read(inputRequestIncreasedDose))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.medicationRequests[0].genericName.value").value("Atorvastatin"))
                .andExpect(jsonPath("$.medicationRequests[0].dose.magnitude").value(80));
    }

    @Test()
    public void should_request_continue_treatment_follow_up() throws Exception {
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(read(inputRequestContinueTreatment))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.medicationRequests[0].genericName.value").value("Atorvastatin"))
                .andExpect(jsonPath("$.medicationRequests[0].dose.magnitude").value(20))
                .andExpect(jsonPath("$.requests[0].service.value").value("Appointment"));
    }

    @Test()
    public void should_request_start_high_dose() throws Exception {
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(read(inputRequestHighDoseStatin))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.medicationRequests[0].genericName.value").value("Atorvastatin"))
                .andExpect(jsonPath("$.medicationRequests[0].dose.magnitude").value(80));
    }

    @Test()
    public void should_request_qrisk() throws Exception {
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(read(inputRequestQrisk2))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.requests[0].service.value").value("QRISK2"))
                .andExpect(jsonPath("$.requests[0].description.value").value("Measure and evaluate QRISK2"));
    }

    @Test()
    public void should_request_low_dose_statin() throws Exception {
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(read(inputRequestLowDoseStatin))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.medicationRequests[0].genericName.value").value("Atorvastatin"))
                .andExpect(jsonPath("$.medicationRequests[0].dose.magnitude").value(20))
                .andExpect(jsonPath("$.requests[0].service.value").value("Appointment"))
                .andExpect(jsonPath("$.goals[0].name.value").value("Aim 40% reduction in non-HDL cholesterol"));
    }

    private String read(Resource resource) throws IOException {
        return StreamUtils.copyToString(resource.getInputStream(), Charset.forName("utf-8"));
    }
}
