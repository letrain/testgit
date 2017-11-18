package com.website.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by letrain on 2017/11/18.
 */
@Entity
@Data
public class CpType {
    @Id
    @GeneratedValue
    private Integer id;

    private String typename;

    private Integer typeid;
}
