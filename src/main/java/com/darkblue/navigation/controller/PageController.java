package com.darkblue.navigation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
