package mc.sdet.codetest.util;

import lombok.extern.slf4j.Slf4j;
import mc.sdet.codetest.model.RandomAddressModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

@Slf4j
@Component
public final class AddressParsingUtil {

    public static ArrayList<RandomAddressModel> addressList = new ArrayList<>();

    @PostConstruct
    public void readFile() throws FileNotFoundException {
        String filepath = "/address.txt";
        try (InputStream inputStream = AddressParsingUtil.class.getResourceAsStream(filepath);
            Scanner sc = new Scanner(inputStream)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if( Objects.nonNull(line)) {
                    addressList.add(parseAddress(line));
                }
            }
        } catch (FileNotFoundException e) {
            log.error("Error while parsing file", e);
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses line
     * @param addressSet
     * @return
     */
    private RandomAddressModel parseAddress(String addressSet) {
        RandomAddressModel randomAddressModel = RandomAddressModel.builder().build();
        String[] arrAddressSet = addressSet.split("\\|");

        if (arrAddressSet.length == 9) {
            if ((arrAddressSet[0] != null) | (arrAddressSet[0] != "")) {
                randomAddressModel.setHouse(arrAddressSet[0]);
            }
            if ((arrAddressSet[1] != null) | (arrAddressSet[1] != "")) {
                randomAddressModel.setStreet(arrAddressSet[1]);
            }
            if ((arrAddressSet[2] != null) | (arrAddressSet[2] != "")) {
                randomAddressModel.setPostalCode(arrAddressSet[2]);
            }
            if ((arrAddressSet[3] != null) | (arrAddressSet[3] != "")) {
                randomAddressModel.setCity(arrAddressSet[3]);
            }
            if ((arrAddressSet[4] != null) | (arrAddressSet[4] != "")) {
                randomAddressModel.setCountry(arrAddressSet[4]);
            }
            if ((arrAddressSet[5] != null) | (arrAddressSet[5] != "")) {
                randomAddressModel.setState(arrAddressSet[5]);
            }
            if ((arrAddressSet[6] != null) | (arrAddressSet[6] != "")) {
                randomAddressModel.setStateCode(arrAddressSet[6]);
            }
            if ((arrAddressSet[7] != null) | (arrAddressSet[7] != "")) {
                randomAddressModel.setCountry(arrAddressSet[7]);
            }
            if ((arrAddressSet[8] != null) | (arrAddressSet[8] != "")) {
                randomAddressModel.setCountryCode(arrAddressSet[8]);
            }
        }
        return randomAddressModel;
    }
}
