package com.springboot_jwt_2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="role")
@Getter
@Setter
public class Role extends BaseEntity {
    private String name;
}
