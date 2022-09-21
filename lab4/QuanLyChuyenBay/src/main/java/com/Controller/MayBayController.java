package com.Controller;

import com.entity.ChuyenBay;
import com.entity.MayBay;
import com.entity.NhanVien;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.service.MayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController()
@RequestMapping("/may-bay")
public class MayBayController {
    private static Gson gson = new Gson();
    @Autowired
    private MayBayService mayBayService;

    // cau 7
    // [GET] /may-bay/so-may-bay/boeing
    @GetMapping("/so-may-bay/boeing")
    public String getSoMayBayBoeing() {
        String loai = "Boeing";
        int count = mayBayService.countMayBayByLoaiLike(loai);

        Map<String, Integer> res = new HashMap<>();
        res.put("so_may_bay", count);
        return gson.toJson(res);
    }

    // cau 11
    // [GET] /may-bay/phi-cong-ho-nguyen
    @GetMapping("/phi-cong-ho-nguyen")
    public String getMaMayBayDoPhiCongHoNguyenLai() {
        String hoPhiCong = "Nguyen";
        List<String> dsMaMayBay = mayBayService.getMaMBByHoPhiCong(hoPhiCong);

        Map<String, List<String>> res = new HashMap<>();
        res.put("ds_ma_may_bay", dsMaMayBay);
        return gson.toJson(res);
    }

    // cau 13
    // [GET] /may-bay/thuc-hien-chuyen-bay/{maCB}
    @GetMapping("/thuc-hien-chuyen-bay/{maCB}")
    public String getMayBayCoTheThucHienChuyenBayByMaCB(@PathVariable String maCB) {
        List<MayBay> dsMaMayBay = mayBayService.getMayBayCoTheThucHienChuyenBay(maCB);

        Map<String, List<MayBay>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsMaMayBay);
        return gson.toJson(res);
    }

    // cau 16
    // [GET] /may-bay/loai-may-bay-va-so-phi-cong-lai
    @GetMapping("/loai-may-bay-va-so-phi-cong-lai")
    public String getLoaiMayBayVaSoPhiCongLai() {
        List<Map<String, Object>> dsMayBay = mayBayService.getLoaiMayBayVaSoPhiCongLai();

        Map<String, List<Map<String, Object>>> res = new HashMap<>();
        res.put("ds_chuyen_bay", dsMayBay);
        return gson.toJson(res);
    }
}
