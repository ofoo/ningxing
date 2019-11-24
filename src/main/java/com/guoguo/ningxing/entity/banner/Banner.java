package com.guoguo.ningxing.entity.banner;

import lombok.Data;

import java.util.Date;

@Data
public class Banner {
    private Long id;
    private String url;
    private Date addTime;
    private Date updateTime;
}
