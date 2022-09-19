package com.Controller;

import com.entity.NhanVien;
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

//    cau 3
    @GetMapping("/luong-nho-hon/{luong}")
    public List<NhanVien> getNhanVienCoLuongNhoHon(@PathVariable(name = "luong") int luong) {
        List<NhanVien> dsNhanVien = nhanVienService.findAllByLuongLessThan(luong);
        return dsNhanVien;
    }
}
