package com.service;

import com.entity.ChuyenBay;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;

public interface ChuyenBayService {
    List<ChuyenBay> getChuyenBayDen(String gaDen);

    List<ChuyenBay> getAllByDoDaiGreaterThan();

    List<ChuyenBay> getAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to);

    List<ChuyenBay> getChuyenByGaDiAndGaDen(String gaDi, String gaDen);

    List<ChuyenBay> getChuyenByGaDiAndGaDenVaTroVe(String gaDi, String gaDen);

    int countChuyenBayByGaDi(String gaDi);

    List<ChuyenBay> getChuyenBayByTamBayAndLoaiMayBay(String tenMB);

    Double getTotalChiPhiTraChoPhiCongByGaDi(String gaDi);

    List<ChuyenBay> getChuyenBayByGioDi(Time gioDi);

    int countChuyenBayByGioDiAndGaDi(Time gioDi, String gaDi);

    List<ChuyenBay> getChuyenBayByTamBayAndLoaiMayBayLike(@Param("tenMB") String tenMB);

    void insertChuyenBays(List<ChuyenBay> dsChuyenBay);
}
