package com.repository;

import com.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    List<NhanVien> findAllByLuongLessThan(int luong);

    @Query(value = "select SUM(nv.luong) from NhanVien nv")
    public Object getTotalSalary();

    @Query("select nv.maNV from NhanVien nv, ChungNhan cn, MayBay mb " +
            "where mb.maMB = cn.MaMB " +
            "and cn.MaNV = nv.maNV " +
            "and mb.loai like 'Boeing%'")
    public List<String> getMaNhanVienByLoaiMayBayBoeing();
}
