package com.service;

import com.Controller.ChuyenBayController;
import com.entity.ChuyenBay;
import com.repository.ChuyenBayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChuyenBayServiceTest {

    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);

    @Test
    void getChuyenBayDen() {
        String maGaDen = "DAD";
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByGaDen(maGaDen);
        chuyenbays.forEach(item -> {
            logger.info("data: " + item);
        });
    }

    @Test
    void getAllByDoDaiGreaterThan() {
        int km = 10000;
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByDoDaiGreaterThan(km);
        chuyenbays.forEach(item -> {
            logger.info("data: " + item);
        });
    }

    @Test
    void getAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual() {
        int from = 8000;
        int to = 10000;
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(from, to);
        chuyenbays.forEach(item -> {
            logger.info("data: " + item);
        });
    }

    @Test
    void getChuyenByGaDiAndGaDen() {
        String gaDi = "SGN";
        String gaDen = "BMV";
        List<ChuyenBay> dsChuyenBay = chuyenBayRepository.findAllByGaDiAndGaDen(gaDi, gaDen);
        dsChuyenBay.forEach(item -> {
            logger.info("data: " + item);
        });
    }

    @Test
    @Disabled
    void getChuyenByGaDiAndGaDenVaTroVe() {
    }

    @Test
    @Disabled
    void countChuyenBayByGaDi() {
    }

    @Test
    @Disabled
    void getChuyenBayByTamBayAndLoaiMayBay() {
    }

    @Test
    @Disabled
    void getTotalChiPhiTraChoPhiCongByGaDi() {
    }

    @Test
    @Disabled
    void getChuyenBayByGioDi() {
    }

    @Test
    @Disabled
    void countChuyenBayByGioDiAndGaDi() {
    }

    @Test
    @Disabled
    void getChuyenBayByTamBayAndLoaiMayBayLike() {
    }

    @Test
    @Disabled
    void insertChuyenBays() {
    }
}