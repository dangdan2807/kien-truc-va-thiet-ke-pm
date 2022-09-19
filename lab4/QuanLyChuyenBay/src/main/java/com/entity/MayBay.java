package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "maybay")
@Getter
@Setter
public class MayBay implements Serializable {
    @Id
    private int MaMB;
    @Column(columnDefinition = "varchar(50)")
    private String Loai;
    private int TamBay;

    public MayBay(int maMB, String loai, int tamBay) {
        MaMB = maMB;
        Loai = loai;
        TamBay = tamBay;
    }

    public MayBay(String loai, int tamBay) {
        Loai = loai;
        TamBay = tamBay;
    }

    public MayBay() {
    }
}
