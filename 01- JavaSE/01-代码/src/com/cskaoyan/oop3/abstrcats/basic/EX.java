package com.cskaoyan.oop3.abstrcats.basic;


/*
        公司将员工分为三类，普通员工负责杂项工作，程序员负责技术开发，经理负责统筹规划

        1.普通员工包含3个属性：姓名、工号以及工资，行为是工作
        2.程序员包含3个属性：姓名、工号以及工资，行为是工作和加班（overtime work）
        3.经理包含4个属性：姓名、工号、工资以及奖金（bonus），行为是工作
 */
public class EX {

    public static void main(String[] args) {

        BaseEmployee employee = null;

        employee = new Employee("zs", 1, 15000);
        employee.printStaff();
        employee.work();


        employee = new Coder("lisi", 2, 30000);
        employee.printStaff();
        Coder coder = (Coder) employee;
        employee.work();
        coder.moreWork();

        employee = new Manager("ww", 3, 50000, 50000);
        employee.printStaff();
        employee.work();

    }
}

abstract class BaseEmployee {

    private String name;

    private int workId;

    private double salary;

    public BaseEmployee(String name, int workId, double salary) {
        this.name = name;
        this.workId = workId;
        this.salary = salary;
    }

    public abstract void work();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // 定义打印属性的方法,子类可以选择直接使用,也可以选择重写
    public void printStaff() {
        System.out.println("id是" + workId + "的员工,姓名是" + name + ",Ta的工资是" + salary);
    }
}

// 普通员工
class Employee extends BaseEmployee {

    public Employee(String name, int workId, double salary) {
        // 调用抽象父类构造方法
        super(name, workId, salary);
    }

    @Override
    public void work() {
        System.out.println("干最累的活");
    }

}

class Coder extends BaseEmployee {


    public Coder(String name, int workId, double salary) {
        super(name, workId, salary);
    }

    @Override
    public void work() {
        System.out.println("写代码");
    }


    public void moreWork() {
        System.out.println("996, 福报，加班，蹭公司电");
    }
}

class Manager extends BaseEmployee {

    public Manager(String name, int workId, double salary, double bonus) {
        super(name, workId, salary);
        this.bonus = bonus;
    }

    // 奖金
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("陪客户吃喝玩乐");
    }

    @Override
    public void printStaff() {
        System.out.println("id是" + getWorkId() + "的员工,姓名是" + getName() + ",Ta的工资是" + (getSalary() + bonus));
    }
}
