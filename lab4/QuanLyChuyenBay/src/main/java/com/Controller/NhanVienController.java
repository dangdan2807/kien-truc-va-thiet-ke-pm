package com.Controller;

import com.entity.NhanVien;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.service.NhanVienService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/nhan-vien")
public class NhanVienController {
    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);
    private static Gson gson = new Gson();

    @Autowired
    private NhanVienService nhanVienService;

    // cau 3
    // [GET] /nhan-vien/luong-nho-hon/{luong}
    @GetMapping("/luong-nho-hon/{luong}")
    public String getNhanVienCoLuongNhoHon(@PathVariable(name = "luong") int luong) {
        List<NhanVien> dsNhanVien = nhanVienService.findAllByLuongLessThan(luong);

        Map<String, List<NhanVien>> res = new HashMap<>();
        res.put("ds_nhan_vien", dsNhanVien);
        return gson.toJson(res);
    }

    // cau 8
    // [GET] /nhan-vien/tong-luong
    @GetMapping("/tong-luong")
    public String getTongLuongNhanVien() {
        Object obj = nhanVienService.getTotalSalary();
        Long luong = obj != null ? (Long) obj : 0L;

        Map<String, Long> res = new HashMap<>();
        res.put("tong_luong_nhan_vien", luong);

        return gson.toJson(res);
    }

    // cau 9
    // [GET] /nhan-vien/phi-cong-lai-boeing/ma
    @GetMapping("/phi-cong-lai-boeing/ma")
    public String getMaNhanVienByLoaiMayBayBoeing() {
        List<String> dsMaNhanVien = nhanVienService.getMaNhanVienByLoaiMayBayBoeing();

        Map<String, List<String>> res = new HashMap<>();
        res.put("ds_ma_phi_cong", dsMaNhanVien);
        String json = gson.toJson(res);
        return json;
    }

    // cau 10
    // [GET] /nhan-vien/phi-cong-lai-may-bay?mamb=747
    @GetMapping("/phi-cong-lai-may-bay")
    public String getNhanVienByMaMayBay(@RequestParam(name = "mamb", required = false, defaultValue = "0") Integer maMB) {
        List<NhanVien> dsNhanVien = nhanVienService.findNhanVienByMaMB(maMB);

        Map<String, List<NhanVien>> res = new HashMap<>();
        res.put("ds_phi_cong", dsNhanVien);
        return gson.toJson(res);
    }

    // cau 12
    // [GET] /nhan-vien/phi-cong-lai-may-bay-boeing-airbus
    @GetMapping("/phi-cong-lai-may-bay-boeing-airbus")
    public String getNhanVienLaiBoeingAndAirbus() {
        List<NhanVien> dsNhanVien = nhanVienService.findNhanVienLaiBoeingAndAirbus();

        Map<String, List<NhanVien>> res = new HashMap<>();
        res.put("ds_phi_cong", dsNhanVien);
        return gson.toJson(res);
    }

    // cau 15
    // [GET] /nhan-vien/phi-cong-lai-boeing/ten
    @GetMapping("/phi-cong-lai-boeing/ten")
    public String getTenNhanVienLaiBoeing() {
        List<String> dsTenNV = nhanVienService.getTenNhanVienByLoaiMayBayBoeing();

        Map<String, List<String>> res = new HashMap<>();
        res.put("ds_ten_phi_cong", dsTenNV);
        String json = gson.toJson(res);
        return json;
    }

    // cau 22
    // [GET] /nhan-vien/phi-cong-lai-3-loai-mb
    @GetMapping("/phi-cong-lai-3-loai-mb")
    public String getMaNhanVienLai3LoaiMB() {
        List<String> dsTenNV = nhanVienService.getMaNhanVienLai3LoaiMB();

        Map<String, List<String>> res = new HashMap<>();
        res.put("ds_ma_phi_cong", dsTenNV);
        String json = gson.toJson(res);
        return json;
    }

    // cau 23
    // [GET] /nhan-vien/phi-cong-lai-3-loai-mb-va-tam-bay
    @GetMapping("/phi-cong-lai-3-loai-mb-va-tam-bay")
    public String getMaNhanVienLai3LoaiMBVaTamBay() {
        List<Map<String, Object>> dsNhanVien = nhanVienService.getMaNhanVienLai3LoaiMBVaTamBay();

        Map<String, List<Map<String, Object>>> res = new HashMap<>();
        res.put("ds_nhan_vien", dsNhanVien);
        String json = gson.toJson(res);
        return json;
    }

    // cau 24
    // [GET] /nhan-vien/so-may-bay-phi-cong-lai-duoc
    @GetMapping("/so-may-bay-phi-cong-lai-duoc")
    public String getMaNhanVienVaSoLuongMayBayLaiDuoc() {
        List<Map<String, Object>> dsNhanVien = nhanVienService.getMaNhanVienVaSoMBLaiDc();

        Map<String, List<Map<String, Object>>> res = new HashMap<>();
        res.put("ds_nhan_vien", dsNhanVien);
        String json = gson.toJson(res);
        return json;
    }

    // cau 25
    // [GET] /nhan-vien/khong-phai-la-phi-cong
    @GetMapping("/khong-phai-la-phi-cong")
    public String getNhanVienKhongPhaiLaPhiCong() {
        List<NhanVien> dsNhanVien = nhanVienService.getNhanVienByKhongPhaiLaPhiCong();

        Map<String, List<NhanVien>> res = new HashMap<>();
        res.put("ds_nhan_vien", dsNhanVien);
        String json = gson.toJson(res);
        return json;
    }

    // cau 26
    // [GET] /nhan-vien/luong-cao-nhat
    @GetMapping("/luong-cao-nhat")
    public String getNhanVienLuongCaoNhat() {
        List<NhanVien> dsNhanVien = nhanVienService.getNhanVienByLuongCaoNhat();

        Map<String, List<NhanVien>> res = new HashMap<>();
        res.put("ds_nhan_vien", dsNhanVien);
        String json = gson.toJson(res);
        return json;
    }

    // cau 27
    // [GET] /nhan-vien/tong-luong-phi-cong
    @GetMapping("/tong-luong-phi-cong")
    public String getLuongPhiCong() {
        Double chiPhi = nhanVienService.getTotalSalaryPhiCong();

        Map<String, Double> res = new HashMap<>();
        res.put("tong_chi_chi", chiPhi);
        String json = gson.toJson(res);
        return json;
    }
}
