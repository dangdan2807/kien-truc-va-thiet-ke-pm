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
import java.util.List;

@RestController()
@RequestMapping("/nhan-vien")
public class NhanVienController {
    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);

    @Autowired
    private NhanVienService nhanVienService;

    // cau 3
    // [GET] /nhan-vien/luong-nho-hon/{luong}
    @GetMapping("/luong-nho-hon/{luong}")
    public String getNhanVienCoLuongNhoHon(@PathVariable(name = "luong") int luong) {
        List<NhanVien> dsNhanVien = nhanVienService.findAllByLuongLessThan(luong);
        Gson gson = new Gson();
        Type nhanVienTypeList = new TypeToken<List<NhanVien>>(){}.getType();
        String json = gson.toJson(dsNhanVien, nhanVienTypeList);
        return "{\"danh_sach_nhan_vien\":" + json + "}";
    }

    // cau 8
    // [GET] /nhan-vien/tong-luong
    @GetMapping("/tong-luong")
    public String getTongLuongNhanVien() {
        Object obj = nhanVienService.getTotalSalary();
        Long luong = obj != null ? (Long) obj : 0L;
        return "{ \"tong_luong_nhan_vien\": " + luong + "}";
    }

    // cau 9
    // [GET] /nhan-vien/phi-cong-lai-boeing
    @GetMapping("/phi-cong-lai-boeing")
    public String getMaNhanVienByLoaiMayBayBoeing() {
        List<String> dsMaNhanVien = nhanVienService.getMaNhanVienByLoaiMayBayBoeing();
        return "{\"ma_phi_congs\":" + dsMaNhanVien + "}";
    }

    // cau 10
    // [GET] /nhan-vien/phi-cong-lai-may-bay?mamb=747
    @GetMapping("/phi-cong-lai-may-bay")
    public String getNhanVienByMaMayBay(@RequestParam(name = "mamb", required = false, defaultValue = "0") Integer maMB) {
        List<NhanVien> dsNhanVien = new ArrayList<>();
        dsNhanVien = nhanVienService.findNhanVienByMaMB(maMB);
        Gson gson = new Gson();
        Type nhanVienTypeList = new TypeToken<List<NhanVien>>(){}.getType();
        String json = gson.toJson(dsNhanVien, nhanVienTypeList);
        return "{\"danh_sach_phi_cong\":" + json + "}";
    }

    // cau 12
    // [GET] /nhan-vien/phi-cong-lai-may-bay-boeing-airbus
    @GetMapping("/phi-cong-lai-may-bay-boeing-airbus")
    public String getNhanVienLaiBoeingAndAirbus() {
        List<NhanVien> dsNhanVien = new ArrayList<>();
        dsNhanVien = nhanVienService.findNhanVienLaiBoeingAndAirbus();
        Gson gson = new Gson();
        Type nhanVienTypeList = new TypeToken<List<NhanVien>>(){}.getType();
        String json = gson.toJson(dsNhanVien, nhanVienTypeList);
        return "{\"danh_sach_phi_cong\":" + json + "}";
    }
}
