package com.Controller;

import com.entity.ChuyenBay;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.service.ChuyenBayService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/chuyen-bay")
public class ChuyenBayController {
    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);
    private static Gson gson = new Gson();
    @Autowired
    private ChuyenBayService chuyenBayService;

    // cau 1
    // [GET] /chuyen-bay/di-da-lat
    @GetMapping("/di-da-lat")
    public String getChuyenBayDiDaLat() {
        String maGaDen = "DAD";
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayDen(maGaDen);
//        logger.info("controller - getChuyenBayDiDaLat:" + dsChuyenBay.size());

        Map<String, List<ChuyenBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsChuyenBay);
        return gson.toJson(res);
    }

    // cau 2
    // // [GET] /chuyen-bay/lon-hon-10kkm
    @GetMapping("/lon-hon-10kkm")
    public String getChuyenBayTamBayLonHon10kkm() {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getAllByDoDaiGreaterThan();
//        logger.info("controller - getChuyenBayTamLonHon10kkm:" + dsChuyenBay.size());

        Map<String, List<ChuyenBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsChuyenBay);
        return gson.toJson(res);
    }

    // cau 4
    // [GET] /chuyen-bay/do-dai-duong-bay?tu=?&den=?
    @GetMapping("/do-dai-duong-bay")
    public String getChuyenBayCoDoDaiDuongBayTuADenB(@RequestParam(name = "tu", required = false, defaultValue = "0") Integer tu,
                                                              @RequestParam(value = "den", required = false, defaultValue = "10000") Integer den) {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(tu, den);
//        logger.info("controller - getChuyenBayCoDoDaiDuongBayTuADenB:" + dsChuyenBay.size());

        Map<String, List<ChuyenBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsChuyenBay);
        return gson.toJson(res);
    }

    // cau 5
    // [GET] /chuyen-bay/sai-gon-di-buon-me-thuoc
    @GetMapping("/sai-gon-di-buon-me-thuoc")
    public String getChuyenBayTuSaiGonDiBMT() {
        String gaDi = "SGN";
        String gaDen = "BMV";
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenByGaDiAndGaDen(gaDi, gaDen);

        Map<String, List<ChuyenBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsChuyenBay);
        return gson.toJson(res);
    }


    // cau 18
    // [GET] /chuyen-bay/so-chuyen/{gaDi}

    // cau 6
    // [GET] /chuyen-bay/so-chuyen/sai-gon
    // [GET] /chuyen-bay/so-chuyen/{gaDi}

    // mẫu
    // [GET] /chuyen-bay/so-chuyen/{gaDi}
    @GetMapping("/so-chuyen/{gaDi}")
    public String getSoChuyenBayTuGaDi(@PathVariable String gaDi) {
        if (gaDi.equals("sai-gon")) {
            gaDi = "SGN";
        }
        int count = chuyenBayService.countChuyenBayByGaDi(gaDi);

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("gaDi", gaDi);
        res.put("soChuyenBay", count);
        String json = gson.toJson(res);
        return json;
    }

    // cau 14
    // [GET] /chuyen-bay/thuc-hien-chuyen-bay/{tenMB}
    @GetMapping("/thuc-hien-chuyen-bay/{tenMB}")
    public String getChuyenBayByTenMayBay(@PathVariable String tenMB) {
        tenMB = tenMB.replace("-", " ");
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayByTamBayAndLoaiMayBay(tenMB);

        Map<String, List<ChuyenBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsChuyenBay);
        return gson.toJson(res);
    }

    // cau 17
    // [GET] /chuyen-bay/chuyen-bay-va-tro-ve/{gaDi}/{gaDen}
    @GetMapping("/chuyen-bay-va-tro-ve/{gaDi}/{gaDen}")
    public String getChuyenBayTuADenB(@PathVariable String gaDi, @PathVariable String gaDen) {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenByGaDiAndGaDenVaTroVe(gaDi, gaDen);

        Map<String, List<ChuyenBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsChuyenBay);

        return gson.toJson(res);
    }

    // cau 19
    // [GET] /chuyen-bay/tong-chi-phi-tra-cho-phi-cong/{gaDi}/
    @GetMapping("/tong-chi-phi-tra-cho-phi-cong/{gaDi}")
    public String getChuyenBayTuADenBE(@PathVariable String gaDi) {
        Double chiPhi = chuyenBayService.getTotalChiPhiTraChoPhiCongByGaDi(gaDi);

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("tong_chi_phi", chiPhi);
        String json = gson.toJson(res);
        return json;
    }

    // cau 20
    // [GET] /chuyen-bay/truoc-gio/{gioDi}/
    @GetMapping("/truoc-gio/{gioDi}")
    public String getChuyenBayTruocxH(@PathVariable String gioDi) {
        if (gioDi.equals("h") || gioDi.equals(" ") || gioDi.equals("m") || gioDi.equals("s")) {
            gioDi.replace("[hm]", ":").replace("s", "");
        }
        Time time = Time.valueOf(gioDi);
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayByGioDi(time);


        Map<String, List<ChuyenBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsChuyenBay);
        return gson.toJson(res);
    }

    // cau 21
    // [GET] /chuyen-bay/so-chuyen-bay-truoc-12-gio/{gaDi}/
    @GetMapping("/so-chuyen-bay-truoc-12-gio/{gaDi}")
    public String getSoChuyenBayTruoc12HByGaDi(@PathVariable String gaDi) {
        Time gioDi = Time.valueOf("12:00:00");
        int soChuyenBay = chuyenBayService.countChuyenBayByGioDiAndGaDi(gioDi, gaDi);


        Map<String, Object> res = new HashMap<>();
        res.put("so_chuyen_bay", soChuyenBay);
        res.put("gaDi", gaDi);

        String json = gson.toJson(res);
        return json;
    }

    // cau 28
    // [GET] /chuyen-bay/chuyen-bay-bang-loai-may-bay-boeing
    @GetMapping("/chuyen-bay-bang-loai-may-bay-boeing")
    public String getChuyenBayByLoaiMayBayBoeing() {
        String tenMB = "boeing";
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayByTamBayAndLoaiMayBayLike(tenMB);


        Map<String, List<ChuyenBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsChuyenBay);

        String json = gson.toJson(res);
        return json;
    }


}
