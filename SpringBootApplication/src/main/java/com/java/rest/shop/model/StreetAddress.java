package com.java.rest.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.rest.shop.common.JsonFieldName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StreetAddress {

    @JsonProperty(JsonFieldName.NUMBER)
    private String number;
   /* @JsonProperty(JsonFieldName.POSTCODE)
    private String postCode;*/
    @JsonProperty(JsonFieldName.STREET)
    private String street;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public StreetAddress() {

    }


}
