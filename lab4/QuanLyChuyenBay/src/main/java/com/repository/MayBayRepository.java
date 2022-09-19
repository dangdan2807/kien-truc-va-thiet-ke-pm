package com.repository;

import com.entity.MayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MayBayRepository extends JpaRepository<MayBay, Long> {
    @Query("select count(MaMB) from MayBay where Loai like 'Boeing%'")
    public int countMayBayByLoaiLike(String loaiMayBay);
}
