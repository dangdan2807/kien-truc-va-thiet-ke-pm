package com.repository;

import com.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("select nv from NhanVien nv, ChungNhan cn, MayBay mb " +
            "where mb.maMB = cn.MaMB " +
            "and cn.MaNV = nv.maNV " +
            "and mb.maMB = :maMB")
    public List<NhanVien> findNhanVienByMaMB(@Param("maMB") int maMB);

    @Query("select n from NhanVien n " +
            "where n.maNV in ( " +
            " select c.MaNV from ChungNhan c " +
            " where c.MaMB in (" +
            "   select m1.maMB  from MayBay m1 " +
            "   where m1.loai like 'Airbus%') " +
            " or c.MaMB in ( " +
            "   select m2.maMB  from MayBay m2 " +
            "   where m2.loai like 'Boeing%') " +
            " group by c.MaNV" +
            ")")
    public List<NhanVien> findNhanVienLaiBoeingAndAirbus();
}
