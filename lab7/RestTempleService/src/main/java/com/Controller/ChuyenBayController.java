package com.Controller;

import com.entity.ChuyenBay;
import com.google.gson.Gson;
import com.service.ChuyenBayService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/chuyen-bay")
public class ChuyenBayController {
    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);
    private static Gson gson = new Gson();
    @Autowired
    private ChuyenBayService chuyenBayService;

    static DateFormat format = new SimpleDateFormat("HH:mm:ss");

    // [GET] /chuyen-bay
    @GetMapping("")
    public String getChuyenBay() {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBay();
        dsChuyenBay.forEach(item -> {
            try {
                Time t = new Time(format.parse(item.getGioDi().toString()).getTime());
                item.setGioDi(t);
                t = new Time(format.parse(item.getGioDen().toString()).getTime());
                item.setGioDen(t);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
//        logger.info(dsChuyenBay.size());
//        String message = "Lấy danh sách chuyến bay";
//        if (dsChuyenBay.size() == 0) {
//            message = "Không có chuyến bay nào phù hợp";
//        }
//        Map<String, Object> res = new HashMap<>();
//        res.put("message", message);
//        res.put("ds_chuyen_bay", dsChuyenBay);
        return gson.toJson(dsChuyenBay);
    }

    // [POST] /chuyen-bay
    @PostMapping("")
    public String addChuyenBay(@RequestBody ChuyenBay chuyenBay) {
        chuyenBayService.insertChuyenBay(chuyenBay);
        String message = "Them chuyến bay thanh cong";
        Map<String, Object> res = new HashMap<>();
        res.put("message", message);
        return gson.toJson(res);
    }

    // [GET] /chuyen-bay/{id}
    @GetMapping("/{id}")
    public String getChuyenBayById(@PathVariable(value = "id") String maCB) {
        ChuyenBay chuyenBay = chuyenBayService.getChuyenBayById(maCB);
//        String message = "lay chuyến bay thanh cong";
//        logger.info(chuyenBay);
//        Map<String, Object> res = new HashMap<>();
//        if(chuyenBay.isEmpty()) {
//            message = "chuyen bay không ton tai";
//        } else {
//            res.put("chuyen_bay", chuyenBay);
//        }
//        res.put("message", message);
        return gson.toJson(chuyenBay);
    }

    // [GET] /chuyen-bay/{id}
    @PutMapping("/{id}")
    public String updateChuyenBayById(@PathVariable(value = "id") String maCB, @RequestBody ChuyenBay chuyenBay) {
        ChuyenBay oldChuyenBay = chuyenBayService.getChuyenBayById(maCB);
        String message = "cap nhat chuyến bay that bai";
        if (oldChuyenBay != null) {
            chuyenBay.setMaCB(maCB);
            chuyenBayService.saveChuyenBay(chuyenBay);
            message = "cap nhat chuyến bay thanh cong";
        }

        Map<String, Object> res = new HashMap<>();
        res.put("message", message);
        res.put("chuyen_bay", chuyenBay);
        return gson.toJson(res);
    }

    // [POST] /chuyen-bay/delete/{id}
    @DeleteMapping("/{id}")
    public String deleteChuyenBayById(@PathVariable(value = "id") String maCB) {
        ChuyenBay chuyenBay = chuyenBayService.getChuyenBayById(maCB);
        String message = "xoa chuyến bay that bai";
        if (chuyenBay != null) {
            chuyenBayService.deleteChuyenBay(maCB);
            message = "xoa chuyến bay thanh cong";
        }
        Map<String, Object> res = new HashMap<>();
        res.put("message", message);
        return gson.toJson(res);
    }
}
