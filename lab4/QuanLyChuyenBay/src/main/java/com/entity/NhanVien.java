package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class NhanVien implements Serializable {
    @Id
    @Column(columnDefinition = "varchar(9)")
    private String MaNV;

    @Column(columnDefinition = "varchar(50)")
    private String Ten;

    private int Luong;

    public NhanVien(String maNV, String ten, int luong) {
        MaNV = maNV;
        this.Ten = ten;
        Luong = luong;
    }

    public NhanVien(String name, int luong) {
        this.Ten = name;
        Luong = luong;
    }

    public NhanVien() {
    }
}
