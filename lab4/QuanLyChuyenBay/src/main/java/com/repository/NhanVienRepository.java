package com.repository;

import com.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    List<NhanVien> findAllByLuongLessThan(int luong);

    @Query(value = "select SUM(nv.luong) from NhanVien nv")
    public Object getTotalSalary();

    @Query("select nv from NhanVien nv, ChungNhan cn, MayBay mb " +
            "where mb.maMB = cn.MaMB " +
            "and cn.MaNV = nv.maNV " +
            "and mb.loai like 'Boeing%' " +
            "group by nv.maNV ")
    public List<NhanVien> getNhanVienByLoaiMayBayBoeing();

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

    @Query("select n from NhanVien n " +
            "where n.maNV in ( " +
            "   select c.MaNV from ChungNhan c " +
            "   group by c.MaNV " +
            "   having count(c.MaMB) >= 3 " +
            ")")
    public List<NhanVien> findNhanVienLai3LoaiMB();

    @Query("select n.maNV as maNV, max(m.tamBay) as tamBayLonNhat " +
            "from NhanVien n, ChungNhan c, MayBay m " +
            "where n.maNV = c.MaNV  " +
            "and c.MaMB = m.maMB " +
            "group by c.MaNV " +
            "having count(c.MaMB) >= 3")
    public List<Map<String, Object>> findMaNhanVienLai3LoaiMBVaTamBayLonNhat();

    @Query("select n.maNV as maNV, count(m.maMB) as soMayBayLaiDuoc " +
            "from ChungNhan c, MayBay m, NhanVien n " +
            "where c.MaMB = m.maMB " +
            "and c.MaNV = n.maNV " +
            "group by c.MaNV  ")
    public List<Map<String, Object>> findMaNhanVienVaSoMBLaiDc();

    @Query("select n from NhanVien n " +
            "where n.maNV not in (" +
            "   select c.MaNV from ChungNhan c " +
            "   group by c.MaNV )")
    public List<NhanVien> findNhanVienByKhongPhaiLaPhiCong();

    @Query("select n from NhanVien n " +
            "where n.luong in ( " +
            "   select max(n2.luong) " +
            "   from NhanVien n2 ) " +
            "order by n.luong desc")
    public List<NhanVien> findNhanVienByLuongCaoNhat();

    @Query("select sum(n.luong) from NhanVien n " +
            "where n.maNV in ( " +
            "   select c.MaNV from ChungNhan c " +
            "   group by c.MaNV) ")
    public Double getTotalSalaryPhiCong();
}
