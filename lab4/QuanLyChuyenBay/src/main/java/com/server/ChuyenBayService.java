package com.server;

import com.entity.ChuyenBay;

import java.util.List;

public interface ChuyenBayService {
    List<ChuyenBay> getChuyenBayDiDatLat();
    List<ChuyenBay> getChuyenBayLonHon10kkm();
}
