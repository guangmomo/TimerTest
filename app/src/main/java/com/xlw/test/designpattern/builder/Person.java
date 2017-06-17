package com.xlw.test.designpattern.builder;

/**
 * Created by xlw on 2017/4/2.
 */

public class Person {
    private String name;
    private String school;
    private String phone;
    private int high;
    private int age;

    Person(String name, String school, String phone, int high, int age){
        this.name=name;
        this.school=school;
        this.phone=phone;
        this.high=high;
        this.age=age;
    }

    @Override
    public String toString() {
        return "name="+name+"\nschool="+school+"\nphone="+phone+"\nhigh="+high
                +"\nage="+age;
    }
}
