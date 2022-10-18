package com.service;

import com.entity.ChuyenBay;

import java.util.List;
import java.util.Optional;

public interface ChuyenBayService {
    List<ChuyenBay> getChuyenBay();

    ChuyenBay getChuyenBayById(String maCB);

    void saveChuyenBay(ChuyenBay chuyenBay);

    void deleteChuyenBay(String maCB);

    public void insertChuyenBay(ChuyenBay chuyenBay);
}
