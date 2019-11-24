package com.guoguo.util;

import lombok.Data;

@Data
public class Json {
    private boolean status;
    private String msg;
    private Object data;

    public static Json jsonTrue() {
        Json json = new Json();
        json.setStatus(true);
        json.setMsg("操作成功");
        return json;
    }

    public static Json jsonTrue(String msg) {
        Json json = new Json();
        json.setStatus(true);
        json.setMsg(msg);
        return json;
    }

    public static Json jsonTrue(Object data) {
        Json json = new Json();
        json.setStatus(true);
        json.setMsg("操作成功");
        json.setData(data);
        return json;
    }

    public static Json jsonTrue(String msg, Object data) {
        Json json = new Json();
        json.setStatus(true);
        json.setMsg(msg);
        json.setData(data);
        return json;
    }

    public static Json jsonFalse() {
        Json json = new Json();
        json.setStatus(false);
        json.setMsg("操作失败");
        return json;
    }

    public static Json jsonFalse(String msg) {
        Json json = new Json();
        json.setStatus(false);
        json.setMsg(msg);
        return json;
    }

    public static Json jsonFalse(Object data) {
        Json json = new Json();
        json.setStatus(false);
        json.setMsg("操作失败");
        json.setData(data);
        return json;
    }

    public static Json jsonFalse(String msg, Object data) {
        Json json = new Json();
        json.setStatus(false);
        json.setMsg(msg);
        json.setData(data);
        return json;
    }
}
