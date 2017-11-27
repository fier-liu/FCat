package com.xfdmao.fcat.gate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiangfei on 2017/10/16.
 */
@RestController
public class PublicController {

    @RequestMapping("/")
    public String login(){

        return "FCat Gate success";
    }
}
