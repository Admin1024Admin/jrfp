package com.ky.ct.rzdj.model;

import javax.persistence.*;

@Entity
@Table(name="people")
public class People {
    private int id;
    private String name;
    private String age;
    private int sex;
    private String birth;
    private String home;
    private String card;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", home='" + home + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
