package com.java.rest.shop.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LalinPethiyagoda on 28/10/2017.
 */
@RestController
public class TestController {
@RequestMapping(value="/getData", method = RequestMethod.GET)
    public ResponseEntity<String> getFeedback() {
        return new ResponseEntity<>("hello  foobar", HttpStatus.OK);
    }

}