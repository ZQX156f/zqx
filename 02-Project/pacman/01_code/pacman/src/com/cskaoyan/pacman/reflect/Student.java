package com.cskaoyan.pacman.reflect;

/**
 * @ClassName Student
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 11:34
 * @Version V1.0
 **/
public class Student {

    private String username;

    private Integer age;

    private String school;

    private String course;

    private String province;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Student() {
    }

    public Student(String username, Integer age, String school, String course, String province) {
        this.username = username;
        this.age = age;
        this.school = school;
        this.course = course;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", course='" + course + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
