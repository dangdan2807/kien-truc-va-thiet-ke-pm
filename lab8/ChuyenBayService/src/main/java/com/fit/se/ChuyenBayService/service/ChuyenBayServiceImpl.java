package com.fit.se.ChuyenBayService.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.se.ChuyenBayService.repository.ChuyenBayRepository;
import com.fit.se.ChuyenBayService.model.ChuyenBay;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

//    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);

    @Override
    public List<ChuyenBay> getChuyenBayDen(String maGaDen) {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByGaDen(maGaDen);
//        logger.info("chuyen bay server impl - getChuyenBayDiDatLat: " + chuyenbays.size());
        return chuyenbays;
    }

    @Override
    public List<ChuyenBay> getAllByDoDaiGreaterThan() {
        int km = 10000;
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByDoDaiGreaterThan(km);
//        logger.info("chuyen bay server impl - getChuyenBayLonHon10kkm: " + chuyenbays.size());
        return chuyenbays;
    }

    @Override
    public List<ChuyenBay> getAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to) {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(from, to);
        return chuyenbays;
    }

    @Override
    public List<ChuyenBay> getChuyenByGaDiAndGaDen(String gaDi, String gaDen) {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByGaDiAndGaDen(gaDi, gaDen);
        return chuyenbays;
    }

    @Override
    public List<ChuyenBay> getChuyenByGaDiAndGaDenVaTroVe(String gaDi, String gaDen) {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAllByGaDiAndGaDenVaTroVe(gaDi, gaDen);
        return chuyenbays;
    }

    @Override
    public int countChuyenBayByGaDi(String gaDi) {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findChuyenBayByGaDi(gaDi);
        return chuyenbays.size();
    }

//    @Override
//    public List<ChuyenBay> getChuyenBayByTamBayAndLoaiMayBay(String tenMB) {
//        return chuyenBayRepository.findChuyenBayByTamBayAndLoaiMayBay(tenMB);
//    }

    @Override
    public Double getTotalChiPhiTraChoPhiCongByGaDi(String gaDi) {
        List<ChuyenBay> dsChuyenBay = chuyenBayRepository.findChuyenBayByGaDi(gaDi);
        Double totalChiPhi = 0.0;
        for (ChuyenBay item : dsChuyenBay) {
            totalChiPhi += (item.getChiPhi() * 1.0);
        }

        return totalChiPhi;
    }

    @Override
    public List<ChuyenBay> getChuyenBayByGioDi(Date gioDi) {
        return chuyenBayRepository.findChuyenBayByGioDiLessThan(gioDi);
    }

    @Override
    public int countChuyenBayByGioDiAndGaDi(Date gioDi, String gaDi) {
        List<ChuyenBay> dsChuyenBay = chuyenBayRepository.findChuyenBayByGioDiLessThanAndAndGaDi(gioDi, gaDi);
        return dsChuyenBay.size();
    }

//    @Override
//    public List<ChuyenBay> getChuyenBayByTamBayAndLoaiMayBayLike(String tenMB) {
//        List<ChuyenBay> dsChuyenBay = chuyenBayRepository.findChuyenBayThucHienTatCaLoaiMayBayLike(tenMB);
//        return dsChuyenBay;
//    }

    @Override
    public void insertChuyenBays(List<ChuyenBay> dsChuyenBay) {
        chuyenBayRepository.saveAll(dsChuyenBay);
    }

}