package com.Controller;

import com.entity.ChuyenBay;
import com.server.ChuyenBayService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/chuyen-bay")
public class ChuyenBayController {
    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);
    @Autowired
    private ChuyenBayService chuyenBayService;

    // cau 1
    // [GET] /chuyen-bay/di-da-lat
    @GetMapping("/di-da-lat")
    public List<ChuyenBay> getChuyenBayDiDaLat() {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayDiDatLat();
        logger.info("controller - getChuyenBayDiDaLat:" + dsChuyenBay.size());

        return dsChuyenBay;
    }

    // cau 2
    // // [GET] /chuyen-bay/lon-hon-10kkm
    @GetMapping("/lon-hon-10kkm")
    public List<ChuyenBay> getChuyenBayTamBayLonHon10kkm() {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getAllByDoDaiGreaterThan();
//        logger.info("controller - getChuyenBayTamLonHon10kkm:" + dsChuyenBay.size());
        return dsChuyenBay;
    }

    // cau 4
    // [GET] /chuyen-bay/do-dai-duong-bay?tu=?&den=?
    @GetMapping("/do-dai-duong-bay")
    public List<ChuyenBay> getChuyenBayCoDoDaiDuongBayTuADenB(@RequestParam(name = "tu", required = false, defaultValue = "0") Integer tu,
                                        @RequestParam(value = "den", required = false, defaultValue = "10000") Integer den) {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(tu, den);
//        logger.info("controller - getChuyenBayCoDoDaiDuongBayTuADenB:" + dsChuyenBay.size());
        return dsChuyenBay;
    }
}
