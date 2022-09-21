package com.repository;

import com.entity.MayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MayBayRepository extends JpaRepository<MayBay, Long> {

    @Override
    <S extends MayBay> List<S> saveAll(Iterable<S> entities);

    @Query("select count(mb.maMB) from MayBay mb where mb.loai like 'Boeing%'")
    public int countMayBayByLoaiLike(String loaiMayBay);

    @Query("SELECT mb.maMB from MayBay mb, ChungNhan cn, NhanVien nv " +
            "where mb.maMB = cn.MaMB " +
            "and cn.MaNV = nv.maNV " +
            "and nv.ten like concat(:hoPhiCong, '%')")
    public List<String> getMaMBByHoPhiCong(@Param("hoPhiCong") String hoPhiCong);

    @Query("select m from MayBay m " +
            "where m.tamBay >= ( " +
            "   select c.doDai from ChuyenBay c " +
            "   where c.maCB = :maCB)")
    public List<MayBay> getMayBayCoTheThucHienChuyenBay(@Param("maCB") String maCB);

    @Query("select m.maMB as maMB, m.loai as loai, count(n.maNV) as soPhiCong " +
            "from MayBay m, ChungNhan c, NhanVien n " +
            "where m.maMB = c.MaMB " +
            "and c.MaNV = n.maNV " +
            "group by m.maMB, m.loai")
    public List<Map<String, Object>> getLoaiMayBayVaSoPhiCongLai();
}
