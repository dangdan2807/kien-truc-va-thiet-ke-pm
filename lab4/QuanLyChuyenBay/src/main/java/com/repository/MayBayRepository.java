package com.repository;

import com.entity.MayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MayBayRepository extends JpaRepository<MayBay, Long> {
    @Query("select count(mb.maMB) from MayBay mb where mb.loai like 'Boeing%'")
    public int countMayBayByLoaiLike(String loaiMayBay);

    @Query("SELECT mb.maMB from MayBay mb, ChungNhan cn, NhanVien nv " +
            "where mb.maMB = cn.MaMB " +
            "and cn.MaNV = nv.maNV " +
            "and nv.ten like concat(:hoPhiCong, '%')")
    public List<String> getMaMBByHoPhiCong(@Param("hoPhiCong") String hoPhiCong);
}
