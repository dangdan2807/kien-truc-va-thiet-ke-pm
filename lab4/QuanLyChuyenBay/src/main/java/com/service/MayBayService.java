package com.service;

import com.entity.MayBay;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MayBayService {
    public int countMayBayByLoaiLike(String loaiMayBay);

    public List<String> getMaMBByHoPhiCong(String hoPhiCong);

    public List<MayBay> getMayBayCoTheThucHienChuyenBay(String maCB);
}
