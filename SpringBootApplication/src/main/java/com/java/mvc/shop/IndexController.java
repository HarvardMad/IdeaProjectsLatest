package com.java.mvc.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LalinPethiyagoda on 21/11/2017.
 */
@Controller
public class IndexController {

    @RequestMapping("/greeting")
    public ModelAndView getIndex(){
        return new ModelAndView("welcome");
    }
}
