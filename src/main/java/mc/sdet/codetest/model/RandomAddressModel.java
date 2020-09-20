package mc.sdet.codetest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RandomAddressModel {

    private String house;
    private String street;
    private String postalCode;
    private String city;
    private String county;
    private String state;
    private String stateCode;
    private String country;
    private String countryCode;
}
