package com.service;

import java.util.List;

public interface MayBayService {
    public int countMayBayByLoaiLike(String loaiMayBay);

    public List<String> getMaMBByHoPhiCong(String hoPhiCong);
}
