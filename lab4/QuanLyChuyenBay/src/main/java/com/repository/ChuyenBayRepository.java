package com.repository;

import com.entity.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
    List<ChuyenBay> findAllByGaDen(String maGaDen);

    List<ChuyenBay> findAllByDoDaiGreaterThan(int km);

}
