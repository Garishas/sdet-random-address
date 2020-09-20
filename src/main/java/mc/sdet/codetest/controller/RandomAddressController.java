package mc.sdet.codetest.controller;

import groovy.util.logging.Slf4j;
import mc.sdet.codetest.model.RandomAddressModel;
import mc.sdet.codetest.service.RandomAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

import static org.springframework.util.MimeTypeUtils.*;

@Slf4j
@RestController
public class RandomAddressController {
    private final String BASE_PATH = "/randomizer/address";

    @Autowired
    private RandomAddressService randomAddressService;

    @GetMapping(value = BASE_PATH, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RandomAddressModel> getRandomAddress() {
        return ResponseEntity.ok(randomAddressService.getRandomAddress());
    }
}
