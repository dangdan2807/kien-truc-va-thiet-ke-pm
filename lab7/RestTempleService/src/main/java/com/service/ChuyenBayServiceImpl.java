package com.service;

import com.Controller.ChuyenBayController;
import com.entity.ChuyenBay;
import com.repository.ChuyenBayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);

    @Override
    public List<ChuyenBay> getChuyenBay() {
        List<ChuyenBay> chuyenbays = chuyenBayRepository.findAll();
        return chuyenbays;
    }

    @Override
    public ChuyenBay getChuyenBayById(String maCB) {
        Optional<ChuyenBay> chuyenBay = chuyenBayRepository.findById(maCB);
        return chuyenBay.isEmpty() ? null : chuyenBay.get();
    }

    @Override
    public void saveChuyenBay(ChuyenBay chuyenBay) {
        chuyenBayRepository.saveAndFlush(chuyenBay);
    }

    @Override
    public void deleteChuyenBay(String maCB) {
        chuyenBayRepository.deleteById(maCB);
    }

    @Override
    public void insertChuyenBay(ChuyenBay chuyenBay) {
        chuyenBayRepository.saveAndFlush(chuyenBay);
    }

}
