package com.fit.se.ChuyenBayService.service;

import java.util.Date;
import java.util.List;

import com.fit.se.ChuyenBayService.model.ChuyenBay;
import org.springframework.data.repository.query.Param;


public interface ChuyenBayService {
    List<ChuyenBay> getChuyenBayDen(String gaDen);

    List<ChuyenBay> getAllByDoDaiGreaterThan();

    List<ChuyenBay> getAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to);

    List<ChuyenBay> getChuyenByGaDiAndGaDen(String gaDi, String gaDen);

    List<ChuyenBay> getChuyenByGaDiAndGaDenVaTroVe(String gaDi, String gaDen);

    int countChuyenBayByGaDi(String gaDi);

//    List<ChuyenBay> getChuyenBayByTamBayAndLoaiMayBay(String tenMB);

    Double getTotalChiPhiTraChoPhiCongByGaDi(String gaDi);

    List<ChuyenBay> getChuyenBayByGioDi(Date gioDi);

    int countChuyenBayByGioDiAndGaDi(Date gioDi, String gaDi);

//    List<ChuyenBay> getChuyenBayByTamBayAndLoaiMayBayLike(@Param("tenMB") String tenMB);

    void insertChuyenBays(List<ChuyenBay> dsChuyenBay);
}