package com.repository;

import com.entity.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
    public List<ChuyenBay> findAllByMaCB(String maCB);

    public List<ChuyenBay> findAllByGaDen(String maGaDen);

    public List<ChuyenBay> getAllByGaDen(String maGaDen);

    public List<ChuyenBay> searchChuyenBayByGaDen(String maGaDen);

}
