package com.service;

import com.entity.ChuyenBay;

import java.util.List;

public interface ChuyenBayService {
    List<ChuyenBay> getChuyenBayDen(String gaDen);
    List<ChuyenBay> getAllByDoDaiGreaterThan();
    List<ChuyenBay> findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to);
    List<ChuyenBay> findAllByGaDiAndGaDen(String gaDi, String gaDen);
    int countChuyenBayByGaDi(String gaDi);
}
