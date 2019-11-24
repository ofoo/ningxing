package com.guoguo.ningxing.entity.teacher;

import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    private Long id;
    private String url;
    private String name;
    private Date addTime;
    private Date updateTime;
}
