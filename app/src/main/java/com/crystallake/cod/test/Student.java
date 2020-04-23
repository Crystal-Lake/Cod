package com.crystallake.cod.test;

import javax.inject.Inject;

/**
 * Created by yds
 * on 2020/4/21.
 */
public class Student {
    private String name;
    public Student(){

    }

    public Student(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
