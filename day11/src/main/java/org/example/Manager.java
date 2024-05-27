package org.example;

public class Manager extends Employee{
    private int ex_price;

    public int getEx_price() {
        return ex_price;
    }

    public void setEx_price(int ex_price) {
        this.ex_price = ex_price;
    }

    public Manager(String name, int age, int salary, int ex_price) {
        super(name, age, salary);
        this.ex_price = ex_price;
    }

    public Manager(int ex_price) {
        this.ex_price = ex_price;
    }


    public void work(){
        System.out.println("姓名为" + super.getName() + ", 年龄为"
        + super.getAge() + ", 工资为" + super.getSalary()
        + ", 奖金为" + ex_price + "的项目经理正在分配任务!");
    }
}
