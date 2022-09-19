package com.server;

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
    public List<ChuyenBay> getChuyenBayDiDatLat() {
        String maGaDen = "DAD";
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByGaDen(maGaDen);
        logger.info("server impl - getChuyenBayDiDatLat: "+ chuyenbays.size());
        return chuyenbays;
    }

    @Override
    public List<ChuyenBay> getChuyenBayLonHon10kkm() {
        int km = 10000;
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByDoDaiGreaterThan(km);
        logger.info("server impl - getChuyenBayLonHon10kkm: "+ chuyenbays.size());
        return chuyenbays;
    }
}
