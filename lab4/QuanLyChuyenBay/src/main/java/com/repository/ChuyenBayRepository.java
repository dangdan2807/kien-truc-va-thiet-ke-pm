package com.repository;

import com.entity.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
    List<ChuyenBay> findAllByGaDen(String maGaDen);

    List<ChuyenBay> findAllByDoDaiGreaterThan(int km);

    List<ChuyenBay> findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to);

    List<ChuyenBay> findAllByGaDiAndGaDen(String gaDi, String gaDen);

    int countChuyenBayByGaDi(String gaDi);

}
