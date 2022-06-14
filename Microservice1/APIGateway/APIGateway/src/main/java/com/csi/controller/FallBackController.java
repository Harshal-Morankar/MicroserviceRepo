package com.csi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/departmentfallback")
    public String departmentFallBack(){
        return "Department Service is down, Please Wait, Retrying again!!!!!!!!!!!";
    }

    @GetMapping("/employeefallback")
    public String employeeFallBack(){
        return "Employee Service is down, Please Wait , Retrying again!!!!!!!!!!!";
    }
}
