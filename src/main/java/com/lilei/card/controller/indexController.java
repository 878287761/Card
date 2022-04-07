package com.lilei.card.controller;

import com.lilei.card.service.DownCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @Autowired
    private DownCountService downCountService;

    @RequestMapping("/")
    public String toIndex(){
        int conut = downCountService.GetDownCount();
        System.out.println("下载次数为： "+conut);
        return "index";
    }
}
