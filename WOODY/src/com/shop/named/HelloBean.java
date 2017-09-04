package com.shop.named;

/**
 * Created by LalinPethiyagoda on 21/07/2015.
 */

import javax.inject.Named;

@Named
public class HelloBean {
    public String getMessage(){
        return "hey there charlie bear";
    }
}
