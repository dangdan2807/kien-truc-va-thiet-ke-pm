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
        Gson gson = new Gson();
        Map<String, Object> req = new HashMap<String, Object>();
        req.put("gaDi", gaDi);
        req.put("soChuyenBay", count);
        String json = gson.toJson(req);
        return json;
    }

    // cau 14
    // [GET] /chuyen-bay/thuc-hien-chuyen-bay/{tenMB}
    @GetMapping("/thuc-hien-chuyen-bay/{tenMB}")
    public String getChuyenBayByTenMayBay(@PathVariable String tenMB) {
        tenMB = tenMB.replace("-", " ");
        List<ChuyenBay> dsChuyenBay = chuyenBayService.findChuyenBayByTenMayBayAnd(tenMB);
        Gson gson = new Gson();
        Type chuyenBayType = new TypeToken<List<ChuyenBay>>() {
        }.getType();
        String json = gson.toJson(dsChuyenBay, chuyenBayType);
        return "{\"danh_sach_chuyen_bay\":" + json + "}";
    }

    // cau 17
    // [GET] /chuyen-bay/{gaDi}/{gaDen}
    @GetMapping("/{gaDi}/{gaDen}")
    public String getChuyenBayTuADenB(@PathVariable String gaDi, @PathVariable String gaDen) {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.findAllByGaDiAndGaDen(gaDi, gaDen);
        Gson gson = new Gson();
        Type chuyenBayType = new TypeToken<List<ChuyenBay>>() {
        }.getType();
        String json = gson.toJson(dsChuyenBay, chuyenBayType);
        return "{\"danh_sach_chuyen_bay\":" + json + "}";
    }

    // cau 19
    // [GET] /chuyen-bay/tong-chi-phi-tra-cho-phi-cong/{gaDi}/
    @GetMapping("/tong-chi-phi-tra-cho-phi-cong/{gaDi}")
    public String getChuyenBayTuADenBE(@PathVariable String gaDi) {
        Double chiPhi = chuyenBayService.getTotalChiPhiTraChoPhiCong(gaDi);
        Gson gson = new Gson();
        Map<String, Object> req = new HashMap<String, Object>();
        req.put("tong_chi_phi", chiPhi);
        String json = gson.toJson(req);
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
        List<ChuyenBay> dsChuyenBay = chuyenBayService.findChuyenBayByGioDi(time);
        Gson gson = new Gson();
        Type chuyenBayType = new TypeToken<List<ChuyenBay>>() {
        }.getType();
        String json = gson.toJson(dsChuyenBay, chuyenBayType);
        return "{ \"ds_chuyen_bay\": " + json + "}";
    }

    // cau 21
    // [GET] /chuyen-bay/truoc-gio/{gaDi}/
    @GetMapping("/so-chuyen-bay-truoc-12-gio/{gaDi}")
    public String getSoChuyenBayTruoc12HByGaDi(@PathVariable String gaDi) {
        Time gioDi = Time.valueOf("12:00:00");
        int soChuyenBay = chuyenBayService.getSoChuyenBayByGioDiAndGaDi(gioDi, gaDi);
        Gson gson = new Gson();

        Map<String, Object> req = new HashMap<>();
        req.put("so_chuyen_bay", soChuyenBay);
        req.put("gaDi", gaDi);

        String json = gson.toJson(req);
        return json;
    }


}
