package com.fit.se.ChuyenBayService.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fit.se.ChuyenBayService.model.ChuyenBay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
	@Override
	<S extends ChuyenBay> List<S> saveAll(Iterable<S> entities);

	List<ChuyenBay> findAllByGaDen(String maGaDen);

	List<ChuyenBay> findAllByDoDaiGreaterThan(int km);

	List<ChuyenBay> findAllByDoDaiGreaterThanEqualAndDoDaiLessThanEqual(int from, int to);

	List<ChuyenBay> findAllByGaDiAndGaDen(String gaDi, String gaDen);

	@Query("select c from ChuyenBay c " +
			"where c.gaDi in (:gaDi, :gaDen) " +
			"and c.gaDen in (:gaDen, :gaDi)")
	List<ChuyenBay> findAllByGaDiAndGaDenVaTroVe(@Param("gaDi") String gaDi, @Param("gaDen") String gaDen);

//	@Query("select c from ChuyenBay c " +
//			"where c.doDai <= ( " +
//			"   select m.tamBay from MayBay m" +
//			"   where m.loai = :tenMB)")
//	List<ChuyenBay> findChuyenBayByTamBayAndLoaiMayBay(@Param("tenMB") String tenMB);

	List<ChuyenBay> findChuyenBayByGaDi(String gaDi);

	List<ChuyenBay> findChuyenBayByGioDiLessThan(Date gioDi);

	List<ChuyenBay> findChuyenBayByGioDiLessThanAndAndGaDi(Date gioDi, String gaDi);

//	@Query("select c from ChuyenBay c " +
//			"where c.doDai <= ( " +
//			"   select min(m.tamBay) from MayBay m" +
//			"   where m.loai like concat(:tenLoai, '%') )")
//	List<ChuyenBay> findChuyenBayThucHienTatCaLoaiMayBayLike(@Param("tenLoai") String tenLoai);

}