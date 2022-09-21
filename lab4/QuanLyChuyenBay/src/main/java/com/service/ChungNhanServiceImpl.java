package com.service;

import com.Controller.ChuyenBayController;
import com.entity.ChungNhan;
import com.entity.ChuyenBay;
import com.repository.ChungNhanRepository;
import com.repository.ChuyenBayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class ChungNhanServiceImpl implements ChungNhanService {
    @Autowired
    private ChungNhanRepository chungNhanRepository;

    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);

    @Override
    public void insertChungNhans(List<ChungNhan> dsChungNhan) {
        chungNhanRepository.saveAll(dsChungNhan);
    }

}
