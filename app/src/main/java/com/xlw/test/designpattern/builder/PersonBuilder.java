package com.xlw.test.designpattern.builder;

public class PersonBuilder {
    private String name ;
    private String school;
    private String phone;
    private int high;
    private int age;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSchool(String school) {
        this.school = school;
        return this;
    }

    public PersonBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PersonBuilder setHigh(int high) {
        this.high = high;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public Person createPerson() {
        return new Person(name, school, phone, high, age);
    }
}