package mc.sdet.codetest.controller

import mc.sdet.codetest.model.RandomAddressModel
import mc.sdet.codetest.service.RandomAddressService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest(classes = [RandomAddressController,RandomAddressService])
class RandomAccessControllerTest extends Specification {

    @SpringBean
    RandomAddressService randomAddressService = Mock()

    @Autowired
    RandomAddressController randomAddressController

    Void testControllerForSuccess() {
        given: "Initialize controller"
            randomAddressService.getRandomAddress() >> mockRandomAddress()

        when : "Call the method"
        ResponseEntity responseEntity = randomAddressController.getRandomAddress()

        then: "Verify if all responses are ok ? "
            responseEntity.statusCode == HttpStatus.OK
            responseEntity.body.country == 'US'
    }

    private mockRandomAddress() {
        return RandomAddressModel.builder()
                .country('US')
                .build()
    }
}
