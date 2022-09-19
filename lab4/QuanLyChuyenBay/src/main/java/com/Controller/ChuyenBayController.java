package com.Controller;

import com.entity.ChuyenBay;
import com.server.ChuyenBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/chuyen-bay")
public class ChuyenBayController {
    @Autowired
    private ChuyenBayService chuyenBayService;

    @GetMapping("/di-da-lat")
    public List<ChuyenBay> getChuyenBayDiDaLat() {
        List<ChuyenBay> dsChuyenBay = chuyenBayService.getChuyenBayDiDatLat();
        System.out.println(dsChuyenBay.size());

        return dsChuyenBay;
    }
}
