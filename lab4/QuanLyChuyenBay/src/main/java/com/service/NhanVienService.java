package com.service;

import com.entity.NhanVien;

import java.util.List;

public interface NhanVienService {
    public List<NhanVien> findAllByLuongLessThan(int luong);
    public Object getTotalSalary();

    public List<String> getMaNhanVienByLoaiMayBayBoeing();
}
