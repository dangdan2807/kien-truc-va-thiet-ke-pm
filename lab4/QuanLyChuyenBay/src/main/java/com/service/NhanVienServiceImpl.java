package com.service;

import com.entity.NhanVien;
import com.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService{
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> findAllByLuongLessThan(int luong) {
        List<NhanVien> nhanViens = nhanVienRepository.findAllByLuongLessThan(luong);
        return nhanViens;
    }

    @Override
    public Object getTotalSalary() {
        Object luong = nhanVienRepository.getTotalSalary();
        return luong;
    }

    @Override
    public List<String> getMaNhanVienByLoaiMayBayBoeing() {
        List<String> dsMaNhanVien = nhanVienRepository.getMaNhanVienByLoaiMayBayBoeing();
        return dsMaNhanVien;
    }
}
