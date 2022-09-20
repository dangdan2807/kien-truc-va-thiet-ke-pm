package com.service;

import com.entity.MayBay;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MayBayService {
    public int countMayBayByLoaiLike(String loaiMayBay);

    public List<String> getMaMBByHoPhiCong(String hoPhiCong);

    public List<MayBay> getMayBayCoTheThucHienChuyenBay(String maCB);

    public List<Map<String, Object>> getLoaiMayBayVaSoPhiCongLai();
}
