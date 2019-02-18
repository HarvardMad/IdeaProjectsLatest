package com.java.rest.shop.api;


import com.java.rest.shop.model.StreetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AddressController {


    @Autowired
    RestTemplate restTemplate;
    public static final String POSTCODE_REGEX = "^[A-Z]{1,2}[0-9]{1,2}[A-Z]?s[0-9][A-Z][A-Z]$";
    public static final String POSTCODE = "postcode";
    public static final String ENDPOINT = "http://ws.postcoder.com/pcw/PCWRQ-PF494-MZRMZ-PSDY7/address/uk/";

    @GetMapping(value = "/search/{postcode}")
    public ResponseEntity<List<StreetAddress>> getAddress(@PathVariable(POSTCODE) String postCode) {


            postCode = sanitisePostCode(postCode);
            String endPointWithSearchCriteria = ENDPOINT.trim().concat(postCode);
            ResponseEntity<List<StreetAddress>>
                    addressResponse = restTemplate.exchange(endPointWithSearchCriteria, HttpMethod.GET, null, new ParameterizedTypeReference<List<StreetAddress>>() {
            });
            List<StreetAddress> streetAddressList = addressResponse.getBody();

            return new ResponseEntity<>(streetAddressList, HttpStatus.OK);

    }

    private String sanitisePostCode(String postCode) {
        postCode = org.apache.commons.lang.StringUtils.trim(postCode);
        return postCode;
    }

   /* private boolean validatePostCode(String pc) {
        String regex = POSTCODE_REGEX;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pc);
        return matcher.matches();
    }*/



}

