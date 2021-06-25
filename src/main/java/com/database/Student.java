package com.database;
import java.sql.*;
public class Student {
int id;
String name;
int weight;
int height;
int group_Id;
public Student(int id,String name,int height,int weight,int group_Id){
    this.id=id;
    this.name=name;
    this.weight=weight;
    this.height=height;
    this.group_Id=group_Id;

}
public Student(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroup_Id(int group_Id) {
        this.group_Id = group_Id;
    }

    public int getGroup_Id() {
        return group_Id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", group_Id=" + group_Id +
                '}';
    }
}

