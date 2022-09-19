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
}