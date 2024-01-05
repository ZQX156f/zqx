package com.cskaoyan.oop2.encapsulate;

public class EX {

    public static void main(String[] args) {

        Employer employer = new Employer();

        employer.setAge(900);
        employer.setSalary(20000);

        employer.info();
    }
}

class Employer{
    // 成员变量
    public String name;
    private int age = 18;
    private double salary = 10000;


    private boolean flag;

    private boolean isMale;

    public boolean isMale() {
        return isMale;
    }

    public boolean isFlag() {
        return flag;
    }

    // 打印基本信息的成员方法
    public void info() {
        System.out.println("员工信息: name:" + name + " 年龄:" + age
                + " 工资: " + salary);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 100) {
            this.age = age;
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        if (salary >= 10000 && salary <= 15000) {
            this.salary = salary;
        }

    }
}
