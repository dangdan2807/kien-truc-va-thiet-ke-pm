package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class ChuyenBay implements Serializable {
    @Id
    @Column(columnDefinition = "varchar(5)")
    private String maCB;

    @Column(columnDefinition = "varchar(50)")
    private String gaDi;

    @Column(columnDefinition = "varchar(50)")
    private String gaDen;

    private int doDai;
    private Date gioDi;
    private Date gioDen;
    private int chiPhi;

    public ChuyenBay() {
    }

    public ChuyenBay(String gaDi, String gaDen, int doDai, Date gioDi, Date gioDen, int chiPhi) {
        this.gaDi = gaDi;
        this.gaDen = gaDen;
        this.doDai = doDai;
        this.gioDi = gioDi;
        this.gioDen = gioDen;
        this.chiPhi = chiPhi;
    }

    public ChuyenBay(String maCB, String gaDi, String gaDen, int doDai, Date gioDi, Date gioDen, int chiPhi) {
        this.maCB = maCB;
        this.gaDi = gaDi;
        this.gaDen = gaDen;
        this.doDai = doDai;
        this.gioDi = gioDi;
        this.gioDen = gioDen;
        this.chiPhi = chiPhi;
    }
}
