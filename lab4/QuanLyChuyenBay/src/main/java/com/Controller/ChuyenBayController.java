package com.Controller;

import com.entity.ChuyenBay;
import com.server.ChuyenBayService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/chuyen-bay")
public class ChuyenBayController {
    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);
    @Autowired
    private ChuyenBayService chuyenBayService;

    @GetMapping("/di-da-lat")
    public List<ChuyenBay> getChuyenBayDiDaLat() {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayDiDatLat();
        logger.info("controller - getChuyenBayDiDaLat:" + dsChuyenBay.size());

        return dsChuyenBay;
    }

    @GetMapping("/lon-hon-10kkm")
    public List<ChuyenBay> getChuyenBayTamLonHon10kkm() {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayLonHon10kkm();
        logger.info("controller - getChuyenBayTamLonHon10kkm:" + dsChuyenBay.size());
        return dsChuyenBay;
    }
}
