package com.guoguo.ningxing.entity.company;

import lombok.Data;

import java.util.Date;

@Data
public class Company {
    private Long id;
    private String url;
    private String content;
    private Integer type;
    private Date addTime;
    private Date updateTime;
}
