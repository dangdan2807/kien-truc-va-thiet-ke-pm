package com.SpringBoot_JWT.models;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deleted;

    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;

    @CreatedBy
    private Long createBy;

    @LastModifiedBy
    private Long updateBy;
}
