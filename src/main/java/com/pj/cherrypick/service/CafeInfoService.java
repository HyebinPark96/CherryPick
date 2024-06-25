package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CafeInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateNullColumnWithRandomValue() {

        Random r = new Random();

        List<Long> cids = jdbcTemplate.queryForList("SELECT cid FROM cafeInfo WHERE parking IS NULL", Long.class);

        for (Long cid : cids) {
            int randomeValue = r.nextInt(2); // 0 또는 1
            jdbcTemplate.update("UPDATE cafeInfo SET parking = ? WHERE cid = ?", randomeValue, cid);

        }
    }

}
