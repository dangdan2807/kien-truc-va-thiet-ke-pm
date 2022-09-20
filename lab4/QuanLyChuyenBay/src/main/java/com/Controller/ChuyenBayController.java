package com.Controller;

import com.entity.ChuyenBay;
import com.entity.MayBay;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.service.ChuyenBayService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
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
        String maGaDen = "DAD";
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayDen(maGaDen);
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

    // cau 5
    // [GET] /chuyen-bay/sai-gon-di-buon-me-thuoc
    @GetMapping("/sai-gon-di-buon-me-thuoc")
    public List<ChuyenBay> getChuyenBayTuSaiGonDiBMT() {
        String gaDi = "SGN";
        String gaDen = "BMV";
        List<ChuyenBay> dsChuyenBay = chuyenBayService.findAllByGaDiAndGaDen(gaDi, gaDen);
        return dsChuyenBay;
    }

    // cau 6
    // [GET] /chuyen-bay/so-chuyen/sai-gon
    @GetMapping("/so-chuyen/sai-gon")
    public String getSoChuyenBayTuSaiGonDi() {
        String gaDi = "SGN";
        int count = chuyenBayService.countChuyenBayByGaDi(gaDi);
        return "{ \"so_chuyen_bay\": " + count + "}";
    }

    // cau 14
    // [GET] /chuyen-bay/thuc-hien-chuyen-bay/{tenMB}
    @GetMapping("/thuc-hien-chuyen-bay/{tenMB}")
    public String getChuyenBayByTenMayBay(@PathVariable String tenMB) {
        tenMB = tenMB.replace("-", " ");
        List<ChuyenBay> dsChuyenBay = chuyenBayService.findChuyenBayByTenMayBayAnd(tenMB);
        Gson gson = new Gson();
        Type chuyenBayType = new TypeToken<List<ChuyenBay>>(){}.getType();
        String json = gson.toJson(dsChuyenBay, chuyenBayType);
        return "{\"danh_sach_chuyen_bay\":" + json + "}";
    }
}
