package org.example;

public class Coder extends Employee{
    public Coder(String name, int age, int salary) {
        super(name, age, salary);
    }

    public Coder() {
    }

    public void work(){
        System.out.println("姓名为" + super.getName() +", 年龄为"
        + super.getAge() + ", 工资为" + super.getSalary() +
                "的程序员正在写代码!");
    }
}
