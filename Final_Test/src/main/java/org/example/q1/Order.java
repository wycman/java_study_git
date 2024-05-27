package org.example.q1;

import java.time.LocalDateTime;

public class Order {
    private String id;
    private String name;
    private LocalDateTime l_time;
    private double price;

    public Order() {
    }

    public Order(String id, String name, LocalDateTime l_time, double price) {
        this.id = id;
        this.name = name;
        this.l_time = l_time;
        this.price = price;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return l_time
     */
    public LocalDateTime getL_time() {
        return l_time;
    }

    /**
     * 设置
     * @param l_time
     */
    public void setL_time(LocalDateTime l_time) {
        this.l_time = l_time;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Order{id = " + id + ", name = " + name + ", l_time = " + l_time + ", price = " + price + "}";
    }
}
