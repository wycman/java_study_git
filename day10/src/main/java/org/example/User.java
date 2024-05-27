package org.example;

public class User {
    private String username;
    private String password;

    private String id;
    private String telephoneNumber;


    public User() {
    }

    public User(String username, String password, String id, String telephoneNumber) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * 设置
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + ", id = " + id + ", telephoneNumber = " + telephoneNumber + "}";
    }
}
