package com.api.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/intro")
public class WebController {

    @GetMapping()
    public String index() {
        return "index-intro";
    }

    
}
