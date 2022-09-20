package com.service;

import com.Controller.ChuyenBayController;
import com.entity.ChuyenBay;
import com.repository.ChuyenBayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);

    @Override
    public List<ChuyenBay> getChuyenBayDen(String maGaDen) {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByGaDen(maGaDen);
        logger.info("chuyen bay server impl - getChuyenBayDiDatLat: "+ chuyenbays.size());
        return chuyenbays;
    }

    @Override
    public List<ChuyenBay> getAllByDoDaiGreaterThan() {
        int km = 10000;
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByDoDaiGreaterThan(km);
        logger.info("chuyen bay server impl - getChuyenBayLonHon10kkm: "+ chuyenbays.size());
        return chuyenbays;
    }

    @Override
    public List<ChuyenBay> findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to) {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(from, to);
        return chuyenbays;
    }

    @Override
    public List<ChuyenBay> findAllByGaDiAndGaDen(String gaDi, String gaDen) {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByGaDiAndGaDen(gaDi, gaDen);
        return chuyenbays;
    }

    @Override
    public int countChuyenBayByGaDi(String gaDi) {
        return chuyenBayRepository.countChuyenBayByGaDi(gaDi);
    }

    @Override
    public List<ChuyenBay> findChuyenBayByTenMayBayAnd(String tenMB) {
        return chuyenBayRepository.findChuyenBayByTenMayBayAnd(tenMB);
    }
}
