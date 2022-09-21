package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "nhanvien")
@Getter
@Setter
public class NhanVien implements Serializable {
    @Id
    @Column(name = "manv", columnDefinition = "varchar(9)")
    private String maNV;

    @Column(name = "ten", columnDefinition = "varchar(50)")
    private String ten;

    @Column(name = "luong")
    private int luong;

    public NhanVien(String maNV, String ten, int luong) {
        this.maNV = maNV;
        this.ten = ten;
        this.luong = luong;
    }

    public NhanVien(String name, int luong) {
        this.ten = name;
        this.luong = luong;
    }

    public NhanVien(String maNV) {
        this.maNV = maNV;
    }

    public NhanVien() {
    }
}
