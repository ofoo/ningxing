package com.guoguo.ningxing.entity.record;

import lombok.Data;

import java.util.Date;

@Data
public class Record {
    private Long id;
    private Long count;
    private Integer type;
    private Date addTime;
}
