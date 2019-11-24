package com.guoguo.ningxing.entity.course;

import lombok.Data;

import java.util.Date;

@Data
public class Course {
    private Long id;
    private String url;
    private String name;
    private Date addTime;
    private Date updateTime;
}
