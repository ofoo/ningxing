package com.guoguo.ningxing.entity.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private Date addTime;
    private Date updateTime;
}
