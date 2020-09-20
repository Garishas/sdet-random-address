package mc.sdet.codetest.service

import mc.sdet.codetest.controller.RandomAddressController
import mc.sdet.codetest.model.RandomAddressModel
import mc.sdet.codetest.util.AddressParsingUtil
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest(classes = [AddressParsingUtil])
class RandomAddressServiceTest extends Specification {

    Void "Test GetRandomAddress Success"() {
        given: "Initialize Service"
            RandomAddressService randomAddressService = RandomAddressService.newInstance()

        when : "Call the method"
        RandomAddressModel randomAddressModel = randomAddressService.getRandomAddress()

        then: "Verify if all responses are ok ? "
            randomAddressModel != null
    }
}
