package se.cambio.cds;

import org.gdl2.Gdl2;
import org.gdl2.model.Guideline;
import org.gdl2.runtime.DataInstance;
import org.gdl2.runtime.Interpreter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import se.cambio.cds.generated.CdsRequest;
import se.cambio.cds.generated.CdsResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
class CdsService {
    private static final String GUIDELINES_PATH = "guidelines";
    private ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
    private List<Guideline> guidelines = new ArrayList<>();

    CdsService() throws IOException {
        loadGuidelines();
    }

    CdsResponse process(CdsRequest cdsRequest) throws IOException {
        List<DataInstance> input = cdsRequest.toDataInstances();
        Interpreter interpreter = new Interpreter();
        List<DataInstance> result = interpreter.executeGuidelines(this.guidelines, input);
        return CdsResponse.buildCdsResponse(result);
    }

    private void loadGuidelines() throws IOException {
        Resource[] resources = resourceResolver.getResources("classpath:" + GUIDELINES_PATH + "/*.json");
        for (Resource resource : resources) {
            try {
                String path = GUIDELINES_PATH + File.separator + resource.getFilename();
                InputStream inputStream = new ClassPathResource(path).getInputStream();
                String source = StreamUtils.copyToString(inputStream, Charset.forName("utf-8"));
                this.guidelines.add(Gdl2.fromGdl2(source));
            } catch (Exception exception) {
                System.out.println("Failed to read guideline file: " + exception.getMessage());
                exception.printStackTrace();
            }
        }
    }
}
