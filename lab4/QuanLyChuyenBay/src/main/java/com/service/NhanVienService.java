package com.service;

import com.entity.NhanVien;

import java.util.List;
import java.util.Map;

public interface NhanVienService {
    public List<NhanVien> findAllByLuongLessThan(int luong);

    public Object getTotalSalary();

    public List<String> getMaNhanVienByLoaiMayBayBoeing();

    public List<NhanVien> findNhanVienByMaMB(int maMB);

    public List<NhanVien> findNhanVienLaiBoeingAndAirbus();

    public List<String> getTenNhanVienByLoaiMayBayBoeing();

    public List<String> getMaNhanVienLai3LoaiMB();

    public List<Map<String, Object>> getMaNhanVienLai3LoaiMBVaTamBay();

    public List<Map<String, Object>> getMaNhanVienVaSoMBLaiDc();

    public List<NhanVien> getNhanVienByKhongPhaiLaPhiCong();

    public List<NhanVien> getNhanVienByLuongCaoNhat();

    public Double getTotalSalaryPhiCong();
}
