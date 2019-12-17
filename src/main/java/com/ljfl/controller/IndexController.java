package com.ljfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 20:22
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public String home() {
        return "index/index";
    }

    @RequestMapping("index")
    public String index() {
        return "index/index";
    }
}
