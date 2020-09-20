package mc.sdet.codetest.service;

import mc.sdet.codetest.model.RandomAddressModel;
import org.springframework.stereotype.Service;

import static mc.sdet.codetest.util.AddressParsingUtil.addressList;

@Service
public class RandomAddressService {

    /**
     * Reads a random address and return.
     * @return
     */
    public RandomAddressModel getRandomAddress() {
        int randomAddress = (int) (10.0 * Math.random()) % 10;
        return addressList.get(randomAddress);
    }
}
