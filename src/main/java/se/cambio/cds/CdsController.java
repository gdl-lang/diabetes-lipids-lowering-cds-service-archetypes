package se.cambio.cds;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.cambio.cds.generated.CdsRequest;
import se.cambio.cds.generated.CdsResponse;

@RestController
@RequestMapping("/")
public class CdsController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CdsResponse cdsService(@RequestBody CdsRequest cdsRequest) throws Exception {
        return new CdsService().process(cdsRequest);
    }
}