package org.example;

public class Product {
    private String id;
    private String name;
    private int price;
    private int storage;


    public Product() {
    }

    public Product(String id, String name, int price, int storage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.storage = storage;
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
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 获取
     * @return storage
     */
    public int getStorage() {
        return storage;
    }

    /**
     * 设置
     * @param storage
     */
    public void setStorage(int storage) {
        this.storage = storage;
    }


}
