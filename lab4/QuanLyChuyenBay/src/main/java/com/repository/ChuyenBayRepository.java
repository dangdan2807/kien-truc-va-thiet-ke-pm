package com.repository;

import com.entity.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
    List<ChuyenBay> findAllByGaDen(String maGaDen);

    List<ChuyenBay> findAllByDoDaiGreaterThan(int km);

    List<ChuyenBay> findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to);

    List<ChuyenBay> findAllByGaDiAndGaDen(String gaDi, String gaDen);

    int countChuyenBayByGaDi(String gaDi);

    @Query("select c from ChuyenBay c " +
            "where c.doDai <= ( " +
            "   select m.tamBay from MayBay m" +
            "   where m.loai = :tenMB)")
    List<ChuyenBay> findChuyenBayByTenMayBayAnd(@Param("tenMB") String tenMB);
}
