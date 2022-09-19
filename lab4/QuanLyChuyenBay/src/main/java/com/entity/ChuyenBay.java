package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "chuyenbay")
@Getter
@Setter
public class ChuyenBay implements Serializable {
    @Id
    @Column(name="maCB", columnDefinition = "varchar(5)")
    private String maCB;

    @Column(name="gadi", columnDefinition = "varchar(50)")
    private String gaDi;

    @Column(name="gaden", columnDefinition = "varchar(50)")
    private String gaDen;

    @Column(name="dodai")
    private int doDai;

    @Column(name="giodi")
    private Date gioDi;

    @Column(name="gioden")
    private Date gioDen;

    @Column(name="chiphi")
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

    public ChuyenBay(String macb, String gaDi, String gaDen, int doDai, Date gioDi, Date gioDen, int chiPhi) {
        this.maCB = macb;
        this.gaDi = gaDi;
        this.gaDen = gaDen;
        this.doDai = doDai;
        this.gioDi = gioDi;
        this.gioDen = gioDen;
        this.chiPhi = chiPhi;
    }
}
