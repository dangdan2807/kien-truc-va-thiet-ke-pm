package com.service;

import com.entity.NhanVien;
import com.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<NhanVien> dsMaNhanVien = nhanVienRepository.getNhanVienByLoaiMayBayBoeing();
        List<String> dsMaNV = new ArrayList<>();
        dsMaNhanVien.stream().forEach(item -> dsMaNV.add(item.getMaNV()));
        return dsMaNV;
    }

    @Override
    public List<NhanVien> findNhanVienByMaMB(int maMB) {
        return nhanVienRepository.findNhanVienByMaMB(maMB);
    }

    @Override
    public List<NhanVien> findNhanVienLaiBoeingAndAirbus() {
        return nhanVienRepository.findNhanVienLaiBoeingAndAirbus();
    }

    @Override
    public List<String> getTenNhanVienByLoaiMayBayBoeing() {
        List<NhanVien> dsNhanVien = nhanVienRepository.getNhanVienByLoaiMayBayBoeing();
        List<String> dsTenNV = new ArrayList<>();
        dsNhanVien.stream().forEach(item -> dsTenNV.add(item.getTen()));
        return dsTenNV;
    }

    @Override
    public List<String> getMaNhanVienLai3LoaiMB() {
        List<NhanVien> dsNhanVien = nhanVienRepository.findNhanVienLai3LoaiMB();
        List<String> dsMaNV = new ArrayList<>();
        dsNhanVien.stream().forEach(item -> dsMaNV.add(item.getMaNV()));
        return dsMaNV;
    }

    @Override
    public List<Map<String, Object>> getMaNhanVienLai3LoaiMBVaTamBay() {
        List<Map<String, Object>> ds = nhanVienRepository.findMaNhanVienLai3LoaiMBVaTamBayLonNhat();
        return ds;
    }

    @Override
    public List<Map<String, Object>> getMaNhanVienVaSoMBLaiDc() {
        List<Map<String, Object>> ds = nhanVienRepository.findMaNhanVienVaSoMBLaiDc();
        return ds;
    }

    @Override
    public List<NhanVien> getNhanVienByKhongPhaiLaPhiCong() {
        List<NhanVien> dsNhanVien = nhanVienRepository.findNhanVienByKhongPhaiLaPhiCong();
        return dsNhanVien;
    }
}
