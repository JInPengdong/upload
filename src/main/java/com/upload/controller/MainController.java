package com.upload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    private final static Logger logger= LoggerFactory.getLogger("Main");

    @RequestMapping("index")
    public String index(Model model){

        return "index";
    }

}
