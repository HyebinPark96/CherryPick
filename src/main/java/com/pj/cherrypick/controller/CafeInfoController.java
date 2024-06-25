package com.pj.cherrypick.controller;

import com.pj.cherrypick.service.CafeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafeInfoController {

    @Autowired
    private CafeInfoService cafeInfoService;

    @GetMapping("/update-random-values")
    public String updateRandomValues() {
        cafeInfoService.updateNullColumnWithRandomValue();
        return "Update completed";
    }

}
