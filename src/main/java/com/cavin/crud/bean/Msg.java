package com.cavin.crud.bean;


import java.util.HashMap;
import java.util.Map;

// 返回json用的通用返回类
public class Msg {

    private int code;

    private String msg;

    private Map<String, Object> data = new HashMap<>();

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("请求成功！");
        return result;
    }

    public static Msg error(){
        Msg result = new Msg();
        result.setCode(400);
        result.setMsg("请求失败！");
        return result;
    }

    public Msg add(String key, Object value){
        this.getData().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

}
