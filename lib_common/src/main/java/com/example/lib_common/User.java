package com.example.lib_common;

import java.io.Serializable;

/**
 * 基础用户类
 * @author kinsomy
 * @date 2023/1/4
 * @time 13:38
 */
public class User implements Serializable {
    String name;
    String age;
    String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
