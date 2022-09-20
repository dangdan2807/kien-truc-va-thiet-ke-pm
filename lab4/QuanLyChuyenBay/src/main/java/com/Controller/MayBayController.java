package com.Controller;

import com.service.MayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/may-bay")
public class MayBayController {

    @Autowired
    private MayBayService mayBayService;

    // cau 7
    // [GET] /may-bay/so-may-bay/boeing
    @GetMapping("/so-may-bay/boeing")
    public String getSoMayBayBoeing() {
        String loai = "Boeing";
        int count = mayBayService.countMayBayByLoaiLike(loai);
        return "{ \"so_may_bay\": " + count + "}";
    }

    // cau 11
    // [GET] /may-bay/phi-cong-ho-nguyen
    @GetMapping("/phi-cong-ho-nguyen")
    public String getMaMayBayDoPhiCongHoNguyenLai() {
        String hoPhiCong = "Nguyen";
        List<String> dsMaMayBay = mayBayService.getMaMBByHoPhiCong(hoPhiCong);
        return "{ \"ds_ma_may_bay\": " + dsMaMayBay + "}";
    }
}
