package org.example.q4;

public class Employee {
    private String id;
    private int sum_money;

    public Employee() {
    }

    public Employee(String id, int sum_money) {
        this.id = id;
        this.sum_money = sum_money;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return sum_money
     */
    public int getSum_money() {
        return sum_money;
    }

    /**
     * 设置
     * @param sum_money
     */
    public void setSum_money(int sum_money) {
        this.sum_money = sum_money;
    }

    public String toString() {
        return "Employee{id = " + id + ", sum_money = " + sum_money + "}";
    }
}
