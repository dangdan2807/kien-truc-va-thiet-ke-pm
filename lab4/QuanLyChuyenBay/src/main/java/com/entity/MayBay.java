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
    @Column(name = "mamb")
    private int maMB;

    @Column(name = "loai", columnDefinition = "varchar(50)")
    private String loai;

    @Column(name = "tambay")
    private int tamBay;

    public MayBay(int maMB, String loai, int tamBay) {
        this.maMB = maMB;
        this.loai = loai;
        this.tamBay = tamBay;
    }

    public MayBay(String loai, int tamBay) {
        this.loai = loai;
        this.tamBay = tamBay;
    }

    public MayBay() {
    }
}
