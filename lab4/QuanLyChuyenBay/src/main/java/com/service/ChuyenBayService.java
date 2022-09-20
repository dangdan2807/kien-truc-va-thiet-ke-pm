package com.service;

import com.entity.ChuyenBay;
import com.entity.NhanVien;

import java.sql.Time;
import java.util.List;

public interface ChuyenBayService {
    List<ChuyenBay> getChuyenBayDen(String gaDen);

    List<ChuyenBay> getAllByDoDaiGreaterThan();

    List<ChuyenBay> findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to);

    List<ChuyenBay> findAllByGaDiAndGaDen(String gaDi, String gaDen);

    int countChuyenBayByGaDi(String gaDi);

    List<ChuyenBay> findChuyenBayByTenMayBayAnd(String tenMB);

    List<ChuyenBay> findChuyenBayByGaDiAndGaDen(String gaDi, String gaDen);

    Double getTotalChiPhiTraChoPhiCong(String gaDi);

    List<ChuyenBay> findChuyenBayByGioDi(Time gioDi);

    int getSoChuyenBayByGioDiAndGaDi(Time gioDi, String gaDi);
}
