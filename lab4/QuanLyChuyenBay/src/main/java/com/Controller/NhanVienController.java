package com.Controller;

import com.entity.NhanVien;
import com.google.gson.Gson;
import com.service.NhanVienService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<NhanVien> getNhanVienCoLuongNhoHon(@PathVariable(name = "luong") int luong) {
        List<NhanVien> dsNhanVien = nhanVienService.findAllByLuongLessThan(luong);
        return dsNhanVien;
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
}
