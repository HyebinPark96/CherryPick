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
        cafeInfoService.updateNullColumnsWithRandomValues();
        return "Update completed";
    }

    @GetMapping("/import-cafe-logos")
    public String importCafeLogos() {
        cafeInfoService.updateNullCImageColumns();
        return "Update completed";
    }

    @GetMapping("/import-cafe-seats")
    public String importCafeSeats() {
        cafeInfoService.updateNullSeatsColumns();
        return "Update completed";
    }

    @GetMapping("/import-cafe-time")
    public String importCafeTime() {
        cafeInfoService.updateTimes();
        return "Update completed";
    }

    @GetMapping("/import-cafe-bid")
    public String importCafeBid() {
        cafeInfoService.updateNullBid();
        return "Update completed";
    }

    @GetMapping("/import-cafe-tags")
    public String importCafeTags() {
        cafeInfoService.updateNullCtag();
        return "Update completed";
    }

}
