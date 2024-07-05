package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class CafeInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Random random = new Random();

    // 가능한 키워드 리스트
    private static final List<String> KEYWORDS = Arrays.asList(
            "#카공추천", "#분위기좋은", "#브런치", "#고양이", "#강아지", "#마카롱", "#원두맛집",
            "#데이트추천", "#신상카페", "#소셜핫플", "#넓은좌석", "#디저트맛집", "#크로와상", "#소금빵",
            "#앙버터", "#포토존", "#북카페", "#플랜테리어", "#감성카페", "#라떼맛집", "#타르트",
            "#조용한", "#요즘핫플", "#빙수맛집", "#역근처", "#뷰맛집", "#블루리본", "샌드위치", "#수플레", "#파르페");

    public void updateNullColumnsWithRandomValues() {
        updateColumnWithRandomValues("pet");
        updateColumnWithRandomValues("kids");
        updateColumnWithRandomValues("smoke");
        updateColumnWithRandomValues("group");
    }
    private void updateColumnWithRandomValues(String columnName) {
        // 해당 컬럼이 NULL인 모든 레코드의 ID 가져오기
        List<Long> ids = jdbcTemplate.queryForList("SELECT cno FROM `cafeInfo` WHERE `" + columnName + "` IS NULL", Long.class);

        // 각 레코드에 대해 해당 컬럼에 랜덤값 (0 또는 1) 업데이트
        for (Long id : ids) {
            int randomValue = random.nextInt(2); // 0 또는 1
            jdbcTemplate.update("UPDATE `cafeInfo` SET `" + columnName + "` = ? WHERE cno = ?", randomValue, id);
        }
    }

    public void updateNullCImageColumns() {
        List<Long> ids = jdbcTemplate.queryForList("SELECT cno FROM cafeInfo WHERE cimage IS NULL", Long.class);

        for (Long id : ids) {
            String randomImage = getRandomImageFilename();
            jdbcTemplate.update("UPDATE cafeInfo SET cimage = ? WHERE cno = ?", randomImage, id);
        }
    }

    private String getRandomImageFilename() {
        int randomNumber = random.nextInt(17) + 1; // Random number between 1 and 17
        return "logo" + randomNumber + ".jpg";
    }


    public void updateNullSeatsColumns() {
        List<Long> ids = jdbcTemplate.queryForList("SELECT cno FROM cafeInfo WHERE seats IS NULL", Long.class);

        for (Long id : ids) {
            int randomValue = getRandomValidValue();
            jdbcTemplate.update("UPDATE cafeInfo SET seats = ? WHERE cno = ?", randomValue, id);
        }
    }

    private int getRandomValidValue() {
        int randomValue;
        do {
            randomValue = random.nextInt(91) + 10; // Random number between 10 and 100
        } while (randomValue % 2 != 0 && randomValue % 5 != 0); // Ensure it's a multiple of 2 or 5
        return randomValue;
    }

    @PostConstruct
    public void updateTimes() {
        updateCOpenAndCCloseTimes();
    }

    // copen과 cclose에 랜덤 시간값 업데이트
    private void updateCOpenAndCCloseTimes() {
        // 해당 컬럼이 NULL인 모든 레코드의 ID 가져오기
        List<Long> ids = jdbcTemplate.queryForList("SELECT cno FROM cafeInfo WHERE copen IS NOT NULL", Long.class);

        // 각 레코드에 대해 copen과 cclose에 랜덤 시간값 업데이트
        for (Long id : ids) {
            LocalTime randomCOpenTime = generateRandomCOpenTime();
            LocalTime randomCCloseTime = generateRandomCCloseTime(randomCOpenTime);

            jdbcTemplate.update("UPDATE cafeInfo SET copen = ?, cclose = ? WHERE cno = ?", randomCOpenTime.toString(), randomCCloseTime.toString(), id);
        }
    }

    // copen에 랜덤 시간값 생성 (08:00:00 ~ 14:00:00 범위)
    private LocalTime generateRandomCOpenTime() {
        int hour = ThreadLocalRandom.current().nextInt(8, 15); // 8부터 14까지의 시간
        int minute = ThreadLocalRandom.current().nextInt(0, 2) * 30; // 0 또는 1 * 30 (0분 또는 30분)
        return LocalTime.of(hour, minute);
    }

    // cclose에 랜덤 시간값 생성 (copen 시간에서 6~12시간 뒤의 정각이나 30분으로 끝나는 값)
    private LocalTime generateRandomCCloseTime(LocalTime copen) {
        int hoursToAdd = ThreadLocalRandom.current().nextInt(6, 13); // 6부터 12까지의 시간
        LocalTime cclose = copen.plusHours(hoursToAdd);

        // cclose를 정각이나 30분으로 조정
        if (cclose.getMinute() >= 30) {
            cclose = cclose.withMinute(30).withSecond(0);
        } else {
            cclose = cclose.withMinute(0).withSecond(0);
        }

        return cclose;
}

    @PostConstruct
    public void updateNullBid() {
        updateBidColumn();
    }

    private void updateBidColumn() {
        // bizMember 테이블에서 bid 값이 있는 레코드들 가져오기
        List<String> bidValues = jdbcTemplate.queryForList("SELECT bid FROM bizMember", String.class);

        // cafeInfo 테이블에서 bid 값이 NULL인 레코드들 가져오기
        List<Long> ids = jdbcTemplate.queryForList("SELECT cno FROM cafeInfo WHERE bid IS NULL", Long.class);

        // 각 레코드에 대해 bizMember 테이블에서 랜덤으로 bid 값을 선택하여 업데이트
        for (Long id : ids) {
            int randomIndex = ThreadLocalRandom.current().nextInt(bidValues.size());
            String randomBid = bidValues.get(randomIndex);
            jdbcTemplate.update("UPDATE cafeInfo SET bid = ? WHERE cno = ?", randomBid, id);
        }
    }


    @PostConstruct
    public void updateNullCtag() {
        updateCtagColumn();
    }


    private void updateCtagColumn() {
        // cafeInfo 테이블에서 ctag 값이 NULL인 레코드들 가져오기
        List<Long> ids = jdbcTemplate.queryForList("SELECT cno FROM cafeInfo WHERE ctag IS NULL", Long.class);

        for (Long id : ids) {
            // 랜덤하게 최대 세 개의 키워드 선택
            List<String> selectedKeywords = selectRandomKeywords();

            // ctag 업데이트
            jdbcTemplate.update("UPDATE cafeInfo SET ctag = ? WHERE cno = ?", String.join(" ", selectedKeywords), id);
        }
    }

    private List<String> selectRandomKeywords() {


        // 키워드 리스트를 복사하여 셔플
        List<String> shuffledKeywords = new ArrayList<>(KEYWORDS);
        Collections.shuffle(shuffledKeywords);

        // 최대 세 개의 키워드 선택
        int numKeywords = ThreadLocalRandom.current().nextInt(1, 4); // 1에서 3 사이의 랜덤 값
        List<String> selectedKeywords = shuffledKeywords.subList(0, Math.min(numKeywords, shuffledKeywords.size()));

        return selectedKeywords;
    }
}

