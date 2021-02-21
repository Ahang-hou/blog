package com.ahang.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ahang
 * @date 2021/2/21 13:03
 */
@Controller
public class AboutShowController {
    @GetMapping("/about")
    public String about() {

        return "about";
    }
}
