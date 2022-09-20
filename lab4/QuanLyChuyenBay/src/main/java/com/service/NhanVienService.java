package com.service;

import com.entity.NhanVien;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NhanVienService {
    public List<NhanVien> findAllByLuongLessThan(int luong);

    public Object getTotalSalary();

    public List<String> getMaNhanVienByLoaiMayBayBoeing();

    public List<NhanVien> findNhanVienByMaMB(int maMB);

    public List<NhanVien> findNhanVienLaiBoeingAndAirbus();
}
