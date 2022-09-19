package com.repository;

import com.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    List<NhanVien> findAllByLuongLessThan(int luong);
}
